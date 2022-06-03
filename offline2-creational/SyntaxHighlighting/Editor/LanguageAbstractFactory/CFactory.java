package SyntaxHighlighting.Editor.LanguageAbstractFactory;

import SyntaxHighlighting.Fonts.CourierNew;
import SyntaxHighlighting.Fonts.Font;
import SyntaxHighlighting.Parser.CParser;
import SyntaxHighlighting.Parser.Parser;

public class CFactory implements LanguageFactory {
    @Override
    public Parser createParser() {
        return new CParser();
    }

    @Override
    public Font createFont() {
        return new CourierNew();
    }
}
