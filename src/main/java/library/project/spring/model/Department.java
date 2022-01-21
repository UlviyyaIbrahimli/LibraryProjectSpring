package library.project.spring.model;

import lombok.Data;

import java.util.Date;

@Data
public class Department {
    private Long idDeparment;
    private String department;
    private Date dataTime;
    private Integer active;
}
