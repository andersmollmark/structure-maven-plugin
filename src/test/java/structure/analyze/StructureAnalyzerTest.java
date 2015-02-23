package structure.analyze;

import org.junit.Test;
import structure.analyze.configuration.Configuration;
import structure.analyze.configuration.ConfigurationReader;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by molas on 2015-02-13.
 */
public class StructureAnalyzerTest {

    StructureAnalyzer analyzer = new StructureAnalyzer();

    private static final String IMPORT = "import ";

    @Test
    public void readUtilFileAndWarnForImportsShouldReturn4Warnings() throws IOException {
        List<String> warnings = analyzer.getAnalyzedResultAF1(StructureAnalyzer.FILE_DATUM_UTIL, StructureAnalyzer.PATH_UTIL);
        assertThat(warnings.size(), is(5));
        warnings.forEach(System.out::println);
    }

    @Test
    public void readUtilFileAndWarnForImportsAndUseRulesFileShouldReturn2Warnings() throws IOException {
        Configuration configuration = new ConfigurationReader().readConfigFileForOneFile(ConfigurationReader.RULES_FILE_ONE_FILE, ConfigurationReader.PATH_RULES);
        List<String> warnings = analyzer.getAnalyzedResultAF2(StructureAnalyzer.FILE_DATUM_UTIL, StructureAnalyzer.PATH_UTIL, configuration);
        warnings.forEach(System.out::println);
        assertThat(warnings.size(), is(3));

    }

    @Test
    public void readRulesFileForCatalog() throws IOException {
        Configuration configuration = new ConfigurationReader().readConfigFileForOneFile(ConfigurationReader.RULES_FILE_ONE_CATALOG, ConfigurationReader.PATH_RULES);
        List<String> warnings = analyzer.getAnalyzedResultAF4(StructureAnalyzer.PATH_CATALOG, configuration);
    }

}
