package structure.analyze;

import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by molas on 2015-02-12.
 */
public class FileReader {


    public Stream<String> readFile(String path, String filename) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(path, filename));
        return lines;
    }

    public Stream<Path> readPath(String path) throws IOException {
        Path catalogPath = FileSystems.getDefault().getPath(path);
//        Stream<Path> catalogStream = Files.walk(Paths.get(path), 1);
        Stream<Path> catalogStream = Files.walk(catalogPath, 1);
        return catalogStream;

    }
}
