package parcial.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {

    private String isbn;
    private String publisherName;
    private String authorName;
    private Integer years;
    private String title;
    private Double price;


}
