package by.bsuir.textparser.parser;

import by.bsuir.textparser.compositor.CompositeTextPart;

public class TextParser {

    private CompositeTextPart sentence; // words(Leaf) + punctuation characters(Leaf)
    private CompositeTextPart paragraph; // sentences(Composite)
    private CompositeTextPart text; // paragraphs(Composite) + code(Leaf)


//    public void parse (String text) {
//
//    }
//
//    public CompositeTextPart parseParagraph(String paragraph) { // parse paragraph into sentences
//
//    }
}
