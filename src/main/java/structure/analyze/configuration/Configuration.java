package structure.analyze.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by molas on 2015-02-18.
 */
public class Configuration {

    private Map<String, List<String>> rules = new HashMap<>();

    public void addRule(String file, String allowedReference){
        if(rules.get(file) == null){
            rules.put(file, new ArrayList<>());
        }
        rules.get(file).add(allowedReference);
    }

    public void addRules(String file, List<String> allowedReferences){
        if(rules.get(file) == null){
            rules.put(file, new ArrayList<>());
        }
        rules.get(file).addAll(allowedReferences);
    }

    public Stream<String> getRules(String filename){
        return rules.get(filename).stream();
    }

}
