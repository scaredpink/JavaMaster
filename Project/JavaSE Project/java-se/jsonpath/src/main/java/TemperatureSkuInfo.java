import java.util.Map;
import java.util.Objects;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class TemperatureSkuInfo {

    /**
     * 类目
     */
    private Integer cat2Id;

    private Integer cat3Id;

    private Integer cat4Id;

    private String cat2Name;

    private String cat3Name;

    private String cat4Name;

    /**
     * sku
     */
    private Integer skuCode;

    private String skuName;

    /**
     * 温度数据
     */
    private String temperature;

    /**
     * 温度图片
     */
    private String temperaturePicValue;

    /**
     * sku温度结果（1-未登记 2-合格 3-不合格）
     */
    private Integer result;

    /**
     * 温度登记人
     */
    private String registerMisId;

    private String registerMisName;

    private String registerAccountType;

    /**
     * 登记时间
     */
    private String registerTime;

    public TemperatureSkuInfo() {
    }

    public TemperatureSkuInfo(Map<String, String> businessMap) {
        this.cat2Id = businessMap.containsKey("cat2Id") ? Integer.valueOf(businessMap.get("cat2Id")) : null;
        this.cat3Id = businessMap.containsKey("cat3Id") ? Integer.valueOf(businessMap.get("cat3Id")) : null;
        this.cat4Id = businessMap.containsKey("cat4Id") ? Integer.valueOf(businessMap.get("cat4Id")) : null;
        this.cat2Name = businessMap.get("cat2Name");
        this.cat3Name = businessMap.get("cat3Name");
        this.cat4Name = businessMap.get("cat4Name");
        this.skuCode = businessMap.containsKey("skuCode") ? Integer.valueOf(businessMap.get("skuCode")) : null;
        this.skuName = businessMap.get("skuName");
        this.temperature = businessMap.containsKey("temperature") ? businessMap.get("temperature").trim() : null;
        this.temperaturePicValue = businessMap.get("temperaturePicValue");
    }

    public boolean valid() {
        return Objects.nonNull(skuCode) && StringUtils.isNotEmpty(temperature)
                && StringUtils.isNotEmpty(temperaturePicValue);
    }
}
