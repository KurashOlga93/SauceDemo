package additionalHomework.Task10;

import java.util.ArrayList;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product(1, "Apple", "Food", 55));
        list.add(new Product(2, "Bread", "Food", 60));
        list.add(new Product(3, "Milk", "Food", 47));
        list.add(new Product(4, "TV", "Technic", 2000));
        list.add(new Product(5, "Iphone", "Technic", 1250));
        list.add(new Product(6, "Banana", "Food", 50));
        list.add(new Product(7, "Xiaomi", "Technic", 800));
        list.add(new Product(8, "Sumsung", "Technic", 500));

        ProductMethod filter = new ProductMethod();

        System.out.println(filter.filterProducts(list, "Technic", 1250));

    }
}
