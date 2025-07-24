import java.util.HashMap;
import java.util.Map;

/**
 * @author baitao05
 */
public class Main {
    public static void main(String[] args) {
        String expression = "(concessionReceiptNumber == nil || concessionReceiptNumber == '') ? '0' : str(long(double(concessionReceiptNumber)))";
        ExpressionExecuteUtils expressionExecuteUtils = new ExpressionExecuteUtils();
        Map<String, Object> map = new HashMap<>();

//        map.put("containerEliminate", "");
        String finalColumnValue = expressionExecuteUtils.expressionExecute(expression, map, String.class);
        System.out.println(finalColumnValue);
    }
}
