package library.project.spring.dao;

import library.project.spring.dao.inter.ISubjectDao;
import library.project.spring.model.Book;
import library.project.spring.model.Subject;
import library.project.spring.sqls.SearchConstants;
import library.project.spring.sqls.Selects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class SubjectDao implements ISubjectDao {
    @Autowired
    DataSource dataSource;

    @Override
    public Integer allSubjectCount() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = Selects.getAllSubjectCount;
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public List<Subject> getAllSubjectList() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = Selects.getAllSubjectList;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Subject.class));
    }

    @Override
    public Integer booksCountBySubject(Long subjectId) throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = Selects.booksCountBySubject;
        return jdbcTemplate.queryForObject(sql, new Object[]{subjectId}, Integer.class);
    }

    @Override
    public Subject getSubjectById(Long idSubject) throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = Selects.getSubjectById;
        List<Subject> subjectList =
                jdbcTemplate.query(sql, new Object[]{idSubject}, new BeanPropertyRowMapper<>(Subject.class));
        if (!subjectList.isEmpty()) {
            return subjectList.get(0);
        }

        return null;
    }

    @Override
    public List<Book> bookOfSubject(Long idSubject) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql= Selects.bookOfSubject;
        return jdbcTemplate.query(sql, new Object[]{idSubject}, new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public List<Subject> searchSubject(String searchTxt) throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql= SearchConstants.searchSubject;
        searchTxt="%"+searchTxt+"%";
        return jdbcTemplate.query(sql, new Object[]{searchTxt,searchTxt},new BeanPropertyRowMapper<>(Subject.class));
    }
}
