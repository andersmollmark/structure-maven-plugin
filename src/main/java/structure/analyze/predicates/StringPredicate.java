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
        return s -> s.contains(IMPORT);
    }

    public static Predicate<String> containsPackage() {
        return s -> s.contains(PACKAGE);
    }

    public static Predicate<String> isFileNameInConfFile(){ return s -> s.startsWith(DOUBLESTAR);}

    public static Predicate<String> isRuleInConfFile(){ return s -> !s.startsWith(DOUBLESTAR);}
}
