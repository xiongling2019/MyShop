package cn.edu.gxnu.service.impl;

import cn.edu.gxnu.bean.Permission;
import cn.edu.gxnu.bean.Roles;
import cn.edu.gxnu.bean.User;
import cn.edu.gxnu.mapper.RoleMapper;
import cn.edu.gxnu.mapper.UserMapper;
import cn.edu.gxnu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class UserServiceImpl implements IUserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    @Override
    public User login(String username, String password) {
        return userMapper.login(username,password);
    }

    @Override
    public List<Permission> getMenu(String usersId) {
        return userMapper.getMenu(usersId);
    }

    @Override
    public List<User> viewUser(){
        List<User> userList=userMapper.viewUser();
        for (User user:userList){
                //System.out.println(("ID： " + user.getRolesId()));
                Roles role=roleMapper.getRole(user.getRolesId());
                //System.out.println((role.getRoleName()));
                if (role!=null){
                    user.setRole(role);
                }
            }
        return userList;
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void deleteUser(String usersId) {
        userMapper.deleteUser(usersId);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

}
