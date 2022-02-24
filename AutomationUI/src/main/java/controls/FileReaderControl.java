package controls;

import dataProvider.ConfigReader;

public class FileReaderControl {
    private static FileReaderControl fileReaderControl = new FileReaderControl();
    private static ConfigReader configReader;

    private FileReaderControl(){
    }

    public static FileReaderControl getInstance(){
        return fileReaderControl;
    }

    public ConfigReader getConfigReader(){
        return (configReader == null) ?new ConfigReader() : configReader;
    }

}
