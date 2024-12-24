package com.itranswarp.learnjava;

import java.util.Map;

import com.itranswarp.learnjava.html.HtmlBuilder;
import com.itranswarp.learnjava.url.URLBuilder;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) {
		String markdown = String.join("\n", // Markdown document
				"## Builder Pattern", // heading
				"> Seperate the construction of a complex object from its representation",
				"Use builder pattern when the construction process is complex.", "----", "Here is an example.");
		HtmlBuilder builder = new HtmlBuilder();
		String html = builder.toHtml(markdown);
		System.out.println(html);

		String url = URLBuilder.builder() // 创建Builder
				.setDomain("www.liaoxuefeng.com") // 设置domain
				.setScheme("https") // 设置scheme
				.setPath("/") // 设置路径
				.setQuery(Map.of("a", "123", "q", "K&R")) // 设置query
				.build(); // 完成build
		System.out.println(url);
	}
}
