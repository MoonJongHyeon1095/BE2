package com.github.commerce.repository.product;
import com.github.commerce.entity.mongocollection.ProductOption;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductOptionRepository extends MongoRepository<ProductOption, Integer> {
    ProductOption findProductOptionByProductId(int productId);

}