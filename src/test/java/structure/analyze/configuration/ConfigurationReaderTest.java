package structure.analyze.configuration;

import org.junit.Test;

import java.io.IOException;
import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class ConfigurationReaderTest {

    ConfigurationReader testReader = new ConfigurationReader();

    @Test
    public void readUtilRulesShouldGenerateOneWarning() throws IOException {
        Configuration configuration = testReader.readConfigFileForOneFile(ConfigurationReader.RULES_FILE_ONE_FILE, ConfigurationReader.PATH_RULES);
        Map<String, List<String>> allRulesPerFile = configuration.getAllRulesPerFile();


        allRulesPerFile.forEach((k, v) ->  {
            System.out.println(k);
            v.forEach(s -> System.out.println("\t" + s));
        });

        assertThat(allRulesPerFile.size(), is(1));
        Set<String> filenameInConffile = allRulesPerFile.keySet();
        assertThat(filenameInConffile.size(), is(1));
        String filename = (String)filenameInConffile.toArray()[0];
        List<String> rulesForFile = allRulesPerFile.get(filename);
        assertThat(rulesForFile.size(), is(2));
    }

    @Test
    public void readRulesForCatalog() throws IOException {
        Configuration configuration = testReader.readConfigForOneCatalog(ConfigurationReader.RULES_FILE_ONE_CATALOG, ConfigurationReader.PATH_RULES);
        Map<String, List<String>> allRulesPerFile = configuration.getAllRulesPerFile();


        allRulesPerFile.forEach((k, v) ->  {
            System.out.println(k);
            v.forEach(s -> System.out.println("\t" + s));
        });

        assertThat(allRulesPerFile.size(), is(1));
        Set<String> filenameInConffile = allRulesPerFile.keySet();
        assertThat(filenameInConffile.size(), is(1));
        String filename = (String)filenameInConffile.toArray()[0];
        List<String> rulesForFile = allRulesPerFile.get(filename);
        assertThat(rulesForFile.size(), is(3));
    }

}