package parents;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import childs.LoanDetail;
import interfaces.IBackToMenu;
import repository.RepositoryBookForLoan;
import repository.RepositoryMember;

public class Menu implements IBackToMenu {

  private static Scanner input = new Scanner(System.in);
  private RepositoryBookForLoan repositoryBookForLoan = new RepositoryBookForLoan(new ArrayList<BookForLoan>());
  private RepositoryMember repositoryMember = new RepositoryMember(new ArrayList<Member>());
  private List<BookForLoan> loanedBooks = new ArrayList<>();
  private static AtomicInteger nextLoanId = new AtomicInteger(1);

  public void printMainMenu() {
    System.out.println("=============================");
    System.out.println("Aplikasi Rental Buku Cucux");
    System.out.println("========= Main Menu =========");
    System.out.println("1. Data All Book For Loan");
    System.out.println("2. Loan");
    System.out.println("3. Return");
    System.out.println("4. Data All Loan Book Order");
    System.out.println("5. Data All Member");
    System.out.println("0. Exit");
    System.out.println("=============================");
    System.out.print("Pilih menu: ");
  }

  public void handleOption1() {
    System.out.println("Data All Book For Loan");
    repositoryBookForLoan.getAllBookForLoan();
    System.out.println("0. Back to Main Menu");
    System.out.println(
        "==========================================================================================================================================");

    backToMenu();
  }

  public void handleOption2() {
    System.out.println("Loan Book");
    repositoryBookForLoan.getAllBookForLoan();
    System.out.print("Enter the Book ID: ");
    String bookID = input.nextLine();

    clearScreen();
    BookForLoan bookForLoan = repositoryBookForLoan.getIDBookForLoan(bookID);

    if (bookForLoan != null) {
      repositoryMember.getAllMember();
      System.out.print("Enter the Member ID: ");
      String memberID = input.nextLine();

      clearScreen();
      Member member = repositoryMember.getMemberById(memberID);

      if (member != null) {
        System.out.print("Enter the Loan Duration (in days): ");
        int loanDuration = Integer.parseInt(input.nextLine());

        clearScreen();
        String loanId = "Ord-" + String.format("%03d", nextLoanId.getAndIncrement());
        double loanFee = bookForLoan.calculateBookLoanPrice() * loanDuration;

        System.out.println("Data Order: " + loanId + " Created, with Loan Fee: " + loanFee);
        System.out.println("Loan successful!");

        repositoryBookForLoan.updateBookStock(bookID);
        loanedBooks.add(bookForLoan);

        LoanDetail loanDetail = new LoanDetail(loanId, memberID, bookID, loanId, loanFee, loanDuration);
        repositoryBookForLoan.addLoanDetail(loanDetail);
        repositoryBookForLoan.getAllBookForLoan();
      } else {
        System.out.println("Member not found. Please enter a valid Member ID.");
        handleOption2();
      }
    } else {
      System.out.println("Book not found. Please enter a valid Book ID.");
      handleOption2();
    }

    System.out.println("0. Back to Main Menu");
    System.out.println("==================================================================================");

    backToMenu();
  }

  public void handleOption3() {
    System.out.println("Return Book");
    repositoryBookForLoan.displayLoanedBook();

    System.out.print("Enter the Loan ID: ");
    String loanID = input.nextLine();

    if (loanID.equals("0")) {
      backToMenu();
    }

    LoanDetail loanDetail = repositoryBookForLoan.getLoanDetailById(loanID);
    if (loanDetail != null) {
      BookForLoan bookForLoan = repositoryBookForLoan.getIDBookForLoan(loanDetail.getBookId());

      if (bookForLoan != null) {
        repositoryBookForLoan.returnBook(loanID);
        System.out.println("Book returned successfully!");
      } else {
        System.out.println("Book not found. Please enter a valid Book ID.");
      }
    } else {
      System.out.println("Loan ID not found. Please enter a valid Loan ID.");
    }

    System.out.println("0. Back to Main Menu");
    backToMenu();
  }

  public void handleOption4() {
    System.out.println("Loan Book List:");
    repositoryBookForLoan.displayLoanDetails();
    System.out.println("0. Back to Main Menu");
    backToMenu();
  }

  public void handleOption5() {
    System.out.println("Data All Member");
    repositoryMember.getAllMember();
    System.out.println("0. Back to Main Menu");
    System.out.println("==================================================================================");

    backToMenu();
  }

  // utulity method untuk clear screen
  public void clearScreen() {
    try {
      Thread.sleep(1000);
      System.out.print("\033\143");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void backToMenu() {
    while (true) {
      System.out.print("Enter your choice: ");
      int choice = input.nextInt();
      input.nextLine();

      if (choice == 0) {
        clearScreen();
        break;
      } else {
        System.out.println("Invalid choice! Please try again.");
      }
    }
  }
}
