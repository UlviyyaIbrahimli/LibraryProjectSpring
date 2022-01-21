package library.project.spring.dao;

import library.project.spring.dao.inter.IReaderDao;
import library.project.spring.model.Reader;
import library.project.spring.request.ReqUser;
import library.project.spring.sqls.Inserts;
import library.project.spring.sqls.Selects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class ReaderDao implements IReaderDao {
    @Autowired
    DataSource dataSource;

    @Override
    public Integer getRegistrationReaderCount() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = Selects.getRegistrationReaderCount;
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public Reader checkReader(ReqUser reqUser) throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = Selects.checkUser;
        List<Reader> readerList =
                jdbcTemplate.query(sql, new Object[]{reqUser.getUserName(), reqUser.getPassword()}, new BeanPropertyRowMapper<>(Reader.class));
        if (!readerList.isEmpty()) {
            return readerList.get(0);
        }
        return null;
    }

    @Override
    public void createNewReader(Reader reader) throws Exception {
        JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);
        String sql= Inserts.createNewUSer;
        jdbcTemplate.update(sql, new Object[]{reader.getName(), reader.getSurname(),reader.getUsername(),
                reader.getPassword(),reader.getStatusId()});
    }
}
