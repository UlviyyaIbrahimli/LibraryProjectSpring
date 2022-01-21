package library.project.spring.controller;

import library.project.spring.dao.inter.*;
import library.project.spring.model.Book;
import library.project.spring.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/lab")
public class MainController {

    @Autowired
    IUserDao userDao;
    @Autowired
    IRoleDao roleDao;
    @Autowired
    IBookDao bookDao;
    @Autowired
    ISubjectDao subjectDao;
    @Autowired
    IReaderDao readerDao;



    @GetMapping("/403")
    public ModelAndView accessDenied() {
        ModelAndView model = new ModelAndView("403");
        return model;
    }

    @GetMapping(value = {"/", "/home"})
    public ModelAndView main() throws Exception {
        ModelAndView model = new ModelAndView("index");
        List<Book>newBookList=bookDao.newBookList();
        model.addObject("newBookList",newBookList);
        List<Book> popularBookList=bookDao.getPopularBookList();
        model.addObject("popularBookList",popularBookList);
        model.addObject("detectiveBookList",bookDao.booksForDesctiptionRandom("detective"));
        model.addObject("romanceBookList",bookDao.booksForDesctiptionRandom("romance"));
        List<Book> bookListWeLove= bookDao.getBookListWeLove();
        model.addObject("bookListWeLove",bookListWeLove);
        model.addObject("kidsBookList",bookDao.booksForDesctiptionRandom("kids"));
        model.addObject("pressBookList",bookDao.booksForDesctiptionRandom("pressBookList"));
        List<Subject> subjectList= subjectDao.getAllSubjectList();
        model.addObject("subjectList",subjectList);
        return model;
    }



}
