import java.util.List;
import java.util.Scanner;

public class Week10Test {
    public static void main(String[] args) {
        Week10 w10 = new Week10();
        Scanner scanner = new Scanner(System.in);
        String fileContents = "";
        while (scanner.hasNextLine()) fileContents += scanner.nextLine() + "\n";
        List<String> results = w10.getAllFunctions(fileContents);
        for (String result : results) System.out.println(result);
    }
}
