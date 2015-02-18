package structure.analyze.functionalInterface;

import java.util.function.Function;

/**
 * Created by molas on 2015-02-18.
 */
public class StringFunction {

    private static final String IMPORT = "import ";
    private static final String PACKAGE = "package ";

    final static String WARNING = "Varning, klasser i paketet %s får inte referera till klasser i %s";

    public static Function<String, String> getImportrow(){
        return anImportRow -> anImportRow.substring(IMPORT.length(), anImportRow.lastIndexOf("."));
    }

    public static Function<String, String> getPackagerow(){
        return aRow -> aRow.substring(PACKAGE.length(), aRow.lastIndexOf(";"));
    }


    public static Function<String, String> createWarning(String packagename){
        return aUniqueImport -> String.format(WARNING, packagename, aUniqueImport);
    }
}
