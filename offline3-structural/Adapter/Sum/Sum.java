package Sum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sum {
    public Sum() {
    }

    public int calculateSum(File file) {
        int sum = 0;
        try (Scanner scanner = new Scanner(file)) {
            scanner.useDelimiter(" ");
            while (scanner.hasNext()) {
                sum += Integer.parseInt(scanner.next().trim());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return sum;
    }
}