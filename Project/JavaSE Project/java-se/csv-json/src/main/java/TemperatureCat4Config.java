import java.math.BigDecimal;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class TemperatureCat4Config {
    /**
     * 四级类目id
     */
    private Integer cat4Id;

    /**
     * 四级类目名称
     */
    private String cat4Name;

    /**
     * 最大温度值
     */
    private BigDecimal maxTemperature;
    /**
     * 最小温度值
     */
    private BigDecimal minTemperature;


    public boolean qualified(String temperature){
        if(StringUtils.isEmpty(temperature) || maxTemperature == null || minTemperature == null){
            return false;
        }
        BigDecimal tempValue = new BigDecimal(temperature);
        return tempValue.compareTo(minTemperature) >= 0 && tempValue.compareTo(maxTemperature) <= 0;
    }
}
