package library.project.spring.dao.inter;

import library.project.spring.model.Role;

import java.util.List;

public interface IRoleDao {
    List<Role> getRoleList() throws Exception;

}
