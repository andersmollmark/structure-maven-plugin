package structure.analyze.functionalInterface;

import java.util.stream.Stream;

/**
 * Created by molas on 2015-02-13.
 */
public class PackageFilter implements RowFilter {

    PrefixType myPrefix = new PackagePrefix();

    @Override
    public Stream<String> filterRowsWithPrefix(Stream<String> fileWithRows) {
        return fileWithRows.filter(row -> {
            System.out.println("row in PackageFilter:" + row);
            return row.startsWith(myPrefix.getPrefix());
        });
    }

}
