import javax.xml.bind.annotation.*;

@XmlRootElement(name = "book")
@XmlType(propOrder = { "id", "name"})
public class Book {
    private Long id;
    private String name;
    private String author;

    @XmlAttribute
    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(name = "title")
    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public void setAuthor(String author) {
        this.author = author;
    }

    // constructor, getters and setters

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }
}