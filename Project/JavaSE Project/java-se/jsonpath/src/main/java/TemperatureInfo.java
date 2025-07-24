import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;

@Data
public class TemperatureInfo {

    /**
     * 是否完成登记
     */
    private Integer temperatureRegister = 0;

    /**
     * 登记总数
     */
    private Integer registerNumber = 0;

    /**
     * 合格数
     */
    private Integer qualifiedNumber = 0;

    /**
     * 不合格数
     */
    private Integer unqualifiedNumber = 0;

    // todo 检查number为空的情况，不要参与大小比较
    /**
     * sku温度登记明细
     */
    private List<TemperatureSkuInfo> temperatureSkuInfoList = new ArrayList<>();

    public TemperatureInfo() {
        this.temperatureRegister = 0;
        this.registerNumber = 0;
        this.qualifiedNumber = 0;
        this.unqualifiedNumber = 0;
        this.temperatureSkuInfoList = new ArrayList<>();
    }

    /**
     * 获取sku温度信息
     */
    public TemperatureSkuInfo getSkuTemperatureInfo(Integer skuCode) {
        return ListUtils.emptyIfNull(temperatureSkuInfoList).stream()
                .filter(e -> Objects.equals(e.getSkuCode(), skuCode)).findFirst().orElse(null);
    }

    /**
     * 添加sku温度信息，已存在则更新
     *
     */

    /**
     * 整体是否完成登记
     */
    public boolean completeRegister() {
        return Objects.equals(temperatureRegister, 1);
    }

    /**
     * 整体是否合格
     */
    public Integer result() {
        return completeRegister() && Objects.equals(qualifiedNumber, registerNumber) ? 2 : 3;
    }

    public boolean full(Integer temperatureMaxSize) {
        if (Objects.isNull(registerNumber) || Objects.isNull(temperatureMaxSize)) {
            return false;
        }
        return registerNumber.compareTo(temperatureMaxSize) >= 0;
    }
}