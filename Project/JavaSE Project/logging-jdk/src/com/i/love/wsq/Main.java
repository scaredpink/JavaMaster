package com.i.love.wsq;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(Main.class.getName());
		logger.info("Start process...");
		try {
			"".getBytes("invalidCharsetName");
		} catch (UnsupportedEncodingException e) {
			logger.severe("不支持的编码类型");
		}

		logger.info("Process end.");
	}
}
