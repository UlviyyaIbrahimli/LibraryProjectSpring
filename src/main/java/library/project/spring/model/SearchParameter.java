package library.project.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchParameter {
    private String title;
    private String isbn;
    private String limit;
    private String publisher;
    private String publishDate;
    private String subject;
    private Long subjectId;
    private String subjects;
    private String author;
}
