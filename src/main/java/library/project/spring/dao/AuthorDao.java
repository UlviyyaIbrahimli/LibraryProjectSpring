package library.project.spring.dao;

import library.project.spring.dao.inter.IAuthorDao;
import library.project.spring.model.Author;
import library.project.spring.model.Book;
import library.project.spring.sqls.SearchConstants;
import library.project.spring.sqls.Selects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service


public class AuthorDao implements IAuthorDao {
    @Autowired
    DataSource dataSource;
    @Override
    public List<Author> getAuthorList() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql= Selects.getAuthorList;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Author.class));
    }

    @Override
    public List<Book> getBooksOfAuthor(Long idAuthor) throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql=Selects.getBooksOfAuthor;
        return jdbcTemplate.query(sql, new Object[]{idAuthor}, new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public Author getAuthorById(Long idAuthor) throws Exception {
        String sql=Selects.getAuthorById;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Author> authorList = jdbcTemplate.query(sql, new Object[]{idAuthor}, new BeanPropertyRowMapper<>(Author.class));
        if (!authorList.isEmpty()){
            return authorList.get(0);
        }
        return null;
    }

    @Override
    public List<Author> searchAuthor(String searchTxt) throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql= SearchConstants.searchAuthor;
        searchTxt="%"+searchTxt+"%";
        System.out.println("dffrgtf  "+searchTxt);
        System.out.println("sdesfef  "+sql);
        return jdbcTemplate.query(sql, new Object[]{searchTxt,searchTxt,searchTxt,searchTxt}, new BeanPropertyRowMapper<>(Author.class));
    }
}
