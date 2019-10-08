package cn.edu.gxnu.controller;

import cn.edu.gxnu.bean.Roles;
import cn.edu.gxnu.bean.User;
import cn.edu.gxnu.service.IRoleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/role")
@Controller
public class RoleController {
    @Autowired
    IRoleService roleService;
    @RequestMapping("/viewRole")
    public @ResponseBody
    List<Roles> viewUser(){
        PageHelper.startPage(1,6);
        Page<Roles> roleList=(Page<Roles>)roleService.viewRole();
        return roleList;
    }
}
