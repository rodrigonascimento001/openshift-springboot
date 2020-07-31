package br.com.productapp.entity;

import br.com.productapp.dto.ProductDTO;
import br.com.productapp.enums.CategoryEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private CategoryEnum category;
    private double price;

    public Product(ProductDTO product){
        if(product != null){
            this.id = product.getId();
            this.name = product.getName();
            this.price = product.getPrice();
            this.category = product.getCategory();
        }
    }

    public ProductDTO toDto() {
        ProductDTO product = new ProductDTO();
        product.setId(this.id);
        product.setName(this.name);
        product.setCategory(this.category);
        product.setPrice(this.price);

        return product;
    }


}

