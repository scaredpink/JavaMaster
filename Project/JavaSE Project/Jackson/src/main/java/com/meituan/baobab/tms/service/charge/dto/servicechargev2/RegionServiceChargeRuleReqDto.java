package com.meituan.baobab.tms.service.charge.dto.servicechargev2;


import com.meituan.baobab.tms.service.charge.dto.request.CsuDto;
import java.util.List;

/**
 *
 */
public class RegionServiceChargeRuleReqDto{

    private Long warehouseId;

    private Long regionId;

    private Integer fulfillmentWaveId;

    private List<CsuDto> csuList;


    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public Integer getFulfillmentWaveId() {
        return fulfillmentWaveId;
    }

    public void setFulfillmentWaveId(Integer fulfillmentWaveId) {
        this.fulfillmentWaveId = fulfillmentWaveId;
    }

    public List<CsuDto> getCsuList() {
        return csuList;
    }

    public void setCsuList(List<CsuDto> csuList) {
        this.csuList = csuList;
    }

    @Override
    public String toString() {
        return "RegionServiceChargeRuleReqDto{" +
                "warehouseId=" + warehouseId +
                ", regionId=" + regionId +
                ", fulfillmentWaveId=" + fulfillmentWaveId +
                ", csuList=" + csuList +
                '}';
    }
}
