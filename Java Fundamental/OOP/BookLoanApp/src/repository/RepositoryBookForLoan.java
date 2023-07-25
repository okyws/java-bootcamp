package repository;

import java.util.ArrayList;
import java.util.List;

import childs.BookForLoan;
import childs.Comic;
import childs.Novel;

public class RepositoryBookForLoan {
  // Attribute / Field / Properties
  private List<BookForLoan> books;
  private List<BookForLoan> loanedBooks;

  // Constructor Default
  public RepositoryBookForLoan() {
    super();
  }

  // Constructor Dengan Parameter
  public RepositoryBookForLoan(List<BookForLoan> books) {
    super();
    this.books = new ArrayList<>();
    this.books.add(new Comic("Comic-001", "Uzumaki Naruto", "Masashi Kisimoto", 55000, 0, 10, "Shounen"));
    this.books.add(new Comic("Comic-002", "The Worst Client", "Masashi Kisimoto", 35000, 0, 20, "Shounen"));
    this.books.add(new Comic("Comic-003", "For the Sake of Dreams...!!", "Masashi Kisimoto", 35000, 0, 15, "Shounen"));
    this.books.add(new Comic("Comic-004", "Hunter X Hunter: The Day of Departure", "Yoshihiro Togashi", 50000, 0, 15,
        "Fantasy"));
    this.books.add(new Comic("Comic-005", "Hunter X Hunter: A Struggle in the Mist", "Yoshihiro Togashi", 80000, 0, 25,
        "Fantasy"));
    this.books
        .add(new Novel("Novel-001", "Harry Potter and the Philosopher's Stone", "J.K Rowling", 150000, 0, 10, true));
    this.books
        .add(new Novel("Novel-002", "Harry Potter and the Chamber of Secrets", "J.K Rowling", 150000, 0, 10, true));
    this.books
        .add(new Novel("Novel-003", "Harry Potter and the Prisoner of Azkaban", "J.K Rowling", 200000, 0, 15, true));
    this.books.add(new Novel("Novel-004", "Ayah Aku Berbeda", "Tere Liye", 35000, 0, 15, false));
    this.books.add(new Novel("Novel-005", "Madre", "Dee Lestari", 80000, 0, 10, false));
  }

  public List<BookForLoan> getAllBookForLoan() {
    StringBuilder sb = new StringBuilder();
    sb.append(
        "==========================================================================================================================================\n");
    sb.append("|| No ||\tBook ID\t\t||\t\t\t\tTitle\t\t\t||\t\tAuthor\t\t||\tStock\t||\n");
    sb.append(
        "==========================================================================================================================================\n");
    int i = 1;
    for (BookForLoan book : books) {
      sb.append(String.format("|| %2d ", i++));
      sb.append("||\t");
      sb.append(String.format("%-16s", book.getBookID()));
      sb.append("||\t");
      sb.append(String.format("%-48s", book.getTitle()));
      sb.append("||\t");
      sb.append(String.format("%-24s", book.getAuthor()));
      sb.append("||\t");
      sb.append(String.format("%-8s", book.getStock()));
      // double bookLoanPrice = book.calculateBookLoanPrice();
      // sb.append(String.format("%-12s", bookLoanPrice));
      sb.append("||\n");
    }
    sb.append(
        "==========================================================================================================================================\n");
    System.out.print(sb.toString());

    this.books.addAll(loanedBooks);
    return books;
  }

  public void setBooks(List<BookForLoan> books) {
    this.books = books;
  }

  // cari dengan index
  public BookForLoan getBookByIndex(int index) {
    return books.get(index - 1);
  }

  // cari dengan ID Buku
  public BookForLoan getBook(String bookID) {
    BookForLoan book = null;
    for (int i = 0; i < books.size(); i++) {
      if (books.get(i).getBookID().equals(bookID)) {
        book = books.get(i);
      }
    }
    return book;
  }

  public int getBookIndex(String bookID) {
    int index = -1;
    for (int i = 0; i < books.size(); i++) {
      if (books.get(i).getBookID().equals(bookID)) {
        index = i;
      }
    }
    return index;
  }

  public void updateStockBook(String bookID, int stock) {
    int index = getBookIndex(bookID);
    if (index != -1) {
      books.get(index).setStock(stock - 1);
    }
  }

  public void updateLoanPriceBook(String bookID, double loanPrice) {
    int index = getBookIndex(bookID);
    if (index != -1) {
      books.get(index).setBookLoanPrice(loanPrice);
    }
  }

}
