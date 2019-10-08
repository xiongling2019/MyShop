package cn.edu.gxnu.service;

import cn.edu.gxnu.bean.Permission;
import cn.edu.gxnu.bean.User;
import java.util.List;

public interface IUserService {
    User login(String username, String password);
    List<Permission> getMenu(String usersId);
    List<User> viewUser();
    void addUser(User user);
    void deleteUser(String usersId);
    void updateUser(User user);
}