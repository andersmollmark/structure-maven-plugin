package structure.analyze;

import structure.analyze.configuration.Configuration;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static structure.analyze.functionalInterface.StringFunction.*;
import static structure.analyze.predicates.StringPredicate.containsImport;
import static structure.analyze.predicates.StringPredicate.containsPackage;


/**
 * Created by molas on 2015-02-12.
 */
public class StructureAnalyzer {

    public final static String PATH_UTIL = "C:/Utveckling/git/structure-maven-plugin/src/test/java/testpackages/util";
//    public final static String PATH_CATALOG = "C:/Utveckling/git/elin/src/main/java/se/arbetsformedlingen/elin/common/entity";
    public final static String PATH_CATALOG = "C:/Utveckling/git/elin/ejb/src/main/java/se/arbetsformedlingen/elin/common/entity";
    public final static String COMMON_ENTITY_FILE = "Akt.java";

    public final static String FILE_DATUM_UTIL = "DatumUtil.java";
    private final static String PACKAGE = "package";
    private final static String IMPORT = "import ";

    FileReader theReader;

    public List<String> getAnalyzedResultAF1(String filename, String path) throws IOException {
        FileReader theReader = new FileReader();

        Optional<String> packagename = theReader.readFile(path, filename)
                .filter(containsPackage())
                .map(getPackagerow())
                .findFirst();

        List<String> warnings = theReader.readFile(path, filename)
                .filter(containsImport())
                .map(getImportrow())
                .distinct()
                .map(createWarning(packagename.orElse("paket saknas")))
                .collect(toList());
        return warnings;
    }

    public List<String> getAnalyzedResultAF2(String sourceFile, String path, Configuration confRules) throws IOException {
        List<String> rules = confRules.getRules(sourceFile);
        List<String> warnings = readOneSourceFileAndReturnWarnings(path, sourceFile, rules);
        return warnings;
    }

    public List<String> getAnalyzedResultAF4(String path, Configuration confRules) throws IOException {
        theReader = new FileReader();

        Stream<Path> pathStream = theReader.readPath(path);
//        pathStream.forEach(readOneSourceFileAndReturnWarnings(PATH_CATALOG, ));

        Map<String, List<String>> allRulesPerFile = confRules.getAllRulesPerFile();

        return null;
    }

    private List<String> readOneSourceFileAndReturnWarnings(String path, String sourceFile, List<String> rulesForSourceFile) throws IOException {
        theReader = new FileReader();
        Optional<String> packagename = theReader.readFile(path, sourceFile)
                .filter(containsPackage())
                .map(getPackagerow())
                .findFirst();

        List<String> warnings = theReader.readFile(path, sourceFile)
                .filter(containsImport())
                .map(getImportrow())
                .filter(s -> !rulesForSourceFile.contains(s))
                .distinct()
                .map(createWarning(packagename.orElse("paket saknas")))
                .collect(toList());
        return warnings;

    }



}
