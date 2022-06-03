package SyntaxHighlighting.Editor.LanguageAbstractFactory;

import SyntaxHighlighting.Fonts.Consolas;
import SyntaxHighlighting.Fonts.Font;
import SyntaxHighlighting.Parser.Parser;
import SyntaxHighlighting.Parser.PythonParser;

public class PythonFactory implements LanguageFactory {
    @Override
    public Parser createParser() {
        return new PythonParser();
    }

    @Override
    public Font createFont() {
        return new Consolas();
    }
}
