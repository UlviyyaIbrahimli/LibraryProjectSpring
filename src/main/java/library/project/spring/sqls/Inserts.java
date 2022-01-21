package library.project.spring.sqls;

public class Inserts {
    public  static  final String createNewUSer = "insert into librarydb.reader(name, surname,username,password,status_id) " +
            "values(?,?,?,?,?);";
}
