package services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public void write(String response, String pathOUT) throws IOException {

        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(pathOUT));

        buffWrite.append(response);
        buffWrite.close();
    }
}
