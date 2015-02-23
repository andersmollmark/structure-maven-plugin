package structure.analyze.configuration;

import structure.analyze.FileReader;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import static structure.analyze.predicates.StringPredicate.isFileNameInConfFile;
import static structure.analyze.predicates.StringPredicate.isAnAllowedReference;

/**
 * Created by molas on 2015-02-18.
 */
public class ConfigurationReader {

    public final static String PATH_RULES = "C:/Utveckling/git/structure-maven-plugin/src/test/resources";
    public final static String RULES_FILE_ONE_FILE = "utilrules.structure";
    public final static String RULES_FILE_ONE_CATALOG = "commonEntityRules.structure";

    private static final String MANDATORY_FILENAME_CHARS = "**.java";
    private static final String DOUBLESTAR = "**";


    public Configuration readConfigFileForOneFile(String configFile, String path) throws IOException {
        FileReader theReader = new FileReader();

        Optional<String> ruleFile = theReader.readFile(path, configFile)
                .filter(isFileNameInConfFile())
                .findFirst();

        if(!ruleFile.isPresent()){
            throw new IllegalStateException("Configurationfile is not correct. Must have a row like this: '**AJavaFile.java'");
        }

        List<String> allowedReferences = theReader.readFile(path, configFile)
                .filter(isAnAllowedReference())
                .collect(Collectors.toList());

        Configuration conf = new Configuration();
        conf.addRules(stripDoubleStarFromFilename(ruleFile.get()), allowedReferences);

        return conf;
    }

    public Configuration readConfigForOneCatalog(String configFile, String path) throws IOException {
        FileReader theReader = new FileReader();

        Optional<String> ruleFile = theReader.readFile(path, configFile)
                .filter(isFileNameInConfFile())
                .findFirst();

        if(!ruleFile.isPresent()){
            throw new IllegalStateException("Configurationfile is not correct. Must have a row like this: '**AJavaFile.java'");
        }

        List<String> allowedReferences = theReader.readFile(path, configFile)
                .filter(isAnAllowedReference())
                .collect(Collectors.toList());

        Configuration conf = new Configuration();
        conf.addRules(stripDoubleStarFromFilename(ruleFile.get()), allowedReferences);

        return conf;
    }


    private String stripDoubleStarFromFilename(String filename){
        if(filename.length() <= MANDATORY_FILENAME_CHARS.length()){
            throw new IllegalStateException("Configurationfile is not correct. Must have a row like this: '**AJavaFile.java'");
        }

        return filename.substring(DOUBLESTAR.length());
    }
}
