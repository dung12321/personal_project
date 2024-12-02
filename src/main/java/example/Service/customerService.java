package example.Service;

import example.Entities.customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface customerService {


    List<customer> findAll();

    customer findById(int id);

    void save(customer customer);

    void delete(customer customer);

    void update(customer customer);

    void delete(int id);
}
