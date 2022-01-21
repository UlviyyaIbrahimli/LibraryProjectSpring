package library.project.spring.model;

import lombok.Data;

import java.util.Date;

@Data
public class Role {
    private  Long idRole;
    private String roleName;
    private Date dataDate;
    private  Integer active;
}
