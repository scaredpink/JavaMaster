package com.i.love.wsq.fastdoc;

import com.i.love.wsq.service.HtmlDocument;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

/**
 * @author baitao05
 */
public class FastHtmlDocument implements HtmlDocument {
    private String md;
    public FastHtmlDocument(){}
    public FastHtmlDocument(String md) {
        this.md = md;
    }
    @Override
    public String toHtml() {
        try (BufferedReader reader = new BufferedReader(new StringReader(md))) {
            return reader.lines().map(s -> {
                if (s.startsWith("#")) {
                    return "<h1>" + s.substring(1) + "</h1>";
                }
                return "<p>" + s + "</p>";
            }).collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void save(Path path) throws IOException {
        Files.write(path, toHtml().getBytes("UTF-8"));
    }
}
