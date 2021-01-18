package den.product.repository;

import den.product.model.Products;
import den.product.util.ProductValidation;

import java.util.List;

public interface ProductsRepository {

    Products save(Products products);

    Products update(Products products);

    Products get(Integer id);

    void delete(Integer id);

    List<Products> getAll();

    List<Products> findProductsByName(String name);

    Products findOneProductsByName(String name);
}
