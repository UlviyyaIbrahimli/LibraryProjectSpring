package library.project.spring.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private  long idUser;
    private  String username;
    private  String name;
    private String surname;
    private  String description;
    private String password;
    private  long roleId;
    private Date dataDate;
    private  Integer active;
}
