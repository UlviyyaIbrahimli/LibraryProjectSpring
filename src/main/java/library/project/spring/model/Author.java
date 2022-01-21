package library.project.spring.model;

import lombok.Data;

import java.util.Date;

@Data
public class Author {
    private  Long idAuthor;
    private String fullName;
    private Date dob;
    private String nationality;
    private Long idNationality;


}
