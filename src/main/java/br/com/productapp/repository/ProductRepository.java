
package br.com.productapp.repository;

import br.com.productapp.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long>{}


