package br.com.productapp.controller;

import br.com.productapp.service.ProductService;
import br.com.productapp.dto.ProductDTO;
import br.com.productapp.entity.Product;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @ApiOperation(value = "listar todos produtos")
    public ResponseEntity<Iterable<Product>> findAll(){
        return new ResponseEntity<Iterable<Product>>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "buscar produto pelo id")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Long id) {
        return new ResponseEntity<ProductDTO>(productService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "remover um produto pelo id")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "salvar um novo produto")
    public ResponseEntity<?> save(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product),HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    @ApiOperation(value = "atualizar um produto")
    public ResponseEntity<?> update(@RequestBody Product product,@PathVariable Long id) {
        productService.update(product,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
