import services.Process;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {


        String fileName = "dados.dat";

        Process process = new Process();
        process.processarRegistros(fileName);
    }
}
