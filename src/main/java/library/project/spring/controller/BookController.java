package library.project.spring.controller;

import library.project.spring.dao.inter.IBookDao;
import library.project.spring.dao.inter.ISubjectDao;
import library.project.spring.model.Book;
import library.project.spring.model.SearchParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;


@RestController
@RequestMapping("/lab")
public class BookController {

    @Autowired
    IBookDao bookDao;
    @
            Autowired
    ISubjectDao subjectDao;

    @GetMapping(value = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> getTermsConditions(@RequestParam(name="url") String url,@RequestParam(name = "title")String title) throws Exception {
       String filePath = url;
        String fileName = title;
        System.out.println("rfer  "+url+" rfef  "+title);
        File file = new File(filePath+ fileName);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=" + fileName);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/pdf"))
                .body(resource);
    }


    @RequestMapping(value = "/advSearchBooksAllParams", method = RequestMethod.POST, consumes = "application/json", headers = "content-type=application/x-www-form-urlencoded")
    public ModelAndView advSearchBooks(String searchTxt) {
        ModelAndView view = null;
        try {
            List<Book> bookList = bookDao.searchBookAllParams(searchTxt);
            view = new ModelAndView("book/advSearchResult");
            view.addObject("bookList", bookList);
            view.addObject("searchTxt", searchTxt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }


    @RequestMapping(value = "/advSearchForParamsIndex", method = RequestMethod.GET)
    public ModelAndView advSearchForParamsIndex() {
        ModelAndView model = new ModelAndView("static/advancedSearchIndex");
        try {
            model.addObject("subject", subjectDao.getAllSubjectList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }


    @RequestMapping(value = "/advSearchBookForParams", method = RequestMethod.GET)
    public ModelAndView advSearchBookForParams(HttpServletRequest request) {
        ModelAndView model = new ModelAndView("book/advSearchResultData");
        SearchParameter myModel = new SearchParameter();
        try {
            if (request.getParameter("publisherDate") != "" && !request.getParameter("publisherDate").isEmpty())
                myModel.setPublishDate(request.getParameter("publisherDate"));
            if (request.getParameter("subject") != null && !request.getParameter("subject").isEmpty())
                myModel.setSubjects(request.getParameter("subject"));
            if (request.getParameter("title") != null && !request.getParameter("title").isEmpty()) {
                myModel.setTitle(request.getParameter("title"));
            }
            if (request.getParameter("isbn") != null && !request.getParameter("isbn").isEmpty()) {
                myModel.setIsbn(request.getParameter("isbn"));
            }
            if (request.getParameter("author") != null && !request.getParameter("author").isEmpty()) {
                myModel.setAuthor(request.getParameter("author"));
            }
            if (request.getParameter("publisher") != null && !request.getParameter("publisher").isEmpty()) {
                myModel.setPublisher(request.getParameter("publisher"));
            }
            List<Book> bookList = bookDao.advSearchBook(myModel);
            if (!bookList.isEmpty()) {
                model.addObject("bookList", bookList);
            } else {
                model.addObject("error", "You have passed the deadline to complete your request!");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return model;
    }


}