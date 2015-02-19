package structure.analyze;

import structure.analyze.configuration.Configuration;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static structure.analyze.functionalInterface.StringFunction.*;
import static structure.analyze.predicates.StringPredicate.containsImport;
import static structure.analyze.predicates.StringPredicate.containsPackage;


/**
 * Created by molas on 2015-02-12.
 */
public class StructureAnalyzer {

    public final static String PATH_UTIL = "C:/Utveckling/git/structure-maven-plugin/src/test/java/testpackages/util";
    public final static String FILE_DATUM_UTIL = "DatumUtil.java";
    private final static String PACKAGE = "package";
    private final static String IMPORT = "import ";

    public List<String> getAnalyzedResultAF1(String filename, String path) throws IOException {
        FileReader theReader = new FileReader(path, filename);

        Optional<String> packagename = theReader.readFile()
                .filter(containsPackage())
                .map(getPackagerow())
                .findFirst();

        List<String> warnings = theReader.readFile()
                .filter(containsImport())
                .map(getImportrow())
                .distinct()
                .map(createWarning(packagename.orElse("paket saknas")))
                .collect(toList());
        return warnings;
    }

    public List<String> getAnalyzedResultAF2(String filename, String path, Configuration confRules) throws IOException {
        FileReader theReader = new FileReader(path, filename);

        Optional<String> packagename = theReader.readFile()
                .filter(containsPackage())
                .map(getPackagerow())
                .findFirst();

        List<String> rules = confRules.getRules(filename);

        List<String> warnings = theReader.readFile()
                .filter(containsImport())
                .map(getImportrow())
                .filter(s -> !rules.contains(s))
                .distinct()
                .map(createWarning(packagename.orElse("paket saknas")))
                .collect(toList());
        return warnings;
    }

//    public List<String> getAnalyzedResultAF1WithJustOneStream(String filename, String path) throws IOException {
//        FileReader theReader = new FileReader(path, filename);
//
//        Map<Boolean, List<String>> packageRowAndImports = theReader.readFile()
//                .filter(containsImportOrPackage())
//                .collect(partitioningBy(containsImport()));


//        theReader.readFile()
//                .filter(row -> containsImportOrPackage())
//                .collect(partitioningBy(containsImport()))
//                .forEach((isImportRow, rows) -> {
//                    if(isImportRow){
//
//                    }
//                });

//        List<String> warnings = theReader.readFile()
//                .filter(containsImport())
//                .map(getImportrow())
//                .distinct()
//                .map(createWarning(packagename.orElse("paket saknas")))
//                .collect(toList());
//        return warnings;
//    }


}
