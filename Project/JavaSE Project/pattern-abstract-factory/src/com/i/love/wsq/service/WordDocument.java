package com.i.love.wsq.service;

import java.io.IOException;
import java.nio.file.Path;

/**
 * @author baitao05
 */
// Word文档接口
public interface WordDocument {
    void save(Path path) throws IOException;
}
