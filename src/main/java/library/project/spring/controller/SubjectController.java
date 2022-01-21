package library.project.spring.controller;

import library.project.spring.dao.inter.ISubjectDao;
import library.project.spring.model.Book;
import library.project.spring.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/lab")
public class SubjectController {
    @Autowired
    ISubjectDao subjectDao;

    @RequestMapping(value = "/subjectList", method = RequestMethod.GET)
    public ModelAndView subjectList() {
        ModelAndView model = new ModelAndView("subject/subjectList");
        try {
            List<Subject> subjectList = subjectDao.getAllSubjectList();
            model.addObject("subject",subjectList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @RequestMapping(value = "/subjectMoreInfo", method = RequestMethod.POST, consumes = "application/json", headers = "content-type=application/x-www-form-urlencoded")
   public ModelAndView subjectMoreInfo(Long idSubject){
        ModelAndView model= new ModelAndView("subject/subjectMoreInfo");
        try {
            Subject subject= subjectDao.getSubjectById(idSubject);
            String subjectName=subject.getSubject();
            model.addObject("subject",subjectName);
            String description=subject.getDescription();
            model.addObject("description",description);
            List<Book> bookList= subjectDao.bookOfSubject(idSubject);
            model.addObject("bookList",bookList);
            Integer booksCount=subjectDao.booksCountBySubject(idSubject);
            if (booksCount==null){
                model.addObject("booksCount","0");
            }else {
                model.addObject("booksCount", subjectDao.booksCountBySubject(idSubject));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  model;
    }

    @RequestMapping(value = "/searchSubject",consumes = "application/json",headers = "content-type=application/x-www-form-urlencoded")
    public ModelAndView searchSubject(String searchTxt){
        ModelAndView model= new ModelAndView("subject/subjectList");
        try{
            List<Subject> subjectList = subjectDao.searchSubject(searchTxt);
            model.addObject("subject",subjectList);
            model.addObject("searchTxt",searchTxt);
        }catch (Exception e){
            e.printStackTrace();
        }
        return model;
    }
    @RequestMapping(value = "/contact" ,method = RequestMethod.GET)
    public ModelAndView contact(){
        ModelAndView model= new ModelAndView("static/contact");
        return model;
    }


}
