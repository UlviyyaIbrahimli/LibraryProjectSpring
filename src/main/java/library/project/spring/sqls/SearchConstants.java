package library.project.spring.sqls;

public class SearchConstants {
    public  static  final String advBook="\n" +
            "select b.title,b.description, b.id_book, b.isbn,b.publisher,b.publisher_date,b.star, b.picture,b.pdf,b.info,a.id_author,\n" +
            "a.full_name as author_full_name, b.url, s.id_subject, s.subject from librarydb.book b\n" +
            "inner join librarydb.book_subject bs\n" +
            "on b.id_book=bs.book_id\n" +
            "inner join librarydb.book_author ba \n" +
            "on ba.book_id=b.id_book\n" +
            "inner join librarydb.subject s on s.id_subject=bs.subject_id\n" +
            "inner join librarydb.author a on a.id_author=ba.author_id\n" +
            "[paramSql] [paramSqlBill]\n" +
            "where b.active=1  group by ba.book_id;";
// do not use listagg in oracle 5.0 and result just one author and subject return
    public  static final String searchBookAllParams="select b.title,b.description, b.id_book, b.isbn,b.publisher,b.publisher_date,b.star, b.picture,b.pdf,b.info,a.id_author,\n" +
            "            a.full_name as author_full_name, s.id_subject, b.url, s.subject from librarydb.book b\n" +
            "            inner join librarydb.book_subject bs\n" +
            "            on b.id_book=bs.book_id\n" +
            "            inner join librarydb.book_author ba \n" +
            "            on ba.book_id=b.id_book\n" +
            "            inner join librarydb.subject s on s.id_subject=bs.subject_id\n" +
            "            inner join librarydb.author a on a.id_author=ba.author_id\n" +
            "             \n" +
            "            where b.active=1    and (LOWER(b.title) LIKE LOWER(?))\n" +
            "             or (LOWER(b.isbn) LIKE LOWER(?))\n" +
            "             or (LOWER(b.publisher) LIKE LOWER(?))\n" +
            "             or (LOWER(b.publisher_date) LIKE LOWER(?))\n" +
            "             or (LOWER(b.star) LIKE LOWER(?))\n" +
            "             or (LOWER(b.info) LIKE LOWER(?))\n" +
            "             or (LOWER(a.full_name) LIKE LOWER(?))\n" +
            "             or (LOWER(s.subject) LIKE LOWER(?))\n" +
            "             or (LOWER(b.description) LIKE LOWER(?)) group by ba.book_id;";

    public  static  final  String  searchAuthor="select * from librarydb.author a\n" +
            "left join librarydb.nationality n on n.id_nationality=a.nationality_id\n" +
            " where a.active=1    and (LOWER(a.full_name) LIKE LOWER(?))\n" +
            "            or a.dob LIKE ? or a.death_date LIKE ? \n" +
            "            or (LOWER(n.nationality) LIKE LOWER(?)) ;";


    public static final String searchSubject="Select * from librarydb.subject s where s.active=1 and " +
            " (LOWER(s.subject) LIKE LOWER(?)) or (LOWER(s.description) LIKE LOWER(?))";
}
