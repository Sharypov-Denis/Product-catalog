package den.product.util;

import den.product.model.Products;

public class ValidationUtil {

    public static void checkNewProduct(Products products) {
        if (!products.isNew()) {
            throw new RuntimeException(products + " must be new (id=null)");
        }
    }
}
