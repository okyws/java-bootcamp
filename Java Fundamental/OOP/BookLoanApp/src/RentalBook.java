import java.util.ArrayList;
import java.util.Scanner;

import parents.BookForLoan;
import parents.Menu;
import repository.RepositoryBookForLoan;

public class RentalBook {

  public static Menu menu = new Menu();
  public static Scanner input = new Scanner(System.in);
  RepositoryBookForLoan repositoryBookForLoan = new RepositoryBookForLoan(new ArrayList<BookForLoan>());

  public static void main(String[] args) {
    boolean isLooping = true;

    mainMenu(isLooping);
  }

  public static void mainMenu(boolean isLooping) {
    while (isLooping) {
      menu.printMainMenu();
      int option = Integer.parseInt(input.nextLine());

      switch (option) {
        case 1:
          menu.clearScreen();
          menu.handleOption1();
          break;
        case 2:
          menu.clearScreen();
          menu.handleOption2();
          break;
        case 3:
          menu.clearScreen();
          menu.handleOption3();
          break;
        case 4:
          menu.clearScreen();
          menu.handleOption4();
          break;
        case 5:
          menu.clearScreen();
          menu.handleOption5();
          break;
        case 0:
          System.out.println("Exit");
          input.close();
          return;
        default:
          System.out.println("Input yang anda masukkan salah!");
          menu.clearScreen();
          break;
      }
    }
  }
}
