package example.Service;

import example.Entities.product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface productService {

    product getProduct(int id);

    List<product> getAllProducts();

    product addProduct(product product);

    product updateProduct(product product);

    void deleteProduct(int id);

    void deleteAllProducts();
}
