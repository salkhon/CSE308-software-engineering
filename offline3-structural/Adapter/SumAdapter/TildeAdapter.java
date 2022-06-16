package SumAdapter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Sum.Sum;

public class TildeAdapter implements SumAdapter {
    Sum sumService;

    public TildeAdapter() {
        this.sumService = new Sum();
    }

    @Override
    public int calculateSum(File file) {
        int sum = 0;
        File spaceDelimFile = new File(file.getName().replace(".txt", "") + "-space-delim.txt");
        try (Scanner scanner = new Scanner(file);
                FileWriter fileWriter = new FileWriter(spaceDelimFile)) {
            scanner.useDelimiter("~");
            while (scanner.hasNext()) {
                fileWriter.write(scanner.next() + " ");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        sum = this.sumService.calculateSum(spaceDelimFile);
        spaceDelimFile.delete();

        return sum;
    }
}