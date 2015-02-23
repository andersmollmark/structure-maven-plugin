package structure.analyze;

import org.junit.Test;
import structure.analyze.configuration.Configuration;
import structure.analyze.configuration.ConfigurationReader;

import java.util.stream.Stream;

public class FileReaderTest {

    FileReader reader = new FileReader();

    @Test
    public void testReadPath() throws Exception {
        Stream<String> rulesForCatalog = reader.readFile(ConfigurationReader.PATH_RULES, ConfigurationReader.RULES_FILE_ONE_CATALOG);
        rulesForCatalog.forEach(System.out::println);
    }
}