package cn.edu.gxnu.controller;

import cn.edu.gxnu.bean.Permission;
import cn.edu.gxnu.bean.User;
import cn.edu.gxnu.service.IUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    IUserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String username, String password, HttpSession session){
        //System.out.println(username);
        //System.out.println(password);
        User user=userService.login(username,password);
        session.setAttribute("user",user);
        if(user!=null){
            return "redirect:/index.html";
        }else{
            return "redirect:/login.html";
        }
    }

   @RequestMapping("/getUserInfo")
    public @ResponseBody User getUserInfo(HttpSession session){
        User user= (User) session.getAttribute("user");
        return user;
    }

    @RequestMapping("/getMenu")
    public @ResponseBody List getMenu(String usersId){
        List<Permission> permissionList=userService.getMenu(usersId);
        return permissionList;
    }

    @RequestMapping("/viewUser")
    public @ResponseBody List<User> viewUser(){
        PageHelper.startPage(1,6);
        Page<User> userList=(Page<User>)userService.viewUser();
        return userList;
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public @ResponseBody void addUser(String username){
        User user=new User();
        user.setUsername(username);
        user.setUsersId(UUID.randomUUID().toString().replace("-",""));
        userService.addUser(user);
    }

    @RequestMapping("/deleteUser")
    public @ResponseBody void deleteUser(String usersId){
        userService.deleteUser(usersId);
    }

    @RequestMapping("/updateUser")
    public @ResponseBody void updateUser(String usersId,String username){
        User user=new User();
        user.setUsername(username);
        user.setUsersId(usersId);
        userService.updateUser(user);
    }

}