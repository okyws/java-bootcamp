package childs;

public class Comic extends BookForLoan {
  // Attribute / Field / Properties
  private String genre;

  // Constructor Default
  public Comic() {
    super();
  }

  // Constructor Dengan Parameter
  public Comic(String bookID, String title, String author, int price, double bookLoanPrice, int stock, String genre) {
    super(bookID, title, author, price, bookLoanPrice, stock);
    this.genre = genre;
  }

  // Getter & Setter
  public String getGenre() {
    return genre;
  }

  public String setGenre(String genre) {
    return this.genre = genre;
  }

  // Method / Function
  @Override
  public double calculateBookLoanPrice() {
    double rateStockBookPercentage = (this.stock < 10) ? 0.05 : 0.03;
    double rateTypeBookPercentage = 0.1;
    double bookLoanPrice = (rateStockBookPercentage + rateTypeBookPercentage) * this.price;
    return bookLoanPrice;
  }

  public void setLoanPrice() {
    this.bookLoanPrice = calculateBookLoanPrice();
  }

  @Override
  public String toString() {
    return "Comic [bookID=" + this.getBookID() + ", title=" + this.getTitle() + ", author=" + this.getAuthor()
        + ", price=" + this.getPrice()
        + ", bookLoanPrice=" + this.bookLoanPrice + ", stock=" + stock + ", genre=" + genre + "]";
  }
}
