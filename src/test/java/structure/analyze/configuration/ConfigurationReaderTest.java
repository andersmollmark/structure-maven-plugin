package structure.analyze.configuration;

import junit.framework.TestCase;

import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class ConfigurationReaderTest {

    ConfigurationReader testReader = new ConfigurationReader();

    @Test
    public void readUtilRulesShouldGenerateOneWarning() throws IOException {
        Configuration configuration = testReader.readConfigFileForOneFile(ConfigurationReader.FILE_NAME, ConfigurationReader.PATH);
        Map<String, List<String>> allRulesPerFile = configuration.getAllRulesPerFile();

        assertThat(allRulesPerFile.size(), is(1));
        assertThat(allRulesPerFile.values().size(), is(2));

        allRulesPerFile.forEach((k, v) ->  {
            System.out.println(k);
            v.forEach(s -> System.out.println("\t" + s));
        });
    }

}