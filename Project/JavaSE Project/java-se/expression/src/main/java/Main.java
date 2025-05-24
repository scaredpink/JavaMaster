import java.util.HashMap;
import java.util.Map;

/**
 * @author baitao05
 */
public class Main {
    public static void main(String[] args) {
        String expression = "(deliverType == nil || deliverType == '' || deliverType == '1' )?'QC_PURCHASE_INBOUND_PARCEL_ELIMINATE_INFO_OWNER_NOTIFICATION' : deliverType == '2' ?'QC_PURCHASE_INBOUND_PARCEL_ELIMINATE_INFO_SELLER_NOTIFICATION':'QC_PURCHASE_INBOUND_PARCEL_ELIMINATE_INFO_SUPPLIER_NOTIFICATION'";
        ExpressionExecuteUtils expressionExecuteUtils = new ExpressionExecuteUtils();
        Map<String, Object> map = new HashMap<>();
        map.put("deliverType", "3");

//        map.put("containerEliminate", "");
        String finalColumnValue = expressionExecuteUtils.expressionExecute(expression, map, String.class);
        System.out.println(finalColumnValue);
    }
}
