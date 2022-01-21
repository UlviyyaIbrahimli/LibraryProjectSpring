package library.project.spring.dao.inter;

import library.project.spring.model.Book;
import library.project.spring.model.SearchParameter;

import java.util.List;

public interface IBookDao {
    Integer getAllBookCount() throws Exception;

    Integer getMoreReaderBookCount() throws Exception;

    List<Book> getRandomBookList() throws Exception;

    List<Book> newBookList() throws Exception;

    List<Book> getPopularBookList() throws Exception;

    List<Book> booksForDesctiptionRandom(String subject) throws Exception;

    List<Book> getBookListWeLove() throws Exception;

    List<Book> advSearchBook(SearchParameter myModel) throws Exception;
    List<Book> searchBookAllParams(String searchingWord) throws Exception;
    Book getBookById(Long idBook) throws Exception;
}
