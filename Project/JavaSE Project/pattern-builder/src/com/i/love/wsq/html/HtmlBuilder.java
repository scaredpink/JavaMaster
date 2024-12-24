package com.i.love.wsq.html;

import java.io.BufferedReader;
import java.io.StringReader;

/**
 * @author baitao05
 */
public class HtmlBuilder {
    private HeadingBuilder headingBuilder = new HeadingBuilder();
    private HrBuilder hrBuilder = new HrBuilder();
    private ParagraphBuilder paragraphBuilder = new ParagraphBuilder();
    private QuoteBuilder quoteBuilder = new QuoteBuilder();

    public String toHtml(String markdown) {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new StringReader(markdown));
        reader.lines().forEach(line -> {
            if (line.startsWith("#")) {
                builder.append(headingBuilder.buildHeading(line)).append("\n");
            } else if (line.startsWith(">")) {
                builder.append(quoteBuilder.buildQuote(line).append("\n"));
            } else if (line.startsWith("---")) {
                builder.append(hrBuilder.buildHr(line).append("\n"));
            } else {
                builder.append(paragraphBuilder.buildParagraph(line).append("\n"));
            }
        });
        return builder.toString();
    }
}
