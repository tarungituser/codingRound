package utilities;

import com.opencsv.CSVReader;
import org.testng.annotations.DataProvider;
import org.testng.log4testng.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Class to give Generic dataprovider. <br>
 * Returns 2D array for input to Test class<br>
 * use the following parameters in your test class:
 * </p>
 *
 * <pre>
 * testname(int rowNo, Map&lt;String, String&gt; inputDataMap)
 * </pre>
 */
public class GenericDataProvider {

    private static final Logger LOGGER = Logger.getLogger(GenericDataProvider.class);


    /**
     * This method serves as test data provider
     * @param testMethod
     * @return - test data
     */
    @DataProvider(name = "dataproviderForTestCase")
    public Object[][] sampleDataProvider(final Method testMethod) {
        Object[][] finalObject = null; // this would be returned
        Map<Integer, Map<String, String>> outerMap = new HashMap<Integer, Map<String, String>>();
        Map<String, String> innerMap;

        CSVAnnotation.CSVFileParameters parameters = testMethod.getAnnotation(CSVAnnotation.CSVFileParameters.class);
        if (parameters != null) {
            String path = parameters.path();
            String delimiter = parameters.delimiter();
            String[][] csvArray = loadDataFromCSVFile(path);
            if (csvArray != null && csvArray.length > 0) {
                int length = csvArray[0][0].split(delimiter).length;
                for (int j = 0; j < csvArray.length; j++) {
                    innerMap = new HashMap<String, String>();
                    String[] key = csvArray[j][0].split(delimiter);
                    String[] value = csvArray[j][1].split(delimiter);
                    for (int k = 0; k < length; k++) {
                        innerMap.put(key[k], value[k]);
                    }
                    outerMap.put(j, innerMap);
                }

                finalObject = new Object[outerMap.size()][outerMap.size()];
                for (int count = 0; count < outerMap.size(); count++) {
                    finalObject[count] = new Object[]{count, outerMap.get(count)};
                }
            }
        }
        return finalObject;
    }

    /**
     * @param path path of the file to read
     * @return 2d string array
     */
    private static String[][] loadDataFromCSVFile(final String path) {
        CSVReader reader = null;
        String[][] returnArray = null;
        final char separator = ((char) 007);
        try (FileReader fr = new FileReader(path)) {
            reader = new CSVReader(fr, separator, '\'');
            List<String[]> csvList = reader.readAll();
            if (!csvList.isEmpty()) {
                returnArray = new String[csvList.size() - 1][csvList.size() - 1];
                int iterator = 0;
                for (int count = 1; count < csvList.size(); count++) {
                    returnArray[iterator] = new String[]{csvList.get(0)[0], csvList.get(count)[0]};
                    iterator++;
                }
                reader.close();
            }
        } catch (IOException ex) {
            LOGGER.error("IO Exception while reading CSV.." + ex.toString());
        } catch (Exception ex) {
            LOGGER.error(ex.toString());
        }
        return returnArray;
    }
}
