package structure.analyze.predicates;

import java.util.function.Predicate;

/**
 * Created by molas on 2015-02-17.
 */
public class StringPredicate {

    private final static String IMPORT = "import ";
    private final static String PACKAGE = "package ";

    public static Predicate<String> containsImport() {
        return s -> s.contains(IMPORT);
    }

    public static Predicate<String> containsPackage() {
        return s -> s.contains(PACKAGE);
    }
}