package childs;

import parents.BookForLoan;

public class Comic extends BookForLoan {
  // Attribute / Field / Properties
  private String genre;

  // Constructor Default
  public Comic() {
    super();
  }

  // Constructor Dengan Parameter
  public Comic(String bookID, String title, String author, int price, double bookLoanPrice, int stock, int totalStock,
      String genre) {
    super(bookID, title, author, price, bookLoanPrice, stock, totalStock);
    this.genre = genre;
  }

  // Getter & Setter
  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  // Method / Function
  @Override
  public double calculateBookLoanPrice() {
    double rateStockBookPercentage = (this.getStock() < 10) ? 0.05 : 0.03;
    double rateTypeBookPercentage = 0.1;
    double bookLoanPrice = (rateStockBookPercentage + rateTypeBookPercentage) * this.price;
    return bookLoanPrice;
  }

  public void setLoanPrice() {
    this.bookLoanPrice = calculateBookLoanPrice();
  }

  // dipakai untuk keperluan debug
  @Override
  public String toString() {
    return "Comic [bookID=" + this.getBookID() + ", title=" + this.getTitle() + ", author=" + this.getAuthor()
        + ", price=" + this.getPrice()
        + ", bookLoanPrice=" + this.bookLoanPrice + ", stock=" + getStock() + ", genre=" + genre + "]";
  }
}
