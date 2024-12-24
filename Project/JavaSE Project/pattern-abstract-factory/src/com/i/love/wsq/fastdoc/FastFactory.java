package com.i.love.wsq.fastdoc;

import com.i.love.wsq.service.AbstractFactory;
import com.i.love.wsq.service.HtmlDocument;
import com.i.love.wsq.service.WordDocument;

/**
 * @author baitao05
 */
public class FastFactory implements AbstractFactory {
    @Override
    public HtmlDocument createHtml(String md) {
        return new FastHtmlDocument(md);
    }

    @Override
    public WordDocument createWord(String md) {
        return new FastWordDocument(md);
    }
}
