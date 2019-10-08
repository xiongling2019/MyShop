package cn.edu.gxnu.service.impl;

import cn.edu.gxnu.bean.Roles;
import cn.edu.gxnu.mapper.RoleMapper;
import cn.edu.gxnu.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleServiceImpl implements IRoleService {
    @Autowired
    RoleMapper roleMapper;

    public Roles getRole(String rolesId) {
        Roles role=new Roles();
        System.out.println("roleName:   "+role.getRoleName());
        return roleMapper.getRole( rolesId);
    }

    @Override
    public List<Roles> viewRole() {
        return roleMapper.viewRole();
    }
}
