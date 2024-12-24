package com.i.love.wsq.service;


/**
 * @author baitao05
 */
public abstract interface AbstractFactory {
    HtmlDocument createHtml(String md);
    WordDocument createWord(String md);
}
