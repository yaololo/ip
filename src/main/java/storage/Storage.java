package storage;

import exception.ErrorHandler;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;

public class Storage {
    private final Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
    private String filePath = "";


    public Storage (String filePath) {
        this.filePath = filePath;
    }

    /**
     * This method is used to load data from a local file and parse the format then save as a List of task
     * @throws ErrorHandler customized error
     * @return array of strings tha is loaded from file
     */
    private String [] loadData () throws ErrorHandler  {
        ArrayList<String> data = new ArrayList<>();

        try {
            File file=new File(root + this.filePath);    //creates a new file instance
            FileReader fr=new FileReader(file);   //reads the file
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream
            String line;

            while((line=br.readLine())!=null) {
                data.add(line);
            }

            fr.close();    //closes the stream and release the resources
        } catch(FileNotFoundException e) {
            throw new ErrorHandler("Loading data");
        } catch (IOException e) {
            throw new ErrorHandler("reading data");
        }
        return data.toArray(new String[0]);
    }

    /**
     * Save list of task into local file
     * @throws ErrorHandler customized error
     */
    public void saveData(String [] data) throws ErrorHandler {
        try {
            FileWriter fileWriter = new FileWriter(root + this.filePath);

            for(String line: data) {
                fileWriter.write(line);
                fileWriter.write("\n");
            }

            fileWriter.close();
        } catch (IOException e) {
            throw new ErrorHandler("writing data");
        }
    }

}