package CovidTracker.dataFiles;

import java.io.*;

public class LoginReader {

    private String loginPath;
    private File file;
    BufferedReader bufferedReader;
    private String[] cell;
    private String line;

    public String[] readLoginData(String path, int expectedLine) throws FileNotFoundException, IOException {
        this.loginPath = path;
        try {
            file = new File(loginPath);
            bufferedReader = new BufferedReader(new FileReader(file));

            for(int i = 0; i < expectedLine; i++) {
                bufferedReader.readLine();
            }

            if((line = bufferedReader.readLine()) != null) {
                cell = line.split(",");
            }

            return cell;
        }
        catch(FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        return cell;
    }

}
