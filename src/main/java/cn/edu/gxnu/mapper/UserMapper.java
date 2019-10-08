package cn.edu.gxnu.mapper;

import cn.edu.gxnu.bean.Permission;
import cn.edu.gxnu.bean.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface UserMapper {
   User login(@Param("username") String username, @Param("password") String password);
   List<Permission> getMenu(String usersId);
   List<User> viewUser();
   void addUser(User user);
   void deleteUser(String usersId);
   void updateUser(User user);
}
