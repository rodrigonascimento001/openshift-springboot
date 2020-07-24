package com.br.productapp.service;

import com.br.productapp.entity.Product;
import com.br.productapp.enums.CategoryEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class ProductService {
//    private final ProductRepository productRepository;

    public List<Product> findAll(){
//       return productRepository.findAll();
        log.info("chamando o metodo findall...");
        Product p1 = new Product(1L,"Notebook", CategoryEnum.ELETRONICS,3000.50);
        Product p2 = new Product(2L,"Notebook", CategoryEnum.ELETRONICS,3000.50);
        Product p3 = new Product(3L,"Notebook", CategoryEnum.ELETRONICS,3000.50);
        List<Product> list = Arrays.asList(p1,p2,p3);
        return list;
    }
/*

    public ProductDTO findById(Long id) {
        Optional<Product> obj = productRepository.findById(id);
        return (obj.map(x -> x.toDto()).orElseThrow(() -> new ResourceNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Product.class.getName())));
    }

    @Transactional
    public Product save(Product product) {
        return  productRepository.save(product);
    }

    public void delete(Long id){
        verifyIfProductExists(id);
        productRepository.deleteById(id);
    }

    public void update(Product productNew, Long id) {
        productRepository.findById(id).map(p -> {
            p.setCategory(productNew.getCategory() );
            p.setName(productNew.getName());
            p.setPrice(productNew.getPrice());
            return productRepository.save(p);
        }).orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Product.class.getName()));
    }

    private void verifyIfProductExists(Long id){
        if (productRepository.findById(id) == null)
            throw new ResourceNotFoundException("Student not found for ID: "+id);
    }

*/

}
