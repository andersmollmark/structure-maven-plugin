package structure.analyze.configuration;

import structure.analyze.FileReader;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import static structure.analyze.predicates.StringPredicate.isFileNameInConfFile;
import static structure.analyze.predicates.StringPredicate.isRuleInConfFile;

/**
 * Created by molas on 2015-02-18.
 */
public class ConfigurationReader {

    public Configuration readConfigFileForOneFile(String configFile, String path) throws IOException {
        FileReader theReader = new FileReader(configFile, path);

        Optional<String> ruleFile = theReader.readFile()
                .filter(isFileNameInConfFile())
                .findFirst();

        if(!ruleFile.isPresent()){
            throw new IllegalStateException("Configurationfile is not correct. Must have a row like this: '**AJavaFile.java'");
        }


        List<String> allowedReferences = theReader.readFile()
                .filter(isRuleInConfFile())
                .collect(Collectors.toList());

        Configuration conf = new Configuration();
        conf.addRules(ruleFile.get(), allowedReferences);

        return conf;
    }
}
