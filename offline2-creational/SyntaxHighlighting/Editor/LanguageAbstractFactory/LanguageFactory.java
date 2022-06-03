package SyntaxHighlighting.Editor.LanguageAbstractFactory;

import SyntaxHighlighting.Fonts.Font;
import SyntaxHighlighting.Parser.Parser;

public interface LanguageFactory {
    public Parser createParser();
    public Font createFont();
}
