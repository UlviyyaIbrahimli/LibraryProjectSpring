package library.project.spring.dao;

import library.project.spring.dao.inter.IBookDao;
import library.project.spring.model.Book;
import library.project.spring.model.SearchParameter;
import library.project.spring.sqls.SearchConstants;
import library.project.spring.sqls.Selects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.QueryTimeoutException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookDao implements IBookDao {
    @Autowired
    DataSource dataSource;
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");


    private String addParamToSql(String paramName, String paramValue, List<Object> params) {
        if (paramValue == null || paramValue.trim().isEmpty())
            return "";

        params.add("%" + paramValue + "%");
        return " and " + paramName + " like ? ";
    }

    private String addParamToSqlFullText(String paramName, String paramValue, List<Object> params) {
        if (paramValue == null || paramValue.trim().isEmpty())
            return "";

        params.add(paramValue);
        return " and match(" + paramName + ") against(?) ";
    }

    private String addParamToSqlEqual(String paramName, String paramValue, List<Object> params) {
        if (paramValue == null || paramValue.trim().isEmpty())
            return "";

        params.add(paramValue);
        return " and " + paramName + " = ? ";
    }

    private String addParamToSql(String paramName, int paramValue, List<Object> params) {
        if (paramValue < 0)
            return "";

        params.add(paramValue);
        return " and " + paramName + " = ? ";
    }

    private Date getDateFromStr(String dateStr) {
        try {
            return new Date(sdf.parse(dateStr).getTime());
        } catch (ParseException e) {
            return null;
        }
    }

    @Override
    public Integer getAllBookCount() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = Selects.getAllBookCount;
        return jdbcTemplate.queryForObject(sql, Integer.class);

    }

    @Override
    public Integer getMoreReaderBookCount() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = Selects.getMoreReaderBookCount;
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public List<Book> getRandomBookList() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = Selects.getRandomBookList;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public List<Book> newBookList() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = Selects.newBookList;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public List<Book> getPopularBookList() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = Selects.getPopularBookList;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public List<Book> booksForDesctiptionRandom(String subject) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = Selects.booksForSubjectRandom;
        return jdbcTemplate.query(sql, new Object[]{subject}, new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public List<Book> getBookListWeLove() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = Selects.getBookListWeLove;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public List<Book> advSearchBook(SearchParameter searchParameter) throws Exception {
        try {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.setQueryTimeout(300);
            String paramSql = " ";
            String paramSqlBill = " ";
            List<Object> params = new ArrayList<Object>();
            if (searchParameter.getPublisher() != null && !searchParameter.getPublisher().isEmpty()) {
                paramSql += addParamToSql("b.publisher", searchParameter.getPublisher(), params);
            }
            if (searchParameter.getAuthor() != null && !searchParameter.getAuthor().isEmpty()) {
                paramSql += addParamToSql("a.full_name", searchParameter.getAuthor(), params);
            }
            if (searchParameter.getTitle() != null && !searchParameter.getTitle().isEmpty()) {
                paramSql += addParamToSql("b.title", searchParameter.getTitle(), params);
            }
            if (searchParameter.getIsbn() != null) {
                paramSql += addParamToSql("b.isbn", searchParameter.getIsbn(), params);
            }

            if (searchParameter.getPublishDate() != null && !searchParameter.getPublishDate().trim().isEmpty()) {

                Date dt = getDateFromStr(searchParameter.getPublishDate());
                if (dt != null) {
                    paramSql += " and b.publisher_date >= ? ";
                    params.add(dt);
                }
            }

            if (searchParameter.getSubjects() != null  && !searchParameter.getSubjects().isEmpty()) {
                paramSql += addParamToSql("s.subject", searchParameter.getSubjects(), params);

//                paramSqlBill += addParamToSqlEqual("s.id_subject", "" + searchParameter.getSubjectId().intValue(),
//                        params);
//                paramSql += " AND s.id_subject in(" + searchParameter.getSubjectId() + ")";
            }
            String prms = "";
            for (Object obj : params) {
                prms += obj + " ";
            }

            String querySql = SearchConstants.advBook
                    .replace("[paramSql]", paramSql)
                    .replace("[paramSqlBill]", paramSqlBill);
            System.out.println(querySql + " queryFor search");
         List<Book>   bookList = jdbcTemplate.query(querySql, params.toArray(),
                    new BeanPropertyRowMapper(Book.class));
            System.out.println(" books    "+jdbcTemplate.query(querySql, params.toArray(),
                    new BeanPropertyRowMapper(Book.class)));

            return bookList;
        } catch (QueryTimeoutException ex) {
//            LOGGER.error("Sql timeout exception", ex);
            return null;
        }
    }

    @Override
    public List<Book> searchBookAllParams(String searchingWord) throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = SearchConstants.searchBookAllParams;
        searchingWord="%"+searchingWord+"%";
        List<Book> bookList =
                jdbcTemplate.query(sql, new Object[]{searchingWord,searchingWord,searchingWord, searchingWord,searchingWord,
                searchingWord,searchingWord,searchingWord,searchingWord}, new BeanPropertyRowMapper<>(Book.class));
        return bookList;
    }

    @Override
    public Book getBookById(Long idBook) throws Exception {
        JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);
        String sql=Selects.getBookById;
        List<Book> bookList= jdbcTemplate.query(sql, new Object[]{idBook}, new BeanPropertyRowMapper<>(Book.class));
        if (!bookList.isEmpty()){
            return  bookList.get(0);
        }
        return null;

    }


}
