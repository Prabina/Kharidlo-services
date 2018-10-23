package com.kharidlo.service.product.repository;

import com.kharidlo.service.product.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends CrudRepository<Product, Integer> {

//    @Query("select p from Product p where p.title= :title")
//    List<Product> search(@Param("title") String searchKey);

    List<Product> findByTitleContainsIgnoreCase(String titlePart);
}
