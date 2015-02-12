package structure;

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

    public void analyze() throws IOException {
        FileReader theReader = new FileReader(path, filename);
        List<String> rowsWithImport =
            theReader.readFile().
                    filter(enRad -> enRad.contains("import")).
                    collect(toList());

        rowsWithImport.forEach(s -> System.out.println("En rad:" + s));
    }

    public static void main(String[] args) throws IOException {

        new StructureAnalyzer().analyze();
    }
}
