package childs;

import interfaces.InterfaceLoanPrice;
import parents.Book;

public abstract class BookForLoan extends Book implements InterfaceLoanPrice {
  // Attribute / Field / Properties
  double bookLoanPrice;
  int stock;

  // Constructor Default
  public BookForLoan() {
    super();
  }

  // Constructor Dengan Parameter
  public BookForLoan(String bookID, String title, String author, int price, double bookLoanPrice, int stock) {
    super(bookID, title, author, price);
    this.bookLoanPrice = bookLoanPrice;
    this.stock = stock;
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

  public int setStock(int stock) {
    return this.stock = stock;
  }
}
