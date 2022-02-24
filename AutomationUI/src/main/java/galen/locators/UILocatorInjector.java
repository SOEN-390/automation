package galen.locators;

import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UILocatorInjector {
    private static final Logger LOG = LoggerFactory.getLogger(UILocatorInjector.class);
    private static final String SPACES = "   ";


    private List<String> formatUILocators (Map<String, Pair<String, String>> locatorMap){
        LOG.info("Inject page locators to a gspec's header", locatorMap);

        List<String> lines = new ArrayList<>();
        lines.add("@objects");
        for(Map.Entry<String, Pair<String, String>> entry : locatorMap.entrySet()){
            StringBuilder strBuilder = new StringBuilder(SPACES);
            strBuilder.append(SPACES);
            strBuilder.append(entry.getKey());
            strBuilder.append(SPACES);
            strBuilder.append(entry.getValue().getLeft());
            strBuilder.append(SPACES);
            strBuilder.append(entry.getValue().getRight());
            lines.add(strBuilder.toString());
        }
        return lines;
    }


    public String injectUILocators(String templatePath, Map locators){
        File file = null;
        try{
            List<String> lines = formatUILocators(locators);
            lines.addAll(Files.readAllLines(Paths.get(templatePath), StandardCharsets.UTF_8));
            file = File.createTempFile("galen-", locators.getClass().getSimpleName());
            Files.write(file.toPath(),lines, StandardCharsets.UTF_8);

        }catch (IOException exception) {
            LOG.error("Error writing Galen spec", exception);
        }

        return (file == null) ? null : file.getPath();

    }


}
