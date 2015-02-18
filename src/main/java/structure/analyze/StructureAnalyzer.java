package structure.analyze;

import structure.analyze.predicates.StringPredicate;

import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by molas on 2015-02-12.
 */
public class StructureAnalyzer {

    public final static String PATH_UTIL = "C:/Utveckling/git/structure-maven-plugin/src/test/java/testpackages/util";
    public final static String FILE_DATUM_UTIL = "DatumUtil.java";
    private final static String PACKAGE = "package";
    private final static String IMPORT = "import ";

    public FileAnalyzeResult getRowsWithPrefix(String prefixOfRow) throws IOException {
        FileReader theReader = new FileReader(PATH_UTIL, FILE_DATUM_UTIL);
        FileAnalyzeResult result = new FileAnalyzeResult();
        List<String> rowsWithPrefix =
            theReader.readFile().
                    filter(enRad -> {
                        System.out.println("En rad:" + enRad);
                        if(enRad.startsWith(PACKAGE)){
                            result.setPackageRow(enRad);
                        }
                        return enRad.startsWith(prefixOfRow);
                    }).
                    collect(toList());
        result.setImportRows(rowsWithPrefix);
        return result;
    }

    public List<String> getAnalyzedResultAF1(String filename, String path) throws IOException {
        FileReader theReader = new FileReader(path, filename);
        final String WARNING = "Varning, klasser i util-paketet får bara referera till samma paket: ";

        List<String> warnings = theReader.readFile().
                        filter(new StringPredicate().containsImport()).
                                map(aImportRow -> {
                                    int indexOfLastDot = aImportRow.lastIndexOf(".");
                                    return aImportRow.substring(0, indexOfLastDot);
                                }).
                                distinct().
                                map(aUniqueImport -> {
                                    return WARNING + aUniqueImport;
                                }).
                                collect(toList());
        return warnings;
    }

}
