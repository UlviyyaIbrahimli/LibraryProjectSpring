package library.project.spring.dao.inter;

import library.project.spring.model.Author;
import library.project.spring.model.Book;

import java.util.List;

public interface IAuthorDao {
    List<Author> getAuthorList() throws Exception;
List<Book> getBooksOfAuthor(Long idAuthor) throws Exception;
Author getAuthorById(Long idAuthor) throws Exception;
List<Author> searchAuthor(String searchTxt) throws Exception;
}
