package library.project.spring.model;

import lombok.Data;

import java.util.Date;

@Data
public class Book {
    private Long idBook;
    private String title;
    private Long isbn;
    private Date publisherDate;
    private String extractDate;
    private String publisher;
    private Long subjectId;
    private String subject;
    private Float star;
    private String info;
    private String  picture;
    private String authorFullName;
    private String description;
    private String pdf;
    private String  url;

}
