package dataProvider;

import enums.BrowserType;
import enums.EnvType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private final static String filePath = System.getProperty("user.dir")
            + "/config/config.Properties";
    static FileInputStream fileInputStream = null;
    public static Properties config = null;

    public ConfigReader(){
        config = new Properties();

        try {
            fileInputStream = new FileInputStream(new File(filePath));
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
            throw new RuntimeException("config.Properties file is not found at " + filePath);

        }

        try {
            config.load(fileInputStream);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getApplicationUrl() {
        String url = config.getProperty("baseURL");
        if(url != null) return url;
        else throw new RuntimeException("url is not specified in the config.Properties file.");
    }

    public BrowserType getBrowserType(){
        String browserName = config.getProperty("browser");
        if(browserName == null || browserName.equals("chrome")) return BrowserType.CHROME;
        else if(browserName.equalsIgnoreCase("firefox")) return BrowserType.FIREFOX;
        else if(browserName.equals("safari")) return BrowserType.SAFARI;
        else if(browserName.equals("edge")) return BrowserType.EDGE;
        else throw new RuntimeException("Browser Name Key value in config.Properties is not matched : " + browserName);
    }

    public EnvType getEnvType(){
        String envType = config.getProperty("environment");
        if(envType.equals(null) || envType.equals("local"))
            return EnvType.LOCAL;

        else if (envType.equals("remote"))
            return EnvType.REMOTE;
        else
            throw new RuntimeException("Environment Type value in config.Properties is not matched :" + envType);
    }

    public Boolean getWindowSize(){
        String windowSize = config.getProperty("windowMaximize");
        return (windowSize != null) ? Boolean.valueOf(windowSize) : true;
    }

    public String getDriverDir(){
        return System.getProperty("user.dir") + "/drivers";
    }

    public String getReportConfigPath(){
        String reportConfigPath = System.getProperty("user.dir") + config.getProperty("reportConfigPath");
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the config.Properties file for the Key:reportConfigPath");
    }

}
