package structure.analyze.configuration;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;
import java.util.stream.Stream;

public class ConfigurationReaderTest {

    ConfigurationReader testReader = new ConfigurationReader();

    public final static String PATH = "C:/Utveckling/git/structure-maven-plugin/src/test/resources";
    public final static String FILE_NAME = "utilrules.structure";


    @Test
    public void readUtilRulesShouldGenerateOneWarning() throws IOException {
        Configuration configuration = testReader.readConfigFileForOneFile(FILE_NAME, PATH);
        Stream<String> rules = configuration.getRules(FILE_NAME);
        rules.forEach(System.out::println);
    }

}