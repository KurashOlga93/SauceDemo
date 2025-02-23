package additionalHomework.Task10;

import java.util.ArrayList;
import java.util.List;

public class ProductMethod {

    public List<Product> filterProducts(List<Product> products, String ctgr, int maxPrice ) {
        List<Product> newList = new ArrayList<>();

        for(Product product : products) {
            if(product.category.equals(ctgr) && product.price <= maxPrice) {
                newList.add(product);
            }
        }
        return newList;
    }
}
