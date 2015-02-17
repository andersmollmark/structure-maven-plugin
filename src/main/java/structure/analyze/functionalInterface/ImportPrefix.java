package structure.analyze.functionalInterface;

/**
 * Created by molas on 2015-02-13.
 */
public class ImportPrefix implements PrefixType {

    @Override
    public String getPrefix() {
        return "import ";
    }
}
