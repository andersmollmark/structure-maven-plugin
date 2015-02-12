package structure;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by molas on 2015-02-12.
 */
public class FileReader {

    private String pathS;
    private Path path;

    public FileReader(String path, String filename){
        this.pathS = path;
        this.path = Paths.get(pathS, filename);
    }

    public Stream<String> readFile() throws IOException {
        Stream<String> lines = Files.lines(path);
        return lines;
    }
}
