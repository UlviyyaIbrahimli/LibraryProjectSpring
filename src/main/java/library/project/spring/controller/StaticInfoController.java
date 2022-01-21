package library.project.spring.controller;

import library.project.spring.dao.inter.IBookDao;
import library.project.spring.dao.inter.IReaderDao;
import library.project.spring.dao.inter.ISubjectDao;
import library.project.spring.enumPack.StatusEnum;
import library.project.spring.model.Book;
import library.project.spring.model.Reader;
import library.project.spring.model.Subject;
import library.project.spring.request.ReqUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/lab")
public class StaticInfoController {
    @Autowired
    ISubjectDao subjectDao;
    @Autowired
    IReaderDao readerDao;
    @Autowired
    IBookDao bookDao;

    @GetMapping("/allSubjectList")
    public ModelAndView getAllSubjectList() {
        ModelAndView model = new ModelAndView("staticMoreInfo/allSubjectList");
        try {
            List<Subject> subjectList = subjectDao.getAllSubjectList();
            model.addObject("subjectList", subjectList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }


    @GetMapping("/randomBookList")
    public ModelAndView allBookList() {
        ModelAndView model = new ModelAndView("staticMoreInfo/randomBooksList");
        try {
            List<Book> bookList = bookDao.getRandomBookList();
            model.addObject("randomBookList", bookList);
            List<Subject> subjectListForCombo = subjectDao.getAllSubjectList();
            model.addObject("subjectList", subjectListForCombo);
            Integer allBookCount = bookDao.getAllBookCount();
            model.addObject("allBookCount", allBookCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @GetMapping("/readerMoreInfo")
    public ModelAndView readerMoreInfo() {
        ModelAndView model = new ModelAndView("reader/readerMoreInfo");
        try {
            Integer registrationReaderCount = readerDao.getRegistrationReaderCount();
            model.addObject("registrationReaderCount", registrationReaderCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }


    @RequestMapping(value = "/libraryHistory", method = RequestMethod.GET)
    public ModelAndView libraryHistory() {
        ModelAndView model = new ModelAndView("static/libraryHistory");
        return model;
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public ModelAndView signIn() {
        ModelAndView model = new ModelAndView("user/signIn");
        System.out.println("ckdjnfbvfvbhfv");
        model.addObject("a", "a");
        return model;
    }

    @RequestMapping(value = "/checkReader", method = RequestMethod.POST, consumes = "application/json", headers = "content-type=application/x-www-form-urlencoded")
    public ModelAndView checkReader(@RequestBody ReqUser reqUser) {
        ModelAndView model = new ModelAndView("static/indexReader");
        try {
            Reader reader = readerDao.checkReader(reqUser);
            if (reader == null) {
                model.addObject("reader", null);
                return null;
            } else {
                model.addObject("username", reqUser.getUserName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @RequestMapping(value = "/createNewAccount", method = RequestMethod.GET)
    public ModelAndView createNewAccount() {
        ModelAndView model = new ModelAndView("user/createNewAccount");
        model.addObject("status", StatusEnum.values());
        return model;
    }

    @RequestMapping(value = "/createNewAccountReader", method = RequestMethod.POST)
    public ResponseEntity<Reader> createNewAccountReader(@RequestBody Reader reader) {
        try {
            readerDao.createNewReader(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(reader, HttpStatus.ACCEPTED);
    }
    @RequestMapping(value = "/signUp", method = RequestMethod.POST,consumes = "application/json", headers = "content-type=application/x-www-form-urlencoded")
    public RedirectView signUp(){
        return  new RedirectView("/library/lab/home");
    }


    @RequestMapping(value = "/newBooks",method = RequestMethod.GET)
    public  ModelAndView newBooks(){
        ModelAndView model= new ModelAndView("book/advSearchResult");
        try{
       List<Book> bookList= bookDao.booksForDesctiptionRandom("detective");
        model.addObject("bookList",bookList);}
        catch (Exception e){
            e.printStackTrace();
        }
        return  model;
    }
}
