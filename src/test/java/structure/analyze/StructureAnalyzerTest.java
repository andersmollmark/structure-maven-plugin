package structure.analyze;

import org.junit.Test;

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
    public void readUtilFileWithImports() throws IOException {
        FileAnalyzeResult result = analyzer.getRowsWithPrefix(IMPORT);
        assertThat(result.getImportRows().size(), is(3));

        result.getImportRows().forEach(s -> System.out.println("En importrad:" + s));
    }

    @Test
    public void readUtilFileAndWarnForImports() throws IOException {
        List<String> warnings = analyzer.getAnalyzedResultAF1(StructureAnalyzer.FILE_DATUM_UTIL, StructureAnalyzer.PATH_UTIL);
        assertThat(warnings.size(), is(3));
        warnings.forEach(System.out::println);
    }
}
