package cn.edu.gxnu.mapper;

import cn.edu.gxnu.bean.Roles;

import java.util.List;

public interface RoleMapper {
    Roles getRole(String rolesId);
    List<Roles> viewRole();
}
