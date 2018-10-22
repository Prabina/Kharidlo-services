package com.kharidlo.service.product.repository;

import com.kharidlo.service.product.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends CrudRepository<Product, Integer> {

    @Query("select p from Product p where p.title= :title")
    public Iterable<Product> search(@Param("title") String searchKey);
}
