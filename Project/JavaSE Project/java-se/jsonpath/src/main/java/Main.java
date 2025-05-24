import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

/**
 * @author baitao05
 */
public class Main {
    private static Configuration jsonPathConfiguration = Configuration.defaultConfiguration();
    public static void main(String[] args) {


        String inputParam = "{\n" +
                "    \"qcNo\": \"12345\",\n" +
                "    \"qcStrategy\": {\n" +
                "        \"other\": \"123\",\n" +
                "        \"riskLevelDetail\": \"[{\\\"labelType\\\":\\\"1\\\",\\\"riskLevel\\\":\\\"20\\\",\\\"riskLevelLabel\\\":\\\"BEFORE_HIGH_RISK_LEVEL_SKU\\\",\\\"labelCodeDesc\\\":\\\"前置风险\\\",\\\"labelRuleDesc\\\":\\\"\\\",\\\"ruleGuidance\\\":\\\"\\\"},{\\\"labelType\\\":\\\"2\\\",\\\"riskLevel\\\":\\\"20\\\",\\\"riskLevelLabel\\\":\\\"MANUAL_HIGH_RISK_LEVEL_SKU\\\",\\\"labelCodeDesc\\\":\\\"手动高风险\\\",\\\"labelRuleDesc\\\":\\\"\\\",\\\"ruleGuidance\\\":\\\"\\\"},{\\\"labelType\\\":\\\"3\\\",\\\"riskLevel\\\":\\\"20\\\",\\\"riskLevelLabel\\\":\\\"QUALITY_RISK_LABEL\\\",\\\"labelCodeDesc\\\":\\\"质量高风险\\\",\\\"labelRuleDesc\\\":\\\"xxxxxxxxxxxx驼峰上配置的xxxxxx\\\",\\\"ruleGuidance\\\":\\\"xxxxxxxxxxxx驼峰上配置的xxxxxx\\\"}]\"\n" +
                "    }\n" +
                "}";

        String inputParam2 = "{\n" +
                "    \"qcNo\": \"12345\",\n" +
                "    \"qcStrategy\": {\n" +
                "        \"other\": \"123\",\n" +
                "        \"riskLevelDetail\": [\n" +
                "            {\n" +
                "                \"labelType\": \"1\",\n" +
                "                \"riskLevel\": \"20\",\n" +
                "                \"riskLevelLabel\": \"BEFORE_HIGH_RISK_LEVEL_SKU\",\n" +
                "                \"labelCodeDesc\": \"前置风险\",\n" +
                "                \"labelRuleDesc\": \"\",\n" +
                "                \"ruleGuidance\": \"\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"labelType\": \"2\",\n" +
                "                \"riskLevel\": \"20\",\n" +
                "                \"riskLevelLabel\": \"MANUAL_HIGH_RISK_LEVEL_SKU\",\n" +
                "                \"labelCodeDesc\": \"手动高风险\",\n" +
                "                \"labelRuleDesc\": \"\",\n" +
                "                \"ruleGuidance\": \"\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"labelType\": \"3\",\n" +
                "                \"riskLevel\": \"20\",\n" +
                "                \"riskLevelLabel\": \"QUALITY_RISK_LABEL\",\n" +
                "                \"labelCodeDesc\": \"质量高风险\",\n" +
                "                \"labelRuleDesc\": \"xxxxxxxxxxxx驼峰上配置的xxxxxx\",\n" +
                "                \"ruleGuidance\": \"xxxxxxxxxxxx驼峰上配置的xxxxxx\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";

        String jsonPath = "#qcStrategy#riskLevelDetail";
        String res = ParamParseUtils.parseParam(inputParam, jsonPath);
        String res2 = ParamParseUtils.parseParam(inputParam2, jsonPath);
        System.out.println(res);
        System.out.println(res2);

    }
}


