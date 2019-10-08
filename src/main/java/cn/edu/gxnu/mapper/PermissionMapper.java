package cn.edu.gxnu.mapper;

import cn.edu.gxnu.bean.Permission;

import java.util.List;

public interface PermissionMapper {
    List<Permission> getPermissions(int pageNum,int pageSize);
}
