package com.meituan.baobab.tms.service.charge.dto.servicechargev2;

import com.meituan.baobab.tms.service.charge.dto.request.CustomerInfoDto;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 *
 */
public class QueryServiceChargeReqDto{

    private CustomerInfoDto customer;

    private Date requestTime;

    private List<RegionServiceChargeRuleReqDto> regionServiceChargeRuleReqDtoList;

    public CustomerInfoDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerInfoDto customer) {
        this.customer = customer;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public List<RegionServiceChargeRuleReqDto> getRegionServiceChargeRuleReqDtoList() {
        return regionServiceChargeRuleReqDtoList;
    }

    public void setRegionServiceChargeRuleReqDtoList(List<RegionServiceChargeRuleReqDto> regionServiceChargeRuleReqDtoList) {
        this.regionServiceChargeRuleReqDtoList = regionServiceChargeRuleReqDtoList;
    }

    @Override
    public String toString() {
        return "QueryServiceChargeReqDto{" +
                "customer=" + customer +
                ", requestTime=" + requestTime +
                ", regionServiceChargeRuleReqDtoList=" + regionServiceChargeRuleReqDtoList +
                '}';
    }
}
