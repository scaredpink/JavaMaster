import com.google.gson.*;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class GsonUtils {

    private static final String defaultDatePattern = "yyyy-MM-dd HH:mm:ss";

    private static final Gson gson = new GsonBuilder().create();

    private GsonUtils() {
    }

    public static String toJson(Object o) {
        return gson.toJson(o);
    }


    public static <T> T toObject(String json, Type type) {
        return gson.fromJson(json, type);
    }

    /**
     * 对象序列化为json字符串
     * @param object
     * @param datePattern Date类型需要转的格式，默认：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String toJson(Object object, String datePattern) {
        return new GsonBuilder()
                .setDateFormat(StringUtils.isNotEmpty(datePattern) ? datePattern : defaultDatePattern)
                .create()
                .toJson(object);
    }

    /**
     * json字符串转Map
     * @param json
     * @return
     */
    public static Map<String, Object> fromJsonMap(String json) {
        return new GsonBuilder()
                .registerTypeAdapter(new TypeToken<Map<String, Object>>() {
                }.getType(), new ObjectTypeAdapter())
                .create()
                .fromJson(json, new TypeToken<Map<String, Object>>() {
                }.getType());
    }

    /**
     * json字符串转Map
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> Map<String, T> fromJsonMap(String json, Class<T> clazz) {
        Type mapType = new ParameterizedTypeImpl(Map.class, new Class[]{String.class, clazz});
        return new Gson().fromJson(json, mapType);
    }

    /**
     * json字符串转Map
     * @param json
     */
    public static <T1,T2> Map<T1, List<T2>> fromJsonListMap(String json, Class<T1> clazz1, Class<T2> clazz2) {
        return new Gson().fromJson(json, new TypeToken<Map<T1,List<T2>>>(){}.getType());
    }

    /**
     * json字符串转Map
     * @param json
     */
    public static <T1,T2> Map<T1, T2> fromJsonMap(String json, Class<T1> clazz1, Class<T2> clazz2) {
        Type mapType = new ParameterizedTypeImpl(Map.class, new Class[]{clazz1,clazz2});
        return new Gson().fromJson(json, mapType);
    }

    /**
     * json字符串转List
     * @param json
     * @return
     */
    public static List<Object> fromJsonArray(String json) {
        return new GsonBuilder()
                .registerTypeAdapter(new TypeToken<List<Object>>() {
                }.getType(), new ObjectTypeAdapter())
                .create()
                .fromJson(json, new TypeToken<List<Object>>() {
                }.getType());
    }

    /**
     * json字符串转List
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> fromJsonArray(String json, Class<T> clazz) {
        Type listType = new ParameterizedTypeImpl(List.class, new Class[]{clazz});
        return new GsonBuilder()
                .registerTypeAdapter(Date.class, new GsonDateDeSerializer())
                .registerTypeAdapter(Date.class, new GsonDateSerializer())
                .create()
                .fromJson(json, listType);
    }

    /**
     * json字符串转对象
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T fromJsonObject(String json, Class<T> clazz) {
        Type type = new ParameterizedTypeImpl(clazz, null);
        return new GsonBuilder()
                .registerTypeAdapter(Date.class, new GsonDateDeSerializer())
                .registerTypeAdapter(Date.class, new GsonDateSerializer())
                .create()
                .fromJson(json, type);
    }

    private static class ParameterizedTypeImpl implements ParameterizedType {
        private Class clazz;
        private Type[] types;

        public ParameterizedTypeImpl(Class clazz, Type[] types) {
            this.clazz = clazz;
            this.types = types != null ? types : new Type[0];
        }

        @Override
        public Type[] getActualTypeArguments() {
            return this.types;
        }

        @Override
        public Type getRawType() {
            return this.clazz;
        }

        @Override
        public Type getOwnerType() {
            return null;
        }
    }

    private static class GsonDateDeSerializer implements JsonDeserializer<Date> {
        @Override
        public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            SimpleDateFormat simpleDateFormat19 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat simpleDateFormat16 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String dateStr = jsonElement.getAsJsonPrimitive().getAsString();
            try {
                long time = NumberUtils.toLong(dateStr, 0L);
                if (time != 0L) {
                    return new Date(time);
                } else {
                    if (dateStr.toUpperCase().contains("AM") || dateStr.toUpperCase().contains("PM")) {
                        return new Date(dateStr);
                    }
                    switch (dateStr.length()) {
                        case 19:
                            return simpleDateFormat19.parse(dateStr);
                        case 16:
                            return simpleDateFormat16.parse(dateStr);
                        default:
                            return null;
                    }
                }
            } catch (ParseException e) {
            }
            return null;
        }
    }

    private static class GsonDateSerializer implements JsonSerializer<Date> {
        @Override
        public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
            return new JsonPrimitive(date.getTime());
        }
    }

    private static class ObjectTypeAdapter extends TypeAdapter<Object> {
        @Override
        public void write(JsonWriter jsonWriter, Object o) throws IOException {

        }

        @Override
        public Object read(JsonReader jsonReader) throws IOException {
            JsonToken token = jsonReader.peek();
            switch (token) {
                case BEGIN_ARRAY:
                    List<Object> list = new ArrayList<>();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        list.add(read(jsonReader));
                    }
                    jsonReader.endArray();
                    return list;

                case BEGIN_OBJECT:
                    Map<String, Object> map = new LinkedTreeMap<>();
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        map.put(jsonReader.nextName(), read(jsonReader));
                    }
                    jsonReader.endObject();
                    return map;

                case STRING:
                    return jsonReader.nextString();

                case NUMBER:
                    String dbNumStr = jsonReader.nextString();
                    if (dbNumStr.contains(".") || dbNumStr.contains("e") || dbNumStr.contains("E")) {
                        return NumberUtils.toDouble(dbNumStr);
                    }
                    return NumberUtils.toLong(dbNumStr);

                case BOOLEAN:
                    return jsonReader.nextBoolean();

                case NULL:
                    jsonReader.nextNull();
                    return null;

                default:
                    throw new IllegalStateException();
            }
        }
    }
}
