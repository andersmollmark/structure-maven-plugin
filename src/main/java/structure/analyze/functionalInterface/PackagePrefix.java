package structure.analyze.functionalInterface;

/**
 * Created by molas on 2015-02-13.
 */
public class PackagePrefix implements PrefixType {

    @Override
    public String getPrefix() {
        return "package ";
    }
}
