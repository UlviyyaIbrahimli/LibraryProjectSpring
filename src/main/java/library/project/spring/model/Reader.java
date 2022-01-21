package library.project.spring.model;

import lombok.Data;

@Data
public class Reader {
    private Long idReader;
    private String name;
    private String surname;
    private String username;
    private Long statusId;
    private String status;
    private String email;
    private String password;

}
