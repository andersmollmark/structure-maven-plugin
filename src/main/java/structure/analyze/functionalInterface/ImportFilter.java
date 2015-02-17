package structure.analyze.functionalInterface;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by molas on 2015-02-13.
 */
public class ImportFilter implements RowFilter {

    PrefixType myPrefix = new ImportPrefix();

    @Override
    public Stream<String> filterRowsWithPrefix(Stream<String> fileWithRows) {
        return fileWithRows.filter(row -> {
            System.out.println("row in ImportFilter:" + row);
            return row.startsWith(myPrefix.getPrefix());
        });
    }

}
