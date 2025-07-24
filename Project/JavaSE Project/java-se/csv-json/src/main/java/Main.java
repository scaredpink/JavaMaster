import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // 读取CSV文件
        String csvFilePath = "/Users/baitao/Downloads/cat-lengdongbanchengpin.csv";


        // 或读取为对象列表
        List<TemperatureCat4Config> csvData = readCsvToObjects(csvFilePath);
        System.out.println("读取到 " + csvData.size() + " 条记录");
        System.out.println(GsonUtils.toJson(csvData));
    }

    public static List<TemperatureCat4Config> readCsvToObjects(String filePath) {
        List<TemperatureCat4Config> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // 跳过表头
                    continue;
                }

                String[] values = line.split(",");
                if (values.length >= 0) { // 确保有足够的列
                    TemperatureCat4Config config = new TemperatureCat4Config();
                    config.setCat4Id(Integer.parseInt(values[0].trim()));
                    config.setCat4Name(values[1].trim());
                    config.setMaxTemperature(new BigDecimal(values[2].trim()));
                    config.setMinTemperature(new BigDecimal(values[3].trim()));
                    list.add(config);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return list;
    }
}