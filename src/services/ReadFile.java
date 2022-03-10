package services;

import models.Registro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    /**
     * Faz a leitura das linhas e retorna uma lista do tipo Registro onde cada registro
     * pode conter um dos tipos Vendedor, Cliente ou Venda.
     *
     * @return List<Registro>
     * @throws IOException
     */
    public List<Registro> read(String pathIN) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(pathIN));
        Process process = new Process();

        String line = "";

        List<Registro> registros = new ArrayList<Registro>();

        while (true) {
            line = buffRead.readLine();

            if (line != null) {
                String[] arrayLinha = line.split("ç");
                registros.add(process.identificarLinha(arrayLinha));

            } else
                break;

        }

        buffRead.close();

        return registros;
    }
}
