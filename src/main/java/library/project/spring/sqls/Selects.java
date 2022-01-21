package library.project.spring.sqls;

public class Selects {

    public  static  final  String getRoleList="Select * from librarydb.role where active=1";
    public  static  final  String getUserList="Select * from librarydb.user where active=1";
    public  static  final  String getUserByUserName="Select * from librarydb.user where username=? and active=1";
    public  static  final String getAllBookCount="Select count(id_book) from librarydb.book where active=1";
    public  static  final String getAllSubjectCount="Select count(id_subject) from librarydb.subject where active=1";
    public  static  final  String getRegistrationReaderCount="Select count(id_reader) from librarydb.reader where active=1";
    public  static  final String getMoreReaderBookCount="Select count(id_book) from librarydb.book where star in (4.5,5)";
    public  static  final String getAllSubjectList="Select * from librarydb.subject where active=1";
    public  static  final String getRandomBookList="SELECT \n" +
            "    b.isbn,\n" +
            "    b.title,\n" +
            "    b.publisher,\n" +
            "    DATE_FORMAT(b.publisher_date, '%m'\"-\"'%d'\"-\"'%Y') AS extract_date,\n" +
            "    b.star,\n" +
            "    b.picture,\n" +
            "    b.info,\n" +
            "    s.subject,\n" +
            "    a.full_name AS author_full_name,\n" +
            "    a.id_author,\n" +
            "    b.id_book,\n" +
            "    s.id_subject\n" +
            "FROM\n" +
            "    librarydb.book b\n" +
            "        LEFT JOIN\n" +
            "    librarydb.book_subject bs ON b.id_book = bs.book_id\n" +
            "        LEFT JOIN\n" +
            "    librarydb.subject s ON s.id_subject = bs.subject_id\n" +
            "        LEFT JOIN\n" +
            "    librarydb.book_author ba ON ba.book_id = b.id_book\n" +
            "        LEFT JOIN\n" +
            "    librarydb.author a ON a.id_author = ba.author_id\n" +
            "WHERE\n" +
            "    b.active = 1\n" +
            "ORDER BY RAND();";


    public  static  final String newBookList="SELECT \n" +
            "                b.isbn,\n" +
            "                b.title,\n" +
            "                b.pdf,\n" +
            "                b.url,\n" +
            "                b.publisher,\n" +
            "                DATE_FORMAT(b.publisher_date, '%m''-''%d''-''%Y') AS extract_date,\n" +
            "                b.star,\n" +
            "                b.picture,\n" +
            "                b.info,\n" +
            "                b.id_book\n" +
            "                FROM\n" +
            "                librarydb.book b\n" +
            "          \n" +
            "            WHERE\n" +
            "                b.active = 1\n" +
            "                    AND DATE_FORMAT(b.publisher_date, '%y') <= YEAR(CURDATE())\n" +
            "            ORDER BY RAND();";


    public  static  final String getPopularBookList="SELECT \n" +
            "    b.isbn,\n" +
            "    b.title,\n" +
            "    b.url,\n" +
            "    b.publisher,\n" +
            "    DATE_FORMAT(b.publisher_date, '%m\\'-\\'%d\\'-\\'%Y') AS extract_date,\n" +
            "    b.star,\n" +
            "    b.picture,\n" +
            "    b.info,\n" +
            "    s.subject,\n" +
            "    a.full_name AS author_full_name,\n" +
            "    a.id_author,\n" +
            "    b.id_book,\n" +
            "    s.id_subject\n" +
            "FROM\n" +
            "    librarydb.book b\n" +
            "        LEFT JOIN\n" +
            "    librarydb.book_subject bs ON b.id_book = bs.book_id\n" +
            "        LEFT JOIN\n" +
            "    librarydb.subject s ON s.id_subject = bs.subject_id\n" +
            "        LEFT JOIN\n" +
            "    librarydb.book_author ba ON ba.book_id = b.id_book\n" +
            "        LEFT JOIN\n" +
            "    librarydb.author a ON a.id_author = ba.author_id\n" +
            "WHERE\n" +
            "    b.active = 1 AND b.star IN (4 , 4.5, 5)\n" +
            "ORDER BY RAND();";


    public  static  final String booksForSubjectRandom="SELECT \n" +
            "    b.isbn,\n" +
            "    b.url,\n" +
            "    b.title,\n" +
            "    b.publisher,\n" +
            "    DATE_FORMAT(b.publisher_date, '%m\\'-\\'%d\\'-\\'%Y') AS extract_date,\n" +
            "    b.star,\n" +
            "    b.picture,\n" +
            "    b.info,\n" +
            "    s.subject,\n" +
            "    a.full_name AS author_full_name,\n" +
            "    a.id_author,\n" +
            "    b.id_book,\n" +
            "    s.id_subject\n" +
            "FROM\n" +
            "    librarydb.book b\n" +
            "        LEFT JOIN\n" +
            "    librarydb.book_subject bs ON b.id_book = bs.book_id\n" +
            "        LEFT JOIN\n" +
            "    librarydb.subject s ON s.id_subject = bs.subject_id\n" +
            "        LEFT JOIN\n" +
            "    librarydb.book_author ba ON ba.book_id = b.id_book\n" +
            "        LEFT JOIN\n" +
            "    librarydb.author a ON a.id_author = ba.author_id\n" +
            "WHERE\n" +
            "    b.active = 1\n" +
            "        AND b.description LIKE '%' ? '%'\n" +
            "ORDER BY RAND();";

    public static  final String getBookListWeLove="SELECT \n" +
            "    b.isbn,\n" +
            "    b.title,\n" +
            "    b.url,\n" +
            "    b.publisher,\n" +
            "    DATE_FORMAT(b.publisher_date, '%m\\'-\\'%d\\'-\\'%Y') AS extract_date,\n" +
            "    b.star,\n" +
            "    b.picture,\n" +
            "    b.info,\n" +
            "    s.subject,\n" +
            "    a.full_name AS author_full_name,\n" +
            "    a.id_author,\n" +
            "    b.id_book,\n" +
            "    s.id_subject\n" +
            "FROM\n" +
            "    librarydb.book b\n" +
            "        LEFT JOIN\n" +
            "    librarydb.book_subject bs ON b.id_book = bs.book_id\n" +
            "        LEFT JOIN\n" +
            "    librarydb.subject s ON s.id_subject = bs.subject_id\n" +
            "        LEFT JOIN\n" +
            "    librarydb.book_author ba ON ba.book_id = b.id_book\n" +
            "        LEFT JOIN\n" +
            "    librarydb.author a ON a.id_author = ba.author_id\n" +
            "WHERE\n" +
            "    b.active = 1\n" +
            "        AND b.description LIKE '%programming%'\n" +
            "        OR '%information technology%'\n" +
            "        OR s.subject = 'programming'\n" +
            "ORDER BY RAND()\n" +
            " -- LIMIT 6;";

    public  static  final  String booksCountBySubject="select count(bs.book_id) as subject_count from librarydb.book_subject bs \n" +
            "inner join librarydb.book b on b.id_book=bs.book_id\n" +
            "inner join librarydb.subject s on s.id_subject=bs.subject_id\n" +
            "where b.active=1 and s.active=1 and bs.subject_id=?;";
    public  static final String getSubjectById="Select * from librarydb.subject where active=1 and id_subject=?";
public  static  final String bookOfSubject="SELECT \n" +
        "            b.isbn,\n" +
        "            b.id_book,\n" +
        "            b.title,\n" +
        "            b.publisher,\n" +
        "            b.publisher_date,\n" +
        "            b.star,\n" +
        "            s.subject,\n" +
        "            b.info,\n" +
        "            b.description,\n" +
        "            b.pdf,\n" +
        "            a.full_name author_full_name\n" +
        "        FROM\n" +
        "            librarydb.book_subject bs\n" +
        "                INNER JOIN\n" +
        "            librarydb.book b ON b.id_book = bs.book_id\n" +
        "                INNER JOIN\n" +
        "            librarydb.subject s ON s.id_subject = bs.subject_id\n" +
        "            left join librarydb.book_author ba on ba.book_id=b.id_book\n" +
        "            left join librarydb.author a on a.id_author=ba.author_id\n" +
        "        WHERE\n" +
        "            s.id_subject = ? group by ba.book_id;";
public  static  final String getAuthorList="Select * from librarydb.author a left join librarydb.nationality n \n" +
        "on n.id_nationality=a.nationality_id where a.active=1; ";
public static final String getBooksOfAuthor="SELECT \n" +
        "            b.isbn,\n" +
        "            b.id_book,\n" +
        "            b.title,\n" +
        "            b.publisher,\n" +
        "            b.publisher_date,\n" +
        "            b.star,\n" +
        "            b.info,\n" +
        "            b.description,\n" +
        "            b.pdf,\n" +
        "            s.subject,\n" +
        "            a.full_name as author_full_name\n" +
        "        FROM\n" +
        "           librarydb.book_author ba inner join librarydb.book b\n" +
        "           on b.id_book= ba.book_id\n" +
        "           left join librarydb.author a\n" +
        "           on a.id_author=ba.author_id\n" +
        "           left join librarydb.book_subject bs\n" +
        "           on bs.book_id=b.id_book\n" +
        "           left join librarydb.subject s\n" +
        "           on s.id_subject=bs.subject_id where a.id_author=? group by ba.book_id;";

public  static  final String getAuthorById="Select * from librarydb.author a left join librarydb.nationality n \n" +
        "        on n.id_nationality=a.nationality_id where a.active=1 and a.id_author=?; ";

public  static  final String checkUser="Select * from librarydb.reader where username=? and password=?;";
public  static  final String getBookById="sELECT \n" +
        "                        b.isbn,\n" +
        "                        b.title,\n" +
        "                        b.pdf,\n" +
        "                        b.publisher,\n" +
        "                        DATE_FORMAT(b.publisher_date, '%m'-'%d'-'%Y') AS extract_date,\n" +
        "                        b.star,\n" +
        "                        b.picture,\n" +
        "                        b.info,\n" +
        "                        b.id_book,\n" +
        "                        b.url\n" +
        "                    FROM\n" +
        "                        librarydb.book b\n" +
        "                     \n" +
        "                    WHERE\n" +
        "                        b.active = 1 and b.id_book=?;";
}
