package SyntaxHighlighting;

import java.util.Scanner;

import SyntaxHighlighting.Editor.Editor;
import SyntaxHighlighting.SyntaxHighlightException.SyntaxHighlightException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter filename: ");
        String filename = scanner.nextLine();

        Editor editor = Editor.getEditor();
        try {
            editor.openFile(filename);
            editor.showEnvironment();
            editor.parse();
        } catch (SyntaxHighlightException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
