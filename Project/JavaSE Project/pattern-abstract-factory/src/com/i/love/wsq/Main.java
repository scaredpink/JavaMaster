package com.i.love.wsq;

import com.i.love.wsq.fastdoc.FastFactory;
import com.i.love.wsq.service.AbstractFactory;
import com.i.love.wsq.service.HtmlDocument;
import com.i.love.wsq.service.WordDocument;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author baitao05
 */
public class Main {
    public static void main(String[] args) throws IOException {
        AbstractFactory factory = new FastFactory();
//        AbstractFactory factory = new GoodFactory();
        HtmlDocument html = factory.createHtml("#Hello\nHello, bt!");
        html.save(Paths.get(".", "fast.html"));
        WordDocument word = factory.createWord("#Hello\nHello, bt!");
        word.save(Paths.get(".", "fast.doc"));
    }
}
