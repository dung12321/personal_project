package example.Service;

import example.Entities.userP;

import java.util.List;

public interface userPService {
    userP getUser(int id);

    List<userP> getAllUsers();

    userP addUser(userP user);

    userP updateUser(userP user);

    void deleteUser(int id);

    void deleteAllUser();

    userP findByAccount(String name);
}
