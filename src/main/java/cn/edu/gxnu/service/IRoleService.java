package cn.edu.gxnu.service;

import cn.edu.gxnu.bean.Roles;

import java.util.List;

public interface IRoleService {
    Roles getRole(String rolesId);
    List<Roles> viewRole();
}
