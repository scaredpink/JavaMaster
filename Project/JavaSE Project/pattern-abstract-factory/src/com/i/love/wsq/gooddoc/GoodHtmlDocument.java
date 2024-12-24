package com.i.love.wsq.gooddoc;

import com.i.love.wsq.service.HtmlDocument;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author baitao05
 */
public class GoodHtmlDocument implements HtmlDocument {
    private String md;

    public GoodHtmlDocument(String md) {
        this.md = md;
    }
    @Override
    public String toHtml() {
        try (BufferedReader reader = new BufferedReader(new StringReader(md))) {
            String body = reader.lines().map(s -> {
                if (s.startsWith("#")) {
                    return "<h1>" + s.substring(1) + "</h1>";
                }
                return "<p>" + s + "</p>";
            }).reduce("", (acc, s) -> acc + s + "\n");
            return "<html>\n<body>\n" + body + "\n</body>\n</html>";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Path path) throws IOException {
        Files.write(path, toHtml().getBytes("UTF-8"));
    }
}
