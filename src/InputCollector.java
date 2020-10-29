import java.util.Scanner;

public class InputCollector {
  protected static String getUserInput(String prompt) {
    System.out.println(prompt);
    Scanner in = new Scanner(System.in);
    return in.nextLine();
  }

}
