package com.meituan.baobab.tms.service.charge.dto.request;

/**
 * @description:
 * @author: qizhiying
 * @date: 2024/2/4
 * @time: 09:54
 * Copyright (C) 2022 MTDP
 * All rights reserved
 */

public class CsuDto{

    private Integer csuCode;

    private Integer skuCode;

    @Deprecated
    private Short csuType;

    private Integer buId;

    private Short sceneTag;

    public Integer getCsuCode() {
        return csuCode;
    }

    public void setCsuCode(Integer csuCode) {
        this.csuCode = csuCode;
    }

    public Integer getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(Integer skuCode) {
        this.skuCode = skuCode;
    }

    public Short getCsuType() {
        return csuType;
    }

    public void setCsuType(Short csuType) {
        this.csuType = csuType;
    }

    public Integer getBuId() {
        return buId;
    }

    public void setBuId(Integer buId) {
        this.buId = buId;
    }

    public Short getSceneTag() {
        return sceneTag;
    }

    public void setSceneTag(Short sceneTag) {
        this.sceneTag = sceneTag;
    }

    @Override
    public String toString() {
        return "CsuDto{" +
                "csuCode=" + csuCode +
                ", skuCode=" + skuCode +
                ", csuType=" + csuType +
                ", buId=" + buId +
                ", sceneTag=" + sceneTag +
                '}';
    }
}
