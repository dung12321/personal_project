//package example.Service;
//
//import example.DAO.CustomerRepo;
//import example.Entities.customer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class customerServiceImpl implements customerService {
//    @Autowired
//    private CustomerRepo customerRepo;
//
//    @Override
//    public List<customer> findAll(){
//        return customerRepo.findAll();
//    }
//    @Override
//    public customer findById(int id) {
//        return customerRepo.findById(id).get();
//    }
//    @Override
//    public void save(customer customer) {
//        customerRepo.save(customer);
//    }
//    @Override
//    public void delete(customer customer) {
//        customerRepo.delete(customer);
//    }
//    @Override
//    public void update(customer customer) {
//        customerRepo.save(customer);
//    }
//    @Override
//    public void delete(int id) {
//        customerRepo.deleteById(id);
//    }
//}
