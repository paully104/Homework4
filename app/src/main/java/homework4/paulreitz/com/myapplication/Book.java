package homework4.paulreitz.com.myapplication;

/**
 * Created by Paul on 11/2/2014.
*/

public class Book {

    private int id;
    private String title;
    private String author;

    public Book(){}

    public Book(String title, String author) {
        super();
        this.title = title;
        this.author = author;
    }

    //GETTERS

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author
                + "]";
    }
    public String getTitle()
    {
        return title;

    }
    public String getAuthor()
    {
        return author;

    }
    public int getId()
    {
        return id;

    }

    //SETTERS

    public void setTitle(String input)
    {
        title = input;


    }
    public void setId(int input)
    {
        id = input;

    }

    public void setAuthor(String input)
    {
        author = input;

    }
}

