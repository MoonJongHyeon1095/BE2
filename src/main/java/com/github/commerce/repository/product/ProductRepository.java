package com.github.commerce.repository.product;

import com.github.commerce.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value="SELECT p FROM Product p " +
            "WHERE p.name LIKE :searchToken " +
            "ORDER BY CASE " +
            " WHEN :sortBy = 'price' THEN p.price " +
            " WHEN :sortBy = 'createdAt' THEN p.createdAt " +
            " ELSE p.price END")
    List<Product> searchProduct(
            @Param("searchToken")String searchToken,
            @Param("sortBy")String sortBy,
            @Param("pageable")Pageable pageable
    );

    @Query(value = "SELECT p FROM Product p " +
            "WHERE p.productCategory = :productCategory " +
            "AND p.ageCategory =:ageCategory " +
            "AND p.genderCategory = :genderCategory " +
            "ORDER BY CASE " +
            " WHEN :sortBy = 'price' THEN p.price " +
            " WHEN :sortBy = 'createdAt' THEN p.createdAt " +
            " ELSE p.price END")
    List<Product> findByCategoryTab(
            @Param("inputProductCategory")String productCategory,
            @Param("inputAgeCategory")String ageCategory,
            @Param("inputGenderCategory")String genderCategory,
            @Param("sortBy")String sortBy
    );
}
