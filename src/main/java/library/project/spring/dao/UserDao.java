package library.project.spring.dao;

import library.project.spring.dao.inter.IUserDao;
import library.project.spring.model.User;
import library.project.spring.sqls.Selects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class UserDao implements IUserDao {
    @Autowired
    DataSource dataSource;

    @Override
    public List<User> getUserList() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql= Selects.getUserList;
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public String getUserByUsername(String username) throws Exception {
        JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);
        String sql=Selects.getUserByUserName;
        return jdbcTemplate.queryForObject(sql, new Object[]{username},String.class);
    }
}
