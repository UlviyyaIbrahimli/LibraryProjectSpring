package library.project.spring.dao.inter;

import library.project.spring.model.User;

import java.util.List;

public interface IUserDao {
    List<User> getUserList() throws Exception;
    String getUserByUsername(String username) throws Exception;

}
