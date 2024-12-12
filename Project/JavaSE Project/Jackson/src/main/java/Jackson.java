import com.dianping.lion.client.util.JsonUtils;
import com.dianping.pigeon.remoting.common.codec.json.JacksonUtils;

import com.meituan.baobab.tms.service.charge.dto.servicechargev2.QueryServiceChargeReqDto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Jackson {

    public static void main(String[] args) throws IOException {
        QueryServiceChargeReqDto dto = JsonUtils.fromJson("{\"customer\":{\"customerId\":11560699,\"salesGridId\":50000022,\"adminCityId\":null,\"latLngDto\":{\"longitude\":116.491748,\"latitude\":39.802742}},\"requestTime\":\"2024-12-12T15:50:49.1234\",\"regionServiceChargeRuleReqDtoList\":[{\"warehouseId\":159,\"regionId\":2577,\"fulfillmentWaveId\":1,\"csuList\":[{\"csuCode\":10095862,\"skuCode\":10033216,\"csuType\":1,\"buId\":110100,\"sceneTag\":1},{\"csuCode\":10080748,\"skuCode\":10020290,\"csuType\":1,\"buId\":110100,\"sceneTag\":1},{\"csuCode\":10097831,\"skuCode\":10035089,\"csuType\":1,\"buId\":110100,\"sceneTag\":1},{\"csuCode\":102795926,\"skuCode\":21945111,\"csuType\":1,\"buId\":110100,\"sceneTag\":1},{\"csuCode\":10116972,\"skuCode\":10053662,\"csuType\":1,\"buId\":110100,\"sceneTag\":1},{\"csuCode\":10094554,\"skuCode\":10031963,\"csuType\":1,\"buId\":110100,\"sceneTag\":1},{\"csuCode\":74079113,\"skuCode\":74074167,\"csuType\":1,\"buId\":11019630,\"sceneTag\":1},{\"csuCode\":21804801,\"skuCode\":21789340,\"csuType\":1,\"buId\":110100,\"sceneTag\":1},{\"csuCode\":21808253,\"skuCode\":21803825,\"csuType\":1,\"buId\":110100,\"sceneTag\":1},{\"csuCode\":21805906,\"skuCode\":21805307,\"csuType\":1,\"buId\":110100,\"sceneTag\":1},{\"csuCode\":74067381,\"skuCode\":74073285,\"csuType\":1,\"buId\":11019630,\"sceneTag\":1}]},{\"warehouseId\":159,\"regionId\":2577,\"fulfillmentWaveId\":2,\"csuList\":[{\"csuCode\":10095862,\"skuCode\":10033216,\"csuType\":1,\"buId\":110100,\"sceneTag\":1},{\"csuCode\":10080748,\"skuCode\":10020290,\"csuType\":1,\"buId\":110100,\"sceneTag\":1},{\"csuCode\":10097831,\"skuCode\":10035089,\"csuType\":1,\"buId\":110100,\"sceneTag\":1},{\"csuCode\":10116972,\"skuCode\":10053662,\"csuType\":1,\"buId\":110100,\"sceneTag\":1},{\"csuCode\":10094554,\"skuCode\":10031963,\"csuType\":1,\"buId\":110100,\"sceneTag\":1},{\"csuCode\":74079113,\"skuCode\":74074167,\"csuType\":1,\"buId\":11019630,\"sceneTag\":1},{\"csuCode\":21808253,\"skuCode\":21803825,\"csuType\":1,\"buId\":110100,\"sceneTag\":1},{\"csuCode\":74067381,\"skuCode\":74073285,\"csuType\":1,\"buId\":11019630,\"sceneTag\":1}]},{\"warehouseId\":159,\"regionId\":2577,\"fulfillmentWaveId\":5,\"csuList\":[{\"csuCode\":10095862,\"skuCode\":10033216,\"csuType\":1,\"buId\":110100,\"sceneTag\":1},{\"csuCode\":10080748,\"skuCode\":10020290,\"csuType\":1,\"buId\":110100,\"sceneTag\":1},{\"csuCode\":10097831,\"skuCode\":10035089,\"csuType\":1,\"buId\":110100,\"sceneTag\":1},{\"csuCode\":10597230,\"skuCode\":10594916,\"csuType\":1,\"buId\":110100,\"sceneTag\":1},{\"csuCode\":10116972,\"skuCode\":10053662,\"csuType\":1,\"buId\":110100,\"sceneTag\":1},{\"csuCode\":10094554,\"skuCode\":10031963,\"csuType\":1,\"buId\":110100,\"sceneTag\":1},{\"csuCode\":74079113,\"skuCode\":74074167,\"csuType\":1,\"buId\":11019630,\"sceneTag\":1},{\"csuCode\":10597231,\"skuCode\":10596295,\"csuType\":1,\"buId\":110100,\"sceneTag\":1},{\"csuCode\":21808253,\"skuCode\":21803825,\"csuType\":1,\"buId\":110100,\"sceneTag\":1},{\"csuCode\":74067381,\"skuCode\":74073285,\"csuType\":1,\"buId\":11019630,\"sceneTag\":1}]}],\"requestTimeDateLong\":1733989849510}", QueryServiceChargeReqDto.class);

        // 调用JacksonUtils.serialize()序列化
        System.out.println(JacksonUtils.serialize(dto));
        System.out.println(dto);
    }


}