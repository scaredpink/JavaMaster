import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

public class ParamParseUtils {

    //jsonPath
    private static Configuration jsonPathConfiguration = Configuration.defaultConfiguration();

    /**
     * 参数解析构建
     *
     * @param inputParam
     * @return
     */
    public static String parseParam(String inputParam, String jsonPath) {
//        inputParam = StringEscapeUtils.unescapeJava(inputParam);
//        log.debug("parseParam-before:{},jsonPath:{}", GsonUtils.toJson(inputParam), jsonPath);
        try {
            if(StringUtils.isBlank(inputParam) || StringUtils.isBlank(jsonPath)){
                return "";
            }
            String[] splitJsonPaths = jsonPath.split("#");
            try{
                List<String> jsonPathList = Arrays.stream(splitJsonPaths).filter(path -> StringUtils.isNotBlank(path)).collect(Collectors.toList());
                if(jsonPathList.size() == 1){
                    Object object = JsonPath.using(jsonPathConfiguration).parse(inputParam).read(jsonPath.replace("#", "$."));
                    if(object == null){
                        return "";
                    }
                    return String.valueOf(object);
                }else if(jsonPathList.size() == 2){
                    Object object = JsonPath.using(jsonPathConfiguration).parse(inputParam).read("$." + jsonPathList.get(0));
                    if(object == null){
                        return "";
                    }
                    Map<String, Object> jsonMap = GsonUtils.fromJsonMap(String.valueOf(object), Object.class);
//                    log.debug("jsonPath1:{}, jsonMap:{}", "$." + jsonPathList.get(1), GsonUtils.toJson(jsonMap));
                    Object secondObject = JsonPath.using(jsonPathConfiguration).parse(GsonUtils.toJson(jsonMap)).read( "$." + jsonPathList.get(1));
                    if(secondObject == null){
                        return "";
                    }
                    return String.valueOf(secondObject);
                }else{
                    return inputParam;
                }
            }catch (PathNotFoundException e){
                return "";
            }
        }catch (Exception e){
//            log.warn("解析路径不存在，无须解析，直接返回空字符串，inputParam:{}, jsonPath:{}", inputParam, jsonPath, e);
            return "";
        }
    }


    /**
     * 参数解析构建
     *
     * @param inputParam
     * @return
     */
    public static String parseParamV3(String inputParam, String jsonPath) {
//        inputParam = StringEscapeUtils.unescapeJava(inputParam);
//        log.debug("parseParam-before:{},jsonPath:{}", GsonUtils.toJson(inputParam), jsonPath);
        try {
            if(StringUtils.isBlank(inputParam) || StringUtils.isBlank(jsonPath)){
                return "";
            }
            String[] splitJsonPaths = jsonPath.split("#");
            List<String> jsonPathList = Arrays.stream(splitJsonPaths).filter(path -> StringUtils.isNotBlank(path)).collect(Collectors.toList());
            if(CollectionUtils.isEmpty(jsonPathList)){
                return inputParam;
            }
            try{
                Map<String, Object> jsonMap = GsonUtils.fromJsonMap(inputParam, Object.class);
                for (int i = 0; i < jsonPathList.size(); i++) {
                    Object object = JsonPath.using(jsonPathConfiguration).parse(GsonUtils.toJson(jsonMap)).read("$." + jsonPathList.get(i));
                    if(object == null){
                        return "";
                    }
                    if(i == jsonPathList.size() -1){
                        return String.valueOf(object);
                    }
                    if(object instanceof String){
                        jsonMap = GsonUtils.fromJsonMap(String.valueOf(object), Object.class);
                    }else{
                        jsonMap = GsonUtils.fromJsonMap(GsonUtils.toJson(object), Object.class);
                    }
                }
            }catch (PathNotFoundException e){
                return "";
            }
        }catch (Exception e){
//            log.warn("解析路径不存在，无须解析，直接返回空字符串，inputParam:{}, jsonPath:{}", inputParam, jsonPath, e);
            return "";
        }
        return "";
    }

    /**
     * JsonPath解析,可支持多层（>=2）路径解析
     * @param inputParam
     * @param jsonPath
     * @return
     */
    public static String parseParamDSL(String inputParam,String jsonPath){
        if(StringUtils.isBlank(inputParam) || StringUtils.isBlank(jsonPath)){
            return "";
        }
        String[] splitJsonPaths = jsonPath.split("#");
        List<String> jsonPathList = Arrays.stream(splitJsonPaths).filter(StringUtils::isNotBlank).collect(Collectors.toList());
        for(int i = 0;i < jsonPathList.size();i++){
//            log.debug("第{}层解析:parseParam-before:{},jsonPath:{}",i+1, GsonUtils.toJson(inputParam), jsonPath);
            if(i == jsonPathList.size() - 1){
                inputParam = parseParamCommon(inputParam,jsonPathList.get(i),true);
            }
            else{
                inputParam = parseParamCommon(inputParam, jsonPathList.get(i),false);
            }
            if(StringUtils.isBlank(inputParam)){
                break;
            }
        }
        return inputParam;
    }

    /**
     * 逐层JsonPath解析
     * @param inputParam
     * @param jsonPath
     * @return
     */
    public static String parseParamCommon(String inputParam,String jsonPath,Boolean flag){
        try {
            if(StringUtils.isBlank(inputParam) || StringUtils.isBlank(jsonPath)){
                return "";
            }
            Object object = JsonPath.using(jsonPathConfiguration).parse(inputParam).read("$." + jsonPath);
            if(object == null){
                return "";
            }
            if(flag){
                return String.valueOf(object);
            }
            return GsonUtils.toJson(GsonUtils.fromJsonMap(GsonUtils.toJson(object),Object.class));
        } catch (PathNotFoundException e){
//            log.warn("解析路径不存在，无须解析，直接返回空字符串，inputParam:{}, jsonPath:{}", inputParam, jsonPath, e);
            return "";
        } catch (Exception e){
//            log.warn("解析路径不存在，无须解析，直接返回空字符串，inputParam:{}, jsonPath:{}", inputParam, jsonPath, e);
            return "";
        }
    }
}
