import java.util.Scanner;

public class ObjectForm {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double temperature;

    temperature = input.nextDouble();

    if (temperature >= 0 && temperature <= 100) {
      System.out.print("berwujud cair");
    } else if (temperature < -150 || temperature > 150) {
      System.out.print("tidak berwujud / diluar range nilai");
    } else {
      System.out.print("berwujud non cair");
    }

    input.close();
  }
}
