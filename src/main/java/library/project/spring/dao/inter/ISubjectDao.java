package library.project.spring.dao.inter;

import library.project.spring.model.Book;
import library.project.spring.model.Subject;

import java.util.List;

public interface ISubjectDao {
    Integer allSubjectCount() throws Exception;
    List<Subject>getAllSubjectList() throws Exception;
    Integer booksCountBySubject(Long subjectId) throws Exception;
    Subject getSubjectById(Long idSubject) throws Exception;
    List<Book> bookOfSubject(Long idSubject);
    List<Subject>searchSubject(String searchTxt) throws  Exception;
}
