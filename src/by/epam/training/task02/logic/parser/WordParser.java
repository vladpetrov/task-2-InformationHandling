package by.epam.training.task02.logic.parser;

import by.epam.training.task02.entity.LeafTextElement;
import by.epam.training.task02.entity.TextComponent;
import by.epam.training.task02.util.regexutil.RegexConstants;
import by.epam.training.task02.util.regexutil.RegexTools;

import java.util.List;

/**
 * Created by Higgs on 08.04.2015.
 */
public class WordParser extends Parser {

    public WordParser() {
        super();
    }

    @Override
    public void parse(String text, TextComponent parentComponent) {
        TextComponent component;
        List<String> matches;

        if (RegexTools.matches(RegexConstants.WORD_REGEX, text)) {
            matches = RegexTools.findByRegex(RegexConstants.WORD_REGEX, text);
            for (String match : matches) {
                component = new LeafTextElement(match);
                parentComponent.addTextComponent(component);
            }
            System.out.println("Parsers chain end!");
        } else {
            System.out.println("No words to parse!");
        }
    }

}
