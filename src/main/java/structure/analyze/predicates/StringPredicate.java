package structure.analyze.predicates;

import java.util.function.Predicate;

/**
 * Created by molas on 2015-02-17.
 */
public class StringPredicate {

    private final static String IMPORT = "import ";
    private final static String PACKAGE = "package ";
    private final static String DOUBLESTAR = "**";

    public static Predicate<String> containsImport() {
        return s -> isImportRow(s);
    }

    public static Predicate<String> containsPackage() {
        return s -> isPackageRow(s);
    }

    public static Predicate<String> isFileNameInConfFile(){ return s -> s.startsWith(DOUBLESTAR);}

    public static Predicate<String> isAnAllowedReference(){ return s -> !s.startsWith(DOUBLESTAR);}

    public static Predicate<String> containsImportOrPackage(){return s -> isImportRow(s) || isPackageRow(s);}

    private static boolean isImportRow(String s){
        return s.contains(IMPORT);
    }

    private static boolean isPackageRow(String s){
        return s.contains(PACKAGE);
    }

}
