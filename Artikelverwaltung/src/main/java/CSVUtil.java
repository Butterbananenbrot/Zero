import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVUtil {
    public static List<CountryEmission> loadEmissions() {
        List<CountryEmission> emissionsList = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("resources/emissions.csv"))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 2) {
                    emissionsList.add(new CountryEmission(values[0], Double.parseDouble(values[1])));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emissionsList;
    }
}
