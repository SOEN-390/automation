package galen;

import com.galenframework.reports.GalenTestInfo;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class GalenTestInfoContainer {
    private List<GalenTestInfo> galenTests = new LinkedList<>();

    public List<GalenTestInfo> get() {
        return galenTests;
    }

    public void add(GalenTestInfo testInfo) {
        galenTests.add(testInfo);
    }
}
