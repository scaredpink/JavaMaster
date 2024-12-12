package com.meituan.baobab.tms.service.charge.dto.request;


/**
 * @description:
 * @author: qizhiying
 * @date: 2023/4/6
 * @time: 19:31
 * Copyright (C) 2022 MTDP
 * All rights reserved
 */
public class CustomerInfoDto {
    private Long customerId;
    private Long salesGridId;
    private Integer adminCityId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getSalesGridId() {
        return salesGridId;
    }

    public void setSalesGridId(Long salesGridId) {
        this.salesGridId = salesGridId;
    }

    public Integer getAdminCityId() {
        return adminCityId;
    }

    public void setAdminCityId(Integer adminCityId) {
        this.adminCityId = adminCityId;
    }

    @Override
    public String toString() {
        return "CustomerInfoDto{" +
                "customerId=" + customerId +
                ", salesGridId=" + salesGridId +
                ", adminCityId=" + adminCityId +
                '}';
    }
}
