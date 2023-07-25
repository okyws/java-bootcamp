package parents;

import interfaces.InterfaceLoanPrice;

public abstract class BookForLoan extends Book implements InterfaceLoanPrice {
  // Attribute / Field / Properties
  protected double bookLoanPrice;
  private int stock;
  protected int totalStock;

  // Constructor Default
  public BookForLoan() {
    super();
  }

  // Constructor Dengan Parameter
  public BookForLoan(String bookID, String title, String author, int price, double bookLoanPrice, int stock,
      int totalStock) {
    super(bookID, title, author, price);
    this.bookLoanPrice = bookLoanPrice;
    this.stock = stock;
    this.totalStock = stock;
  }

  // Getter & Setter
  public double getBookLoanPrice() {
    return bookLoanPrice;
  }

  public void setBookLoanPrice(double bookLoanPrice) {
    this.bookLoanPrice = bookLoanPrice;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public int getTotalStock() {
    return totalStock;
  }

  public void setTotalStock(int totalStock) {
    this.totalStock = totalStock;
  }
}
