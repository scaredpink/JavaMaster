package com.i.love.wsq.gooddoc;

import com.i.love.wsq.fastdoc.FastHtmlDocument;
import com.i.love.wsq.fastdoc.FastWordDocument;
import com.i.love.wsq.service.AbstractFactory;
import com.i.love.wsq.service.HtmlDocument;
import com.i.love.wsq.service.WordDocument;

/**
 * @author baitao05
 */
public class GoodFactory implements AbstractFactory {
    @Override
    public HtmlDocument createHtml(String md) {
        return new FastHtmlDocument(md);
    }
    @Override
    public WordDocument createWord(String md) {
        return new FastWordDocument(md);
    }
}

