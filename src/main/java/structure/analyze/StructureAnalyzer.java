package structure.analyze;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

/**
 * Created by molas on 2015-02-12.
 */
public class StructureAnalyzer {

    String path = "C:/Utveckling/git/structure-maven-plugin/src/test/java/testpackages/util";
    String filename = "DatumUtil.java";

    public List<String> analyzeGetRowsWithPrefix(String prefix) throws IOException {
        FileReader theReader = new FileReader(path, filename);
        List<String> rowsWithPrefix =
            theReader.readFile().
                    filter(enRad -> enRad.startsWith(prefix)).
                    collect(toList());

        rowsWithPrefix.forEach(s -> System.out.println("En rad:" + s));
        return rowsWithPrefix;
    }

    public static void main(String[] args) throws IOException {

        new StructureAnalyzer().analyzeGetRowsWithPrefix("import ");
    }
}
