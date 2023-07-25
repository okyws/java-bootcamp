package parents;

public abstract class Book {
  // Attribute / Field / Properties
  private String bookID;
  private String title;
  private String author;
  protected int price;

  // Constructor Default
  public Book() {
    super();
  }

  // Constructor Dengan Parameter
  public Book(String bookID, String title, String author, int price) {
    super();
    this.bookID = bookID;
    this.title = title;
    this.author = author;
    this.price = price;
  }

  // Getter & Setter
  public String getBookID() {
    return bookID;
  }

  public void setBookID(String bookID) {
    this.bookID = bookID;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public String setAuthor(String author) {
    return this.author = author;
  }

  public int getPrice() {
    return price;
  }

  public int setPrice(int price) {
    return this.price = price;
  }
}
