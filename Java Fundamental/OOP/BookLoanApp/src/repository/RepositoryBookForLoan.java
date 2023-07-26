package repository;

import java.util.ArrayList;
import java.util.List;

import childs.Comic;
import childs.LoanDetail;
import childs.Novel;
import parents.BookForLoan;

public class RepositoryBookForLoan {
  private List<BookForLoan> books;
  private List<BookForLoan> loanedBooks;
  private List<LoanDetail> loanDetails;

  // Constructor Default
  public RepositoryBookForLoan() {
    super();
  }

  public RepositoryBookForLoan(ArrayList<BookForLoan> arrayList) {
    super();
    this.books = new ArrayList<>();
    this.loanedBooks = new ArrayList<>();
    this.loanDetails = new ArrayList<>();
    initializeBooks();
  }

  // Method to initialize the book list
  private void initializeBooks() {
    this.books.add(new Comic("Comic-001", "Uzumaki Naruto", "Masashi Kisimoto", 55000, 0, 10, 0, "Shounen"));
    this.books.add(new Comic("Comic-002", "The Worst Client", "Masashi Kisimoto", 35000, 0, 20, 0, "Shounen"));
    this.books
        .add(new Comic("Comic-003", "For the Sake of Dreams...!!", "Masashi Kisimoto", 35000, 0, 15, 0, "Shounen"));
    this.books.add(new Comic("Comic-004", "Hunter X Hunter: The Day of Departure", "Yoshihiro Togashi", 50000, 0, 15,
        0, "Fantasy"));
    this.books.add(new Comic("Comic-005", "Hunter X Hunter: A Struggle in the Mist", "Yoshihiro Togashi", 80000, 0, 25,
        0, "Fantasy"));
    this.books
        .add(new Novel("Novel-001", "Harry Potter and the Philosopher's Stone", "J.K Rowling", 150000, 0, 10, 0, true));
    this.books
        .add(new Novel("Novel-002", "Harry Potter and the Chamber of Secrets", "J.K Rowling", 150000, 0, 10, 0, true));
    this.books
        .add(new Novel("Novel-003", "Harry Potter and the Prisoner of Azkaban", "J.K Rowling", 200000, 0, 15, 0, true));
    this.books.add(new Novel("Novel-004", "Ayah Aku Berbeda", "Tere Liye", 35000, 0, 15, 0, false));
    this.books.add(new Novel("Novel-005", "Madre", "Dee Lestari", 80000, 0, 10, 0, false));
  }

  public List<BookForLoan> getAllBookForLoan() {
    List<BookForLoan> allBooks = new ArrayList<>(books);
    allBooks.addAll(loanedBooks);
    displayBooks(allBooks);
    return allBooks;
  }

  public List<BookForLoan> getLoanedBooks() {
    return loanedBooks;
  }

  // Method to display the book list
  public void displayBooks(List<BookForLoan> bookList) {
    StringBuilder sb = new StringBuilder();
    sb.append(
        "==========================================================================================================================================\n");
    sb.append("|| No ||\tBook ID\t\t||\t\t\t\tTitle\t\t\t||\t\tAuthor\t\t||\tStock\t||\n");
    sb.append(
        "==========================================================================================================================================\n");
    int i = 1;
    for (BookForLoan book : bookList) {
      sb.append(String.format("|| %2d ", i++));
      sb.append("||\t");
      sb.append(String.format("%-16s", book.getBookID()));
      sb.append("||\t");
      sb.append(String.format("%-48s", book.getTitle()));
      sb.append("||\t");
      sb.append(String.format("%-24s", book.getAuthor()));
      sb.append("||\t");
      sb.append(String.format("%-8s", book.getStock()));
      sb.append("||\n");
    }
    sb.append(
        "==========================================================================================================================================\n");
    System.out.print(sb.toString());
  }

  public void displayLoanedBook() {
    if (loanDetails.isEmpty()) {
      System.out.println("No books have been loaned.");
      return;
    }

    StringBuilder sb = new StringBuilder();

    sb.append(
        "==================================================================================================================\n");
    sb.append("|| No ||\tLoan Id\t\t||\tBook Id\t\t||\t\t\tTitle\t\t\t\t||\n");
    sb.append(
        "==================================================================================================================\n");

    int i = 1;
    for (LoanDetail loanDetail : loanDetails) {
      BookForLoan book = this.getIDBookForLoan(loanDetail.getBookId());
      if (book != null) {
        sb.append(String.format("|| %2d ||\t%s\t\t||\t%s\t||\t%-48s||\n", i++, loanDetail.getLoanId(),
            book.getBookID(), book.getTitle()));
      }
    }

    sb.append(
        "==================================================================================================================\n");
    System.out.println(sb);
  }

  public void displayLoanDetails() {
    if (loanDetails.isEmpty()) {
      System.out.println("No books have been loaned.");
      return;
    }

    StringBuilder sb = new StringBuilder();
    sb.append(
        "==================================================================================================================================================================\n");
    sb.append(
        "|| No ||\tLoan Id\t||\t Member Name\t|| Book Id\t|| \t\t\tTitle\t\t\t|| Loan Book Price || Loan Duration || Loan Fee\t ||\n");
    sb.append(
        "==================================================================================================================================================================\n");
    int i = 1;
    for (LoanDetail loanDetail : loanDetails) {
      BookForLoan book = getIDBookForLoan(loanDetail.getBookId());
      if (book != null) {
        double loanFee = loanDetail.calculateLoanFee();
        sb.append(String.format("|| %2d ", i++));
        sb.append("||\t");
        sb.append(String.format("%-8s", loanDetail.getLoanId()));
        sb.append("||\t");
        sb.append(String.format("%-12s", loanDetail.getMemberName()));
        sb.append("\t||   ");
        sb.append(String.format("%-8s", book.getBookID()));
        sb.append("  ||\t");
        sb.append(String.format("%-40s", book.getTitle()));
        sb.append("||\t");
        sb.append(String.format("%-10.2f", loanDetail.getLoanBookPrice()));
        sb.append(" ||\t");
        sb.append(String.format("%-11s", loanDetail.getLoanDuration()));
        sb.append("||\t");
        sb.append(String.format("%-8.2f", loanFee));
        sb.append("||\n");
      }
    }
    sb.append(
        "==================================================================================================================================================================\n");

    System.out.print(sb.toString());
  }

  public void addLoanDetail(LoanDetail loanDetail) {
    loanDetails.add(loanDetail);
  }

  public void updateBookStock(String bookID) {
    BookForLoan selectedBook = null;

    for (BookForLoan book : books) {
      if (book.getBookID().equals(bookID)) {
        selectedBook = book;
        break;
      }
    }

    if (selectedBook != null) {
      int currentStock = selectedBook.getStock();
      if (currentStock > 0) {
        selectedBook.setStock(currentStock - 1);
      } else {
        System.out.println("Book is out of stock and cannot be loaned.");
      }
    } else {
      System.out.println("Book not found. Please enter a valid Book ID.");
    }
  }

  public void returnBook(String bookID) {
    LoanDetail loanDetail = null;
    for (LoanDetail loan : loanDetails) {
      if (loan.getLoanId().equals(bookID)) {
        loanDetail = loan;
        break;
      }
    }

    if (loanDetail != null) {
      String bookId = loanDetail.getBookId();
      BookForLoan book = getIDBookForLoan(bookId);
      if (book != null) {
        int currentStock = book.getStock();
        book.setStock(currentStock + 1);
        loanDetails.remove(loanDetail);
        System.out.println("Book with Loan Id " + loanDetail.getLoanId() + " has been returned.");
      } else {
        System.out.println("Book not found. Please check the Book Id.");
      }
    } else {
      System.out.println("Loan Detail not found. Please check the Loan Id.");
    }
  }

  public LoanDetail getLoanDetailById(String loanID) {
    for (LoanDetail loanDetail : loanDetails) {
      if (loanDetail.getLoanId().equals(loanID)) {
        return loanDetail;
      }
    }
    return null;
  }

  public BookForLoan getIDBookForLoan(String bookID) {
    for (BookForLoan bookForLoan : books) {
      if (bookForLoan.getBookID().equals(bookID)) {
        return bookForLoan;
      }
    }
    return null;
  }
}
