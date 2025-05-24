import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.AviatorEvaluatorInstance;

import java.util.Map;

public class ExpressionExecuteUtils {

    //表达式引擎
    private final AviatorEvaluatorInstance instance = AviatorEvaluator.newInstance().useLRUExpressionCache(10000);
    /**
     * 表达式执行
     *
     * @param expression
     * @param env
     * @return
     */
    public boolean expressionExecute(String expression, final Map<String, Object> env) {
        return (boolean) instance.execute(expression, env, true);
    }

    /**
     * 表达式执行
     *
     * @param expression
     * @param env
     * @return
     */
    public <T> T expressionExecute(String expression, final Map<String, Object> env, Class<T> resultClass) {
        return (T) instance.execute(expression, env, true);
    }
}
