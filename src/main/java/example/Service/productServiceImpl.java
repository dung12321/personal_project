package example.Service;

import example.DAO.productRepo;
import example.Entities.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class productServiceImpl implements productService {
    @Autowired
    productRepo productRepo;
    @Override
    public product getProduct(int id) {
        return productRepo.getOne(id);
    }
    @Override
    public List<product> getAllProducts() {
        return productRepo.findAll();
    }
    @Override
    public product addProduct(product product) {
        return productRepo.save(product);
    }
    @Override
    public product updateProduct(product product) {
        return productRepo.save(product);
    }
    @Override
    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }
    @Override
    public void deleteAllProducts() {
        productRepo.deleteAll();
    }
    @Override
    public product findById(int id) {
        Optional<product> product = productRepo.findById(id);
        return product.orElse(null);
    }
}
