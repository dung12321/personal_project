package example.Service;

import example.DAO.userPRepo;
import example.Entities.userP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userPServiceImpl implements userPService {
    @Autowired
    userPRepo userRepo;
    @Override
    public userP getUser(int id) {
        return userRepo.getOne(id);
    }
    @Override
    public List<userP> getAllUsers() {
        return userRepo.findAll();
    }
    @Override
    public userP addUser(userP user) {
        return userRepo.save(user);
    }
    @Override
    public userP updateUser(userP user) {
        return userRepo.save(user);
    }
    @Override
    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }
    @Override
    public void deleteAllUser() {
        userRepo.deleteAll();
    }
    public void findById(int id) {
        userRepo.findById(id);
    }
    @Override
    public userP findByAccount(String name) {
        return userRepo.findByAccount(name);
    }
}
