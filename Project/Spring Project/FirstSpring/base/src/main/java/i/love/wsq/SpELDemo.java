package i.love.wsq;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author baitao05
 */
public class SpELDemo {
    public static void main(String[] args) {
        // 字符串截取 substring()
        // 字符串转大写 toUpperCase()
        // 表达式中有两个变量start和end
        String str = "(\"www\" + \"baidu.com\").substring(#start, #end).toUpperCase()"; // 定义字符串
        // 1、
        ExpressionParser parser = new SpelExpressionParser(); // 定义SpEL解析器
        Expression exp = parser.parseExpression(str); // 表达式解析
        // 表达式执行之前还要考虑占位符的配置问题


    }
}
