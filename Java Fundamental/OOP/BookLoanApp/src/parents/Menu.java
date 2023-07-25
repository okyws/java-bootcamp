package parents;

import java.util.ArrayList;
import java.util.Scanner;

import childs.BookForLoan;
import interfaces.IBackToMenu;
import repository.RepositoryBookForLoan;
import repository.RepositoryMember;

public class Menu implements IBackToMenu {

  public static Scanner input = new Scanner(System.in);

  public static void printMainMenu() {
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

  public static void clearScreen() {
    try {
      // tambah delay 1 detik
      Thread.sleep(1000);
      System.out.print("\033\143");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void mainMenu(boolean isLooping) {
    while (isLooping) {
      printMainMenu();
      int option = Integer.parseInt(input.nextLine());

      switch (option) {
        case 1:
          clearScreen();
          handleOption1();
          break;
        case 2:
          clearScreen();
          handleOption2();
          break;
        case 3:
          clearScreen();
          System.out.println("Return Book");
          return;
        case 4:
          clearScreen();
          return;
        case 5:
          clearScreen();
          handleOption5();
          break;
        case 0:
          System.out.println("Exit");
          input.close();
          return;
        default:
          System.out.println("Input yang anda masukkan salah!");
          clearScreen();
          break;
      }
    }
  }

  public void handleOption1() {
    System.out.println("Data All Book For Loan");
    RepositoryBookForLoan repositoryBookForLoan = new RepositoryBookForLoan(new ArrayList<BookForLoan>());
    repositoryBookForLoan.getAllBookForLoan();
    System.out.println("0. Back to Main Menu");
    System.out.println(
        "==========================================================================================================================================");

    backToMenu();
  }

  public void handleOption5() {
    System.out.println("Data All Member");
    RepositoryMember repositoryMember = new RepositoryMember(new ArrayList<Member>());
    repositoryMember.getAllMember();
    System.out.println("0. Back to Main Menu");
    System.out.println("==================================================================================");

    backToMenu();
  }

  private void handleOption2() {
    System.out.println("Loan Book");
    RepositoryBookForLoan bookForLoan = new RepositoryBookForLoan(new ArrayList<BookForLoan>());
    bookForLoan.getAllBookForLoan();
    System.out.print("Enter the Book ID: ");
    String bookID = input.nextLine();

    bookForLoan.getBook(bookID);
    bookForLoan.updateLoanPriceBook(bookID, bookForLoan.getBook(bookID).getBookLoanPrice());
    System.out.println(bookForLoan.getBook(bookID).toString());

    if (bookForLoan != null) {
      RepositoryMember member = new RepositoryMember(new ArrayList<Member>());
      member.getAllMember();
      System.out.println("Enter the Member ID: ");
      int indexMember = Integer.parseInt(input.nextLine());
      System.out.println(member.getMemberByIndex(indexMember).toString());

      if (member != null) {
        System.out.println("Enter the Loan Duration (in days): ");
        int loanDuration = Integer.parseInt(input.nextLine());

        double loanFee = bookForLoan.getBook(bookID).calculateBookLoanPrice() * loanDuration;
        System.out.println(loanFee);

        System.out.println("Loan successful!");

        bookForLoan.updateStockBook(bookID, bookForLoan.getBook(bookID).getStock());
        bookForLoan.getAllBookForLoan();
      }
    }

    System.out.println("0. Back to Main Menu");
    backToMenu();
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
