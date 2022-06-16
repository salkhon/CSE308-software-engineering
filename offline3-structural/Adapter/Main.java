import java.io.File;

import SumAdapter.SumAdapter;
import SumAdapter.TildeAdapter;

public class Main {
    public static void main(String[] args) {
        File tildeDelimFile = new File("ints.txt");
        SumAdapter sumAdapter = new TildeAdapter();

        int sum = sumAdapter.calculateSum(tildeDelimFile);
        System.out.println(sum);
    }
}