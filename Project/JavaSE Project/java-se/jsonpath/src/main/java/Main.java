import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author baitao05
 */
public class Main {
    private static Configuration jsonPathConfiguration = Configuration.defaultConfiguration();
    public static void main(String[] args) {
//
//
//        String inputParam = "{\n" +
//                "    \"qcNo\": \"12345\",\n" +
//                "    \"qcStrategy\": {\n" +
//                "        \"other\": \"123\",\n" +
//                "        \"riskLevelDetail\": \"[{\\\"labelType\\\":\\\"1\\\",\\\"riskLevel\\\":\\\"20\\\",\\\"riskLevelLabel\\\":\\\"BEFORE_HIGH_RISK_LEVEL_SKU\\\",\\\"labelCodeDesc\\\":\\\"前置风险\\\",\\\"labelRuleDesc\\\":\\\"\\\",\\\"ruleGuidance\\\":\\\"\\\"},{\\\"labelType\\\":\\\"2\\\",\\\"riskLevel\\\":\\\"20\\\",\\\"riskLevelLabel\\\":\\\"MANUAL_HIGH_RISK_LEVEL_SKU\\\",\\\"labelCodeDesc\\\":\\\"手动高风险\\\",\\\"labelRuleDesc\\\":\\\"\\\",\\\"ruleGuidance\\\":\\\"\\\"},{\\\"labelType\\\":\\\"3\\\",\\\"riskLevel\\\":\\\"20\\\",\\\"riskLevelLabel\\\":\\\"QUALITY_RISK_LABEL\\\",\\\"labelCodeDesc\\\":\\\"质量高风险\\\",\\\"labelRuleDesc\\\":\\\"xxxxxxxxxxxx驼峰上配置的xxxxxx\\\",\\\"ruleGuidance\\\":\\\"xxxxxxxxxxxx驼峰上配置的xxxxxx\\\"}]\"\n" +
//                "    }\n" +
//                "}";
//
//        String inputParam2 = "{\n" +
//                "    \"qcNo\": \"12345\",\n" +
//                "    \"qcStrategy\": {\n" +
//                "        \"other\": \"123\",\n" +
//                "        \"riskLevelDetail\": [\n" +
//                "            {\n" +
//                "                \"labelType\": \"1\",\n" +
//                "                \"riskLevel\": \"20\",\n" +
//                "                \"riskLevelLabel\": \"BEFORE_HIGH_RISK_LEVEL_SKU\",\n" +
//                "                \"labelCodeDesc\": \"前置风险\",\n" +
//                "                \"labelRuleDesc\": \"\",\n" +
//                "                \"ruleGuidance\": \"\"\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"labelType\": \"2\",\n" +
//                "                \"riskLevel\": \"20\",\n" +
//                "                \"riskLevelLabel\": \"MANUAL_HIGH_RISK_LEVEL_SKU\",\n" +
//                "                \"labelCodeDesc\": \"手动高风险\",\n" +
//                "                \"labelRuleDesc\": \"\",\n" +
//                "                \"ruleGuidance\": \"\"\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"labelType\": \"3\",\n" +
//                "                \"riskLevel\": \"20\",\n" +
//                "                \"riskLevelLabel\": \"QUALITY_RISK_LABEL\",\n" +
//                "                \"labelCodeDesc\": \"质量高风险\",\n" +
//                "                \"labelRuleDesc\": \"xxxxxxxxxxxx驼峰上配置的xxxxxx\",\n" +
//                "                \"ruleGuidance\": \"xxxxxxxxxxxx驼峰上配置的xxxxxx\"\n" +
//                "            }\n" +
//                "        ]\n" +
//                "    }\n" +
//                "}";
//
//        String jsonPath = "#qcStrategy#riskLevelDetail";
//        String res = ParamParseUtils.parseParam(inputParam, jsonPath);
//        String res2 = ParamParseUtils.parseParam(inputParam2, jsonPath);
////        System.out.println(res);
////        System.out.println(res2);
//
//
//        String temperatureInfoStr = "{\n" +
//                "    \"temperatureRegister\":1,\n" +
//                "    \"registerNumber\": 0,\n" +
//                "    \"qualifiedNumber\": 0,\n" +
//                "    \"unqualifiedNumber\": 0,\n" +
//                "    \"temperatureSkuInfoList\": [\n" +
//                "        {\n" +
//                "            \"cat2Id\": \"2000\",\n" +
//                "            \"cat3Id\": \"3000\",\n" +
//                "            \"cat4Id\": \"4001\",\n" +
//                "            \"cat2Name\": \"二级类目A\",\n" +
//                "            \"cat3Name\": \"三级类目A\",\n" +
//                "            \"cat4Name\": \"测试skuA\",\n" +
//                "            \"skuCode\": \"12345\",\n" +
//                "            \"skuName\": \"bt测试sku\",\n" +
//                "            \"temperature\": \"-10\",\n" +
//                "            \"temperaturePicValue\": \"一个图片的url\",\n" +
//                "            \"result\": \"2\",\n" +
//                "            \"registerMisId\": \"baitao05\",\n" +
//                "            \"registerMisName\": \"bt测试登记员\",\n" +
//                "            \"registerAccountType\": \"\",\n" +
//                "            \"registerTime\": \"2025-06-06 12:00:00\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"cat2Id\": \"2000\",\n" +
//                "            \"cat3Id\": \"3000\",\n" +
//                "            \"cat4Id\": \"4002\",\n" +
//                "            \"cat2Name\": \"二级类目A\",\n" +
//                "            \"cat3Name\": \"三级类目A\",\n" +
//                "            \"cat4Name\": \"测试skuB\",\n" +
//                "            \"skuCode\": \"12346\",\n" +
//                "            \"skuName\": \"bt测试skuB\",\n" +
//                "            \"temperature\": \"50\",\n" +
//                "            \"temperaturePicValue\": \"\",\n" +
//                "            \"result\": \"2\",\n" +
//                "            \"registerMisId\": \"\",\n" +
//                "            \"registerMisName\": \"bt测试登记员\",\n" +
//                "            \"registerAccountType\": \"\",\n" +
//                "            \"registerTime\": \"\"\n" +
//                "        }\n" +
//                "    ]\n" +
//                "}";
//        String str2 = ParamParseUtils.parseParam(null, "#registerSku");
//        TemperatureInfo temperatureInfo = GsonUtils.fromJsonObject(temperatureInfoStr, TemperatureInfo.class);
//        List<TemperatureSkuInfo> temperatureSkuInfoList = GsonUtils.fromJsonArray(null, TemperatureSkuInfo.class);
////        System.out.println(temperatureInfo);
//        System.out.println(temperatureSkuInfoList);
//
//        Map<String, String> map = new HashMap<>();
////        System.out.println(map.get(null));
//
//
//
//        List<TemperatureSkuInfo> list = new ArrayList<>();
//        for (int i = 1; i < 27; i ++ ) {
//            TemperatureSkuInfo info = new TemperatureSkuInfo();
//            char c = (char)('A' - 1 + i);
//            info.setCat2Id(2000 + i);
//            info.setCat3Id(3000 + i);
//            info.setCat4Id(4000 + i);
//            info.setCat2Name("二级类目" + c);
//            info.setCat2Name("三级类目" + c);
//            info.setCat2Name("四级类目" + c);
//            info.setSkuCode(12345000 + i);
//            info.setSkuName("bt测试sku-" + c);
//            info.setTemperature(String.valueOf(i));
//            info.setTemperaturePicValue("一个图片的url-" + c);
//            info.setResult(2);
//            info.setRegisterMisName("bt测试登记员" + i + "号");
//            info.setRegisterTime("2025-06-06 00:00:00");
//            list.add(info);
//        }
//        System.out.println(GsonUtils.toJson(list));

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime dateTime = LocalDateTime.parse("2025-06-13 10:55:08",formatter);
//        System.out.println(dateTime);

        List<String> timeList = new ArrayList<>();
        timeList.add("2025-07-07 12:00:00");
        String time = timeList.stream()
                .max((str1, str2) -> {
                    LocalDateTime time1 = LocalDateTime.parse(str1);
                    LocalDateTime time2 = LocalDateTime.parse(str2);
                    if (time1.isAfter(time2)) {
                        return 1;
                    } else if (time1.isBefore(time2)) {
                        return -1;
                    } else {
                        return 0;
                    }
                })
                .orElse(null);

        System.out.println(time);
    }
}


