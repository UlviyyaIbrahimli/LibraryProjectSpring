package library.project.spring.controller;

import library.project.spring.dao.inter.IAuthorDao;
import library.project.spring.model.Author;
import library.project.spring.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "lab")
public class AuthorController {
    @Autowired
    IAuthorDao authorDao;

    @RequestMapping(value = "authorList", method = RequestMethod.GET)
    public ModelAndView authorList(){
        ModelAndView model = new ModelAndView("author/authorList");
        try {
            List<Author> authorList = authorDao.getAuthorList();
            model.addObject("authorList", authorList);
            System.out.println(authorList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  model;

    }

    @RequestMapping(value = "/authorMoreInfo", method = RequestMethod.POST, consumes = "application/json", headers = "content-type=application/x-www-form-urlencoded")
    public ModelAndView authorMoreInfo(Long idAuthor){
        ModelAndView model= new ModelAndView("author/authorMoreInfo");
        try {
             List<Book> bookList= authorDao.getBooksOfAuthor(idAuthor);
             Author author= authorDao.getAuthorById(idAuthor);
             model.addObject("author",author);
             model.addObject("bookList",bookList);
                      }  catch (Exception e){
            e.printStackTrace();
        }

        return  model;
    }
@RequestMapping(value = "/searchAuthor", method = RequestMethod.POST, consumes = "application/json",headers = "content-type=application/x-www-form-urlencoded")
    public ModelAndView searchAuthor(String searchTxt){
        ModelAndView model= new ModelAndView("author/authorList");
        try {
            List<Author> authorList = authorDao.searchAuthor(searchTxt);
            model.addObject("authorList", authorList);
            model.addObject("searchTxt",searchTxt);
            System.out.println("fghbjk     "+authorList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  model;
}
}
