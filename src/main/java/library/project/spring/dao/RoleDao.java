package library.project.spring.dao;

import library.project.spring.dao.inter.IRoleDao;
import library.project.spring.model.Role;
import library.project.spring.sqls.Selects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class RoleDao implements IRoleDao {
    @Autowired
    DataSource dataSource;

    @Override
    public List<Role> getRoleList() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = Selects.getRoleList;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Role.class));
    }
}
