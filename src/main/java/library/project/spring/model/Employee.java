package library.project.spring.model;

import lombok.Data;

import java.util.Date;

@Data
public class Employee {
    private  Long idEmployee;
    private  String name;
    private  String surname;
    private String fatherName;
    private String info;
    private String countryId;
    private  String country;
    private Double salary;
    private String phone1;
    private String phone2;
    private String home;
    private String email;
    private Long deparmentId;
    private String department;
    private Date dob;

}
