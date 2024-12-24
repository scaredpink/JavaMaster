package com.i.love.wsq.service;

import java.io.IOException;
import java.nio.file.Path;

/**
 * @author baitao05
 */
// Html文档接口
public interface HtmlDocument {
    String toHtml();
    void save(Path path) throws IOException;
}
