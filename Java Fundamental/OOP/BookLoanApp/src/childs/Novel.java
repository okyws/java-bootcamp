package childs;

import parents.BookForLoan;

public class Novel extends BookForLoan {
  // Attribute / Field / Properties
  private boolean isASeries;

  // Constructor Default
  public Novel() {
    super();
  }

  // Constructor Dengan Parameter
  public Novel(String bookID, String title, String author, int price, double bookLoanPrice, int stock, int totalStock,
      boolean isASeries) {
    super(bookID, title, author, price, bookLoanPrice, stock, totalStock);
    this.isASeries = isASeries;
  }

  // Getter & Setter
  public boolean getIsASeries() {
    return isASeries;
  }

  public boolean setIsASeries(boolean isASeries) {
    return this.isASeries = isASeries;
  }

  @Override
  public double calculateBookLoanPrice() {
    double rateStockBookPercentage = (this.getStock() < 10) ? 0.05 : 0.03;
    double rateTypeBookPercentage = 0.05;
    double bookLoanPrice = (rateStockBookPercentage + rateTypeBookPercentage) * this.price;
    return bookLoanPrice;
  }

  public void setLoanPrice() {
    this.bookLoanPrice = calculateBookLoanPrice();
  }

  // dipakai untuk keperluan debug
  @Override
  public String toString() {
    return "Novel [bookID=" + this.getBookID() + ", title=" + this.getTitle() + ", author=" + this.getAuthor()
        + ", price=" + this.getPrice()
        + ", bookLoanPrice=" + this.bookLoanPrice + ", stock=" + this.getStock() + ", isASeries=" + this.isASeries
        + "]";
  }
}
