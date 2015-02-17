package structure.analyze.functionalInterface;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by molas on 2015-02-13.
 */
@FunctionalInterface
public interface RowFilter {

    public Stream<String> filterRowsWithPrefix(Stream<String> fileWithRows);
}
