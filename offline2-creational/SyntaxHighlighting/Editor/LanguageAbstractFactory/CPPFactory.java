package SyntaxHighlighting.Editor.LanguageAbstractFactory;

import SyntaxHighlighting.Fonts.Font;
import SyntaxHighlighting.Fonts.Monaco;
import SyntaxHighlighting.Parser.CPPParser;
import SyntaxHighlighting.Parser.Parser;

public class CPPFactory implements LanguageFactory {
    @Override
    public Parser createParser() {
        return new CPPParser();
    }

    @Override
    public Font createFont() {
        return new Monaco();
    }
}
