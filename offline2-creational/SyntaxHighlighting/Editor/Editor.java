package SyntaxHighlighting.Editor;

import SyntaxHighlighting.Editor.LanguageAbstractFactory.CFactory;
import SyntaxHighlighting.Editor.LanguageAbstractFactory.CPPFactory;
import SyntaxHighlighting.Editor.LanguageAbstractFactory.LanguageFactory;
import SyntaxHighlighting.Editor.LanguageAbstractFactory.PythonFactory;
import SyntaxHighlighting.Fonts.Font;
import SyntaxHighlighting.Parser.Parser;
import SyntaxHighlighting.SyntaxHighlightException.SyntaxHighlightException;

public class Editor {
    private static Editor EDITOR = null;

    private Parser parser;
    private Font font;

    private Editor() {
    }

    public static Editor getEditor() {
        if (EDITOR == null) {
            EDITOR = new Editor();
        }
        return EDITOR;
    }

    public void openFile(String filename) {
        LanguageFactory languageFactory;
        if (filename.endsWith(".c")) {
            languageFactory = new CFactory();
        } else if (filename.endsWith(".cpp")) {
            languageFactory = new CPPFactory();
        } else if (filename.endsWith(".py")) {
            languageFactory = new PythonFactory();
        } else {
            throw new SyntaxHighlightException("Not a valid extension");
        }

        this.parser = languageFactory.createParser();
        this.font = languageFactory.createFont();
    }

    public void showEnvironment() {
        // font
        this.font.show();
    }

    public void parse() {
        this.parser.parse();
    }
}