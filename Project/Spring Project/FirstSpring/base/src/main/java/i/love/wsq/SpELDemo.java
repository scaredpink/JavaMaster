package i.love.wsq;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author baitao05
 */
public class SpELDemo {
    public static void main(String[] args) {
        String str = "10 + 20";
        ExpressionParser parser = new SpelExpressionParser(); // 定义SpEL解析器
        Expression exp = parser.parseExpression(str); // 表达式解析
        // 表达式执行之前还要考虑占位符的配置问题
        EvaluationContext context = new StandardEvaluationContext(); // 表达式上下文配置
        System.out.println("SpEL处理结果: " + exp.getValue(context));
    }
}
