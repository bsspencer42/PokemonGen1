package DAO;

import Exceptions.PokedexFileNotFoundException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class csvDAO {
    private String fileName;
    private InputStreamReader isr;

    public csvDAO(String fileName){
        this.fileName = fileName;
        this.isr = setInputStreamReader(fileName);
    }

    private InputStreamReader setInputStreamReader(String fileName){
        InputStream is = this.getFileAsIOStream(fileName);
        return new InputStreamReader(is);
    }

    public List<List<String>> readFile() {
        // Initialize list
        List<List<String>> pokedex = new ArrayList<>();

        // Read CSV line by line
        try (BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                //String[] values = line.split(",");
                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                pokedex.add(Arrays.asList(values));
            }
        }
        // Handle FileNotFoundException
        catch (IOException e){
            throw new PokedexFileNotFoundException(String.format("Unable to find %s file!",fileName));
        }
        return pokedex;
    }

    private InputStream getFileAsIOStream(final String fileName)
    {
        InputStream ioStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(fileName);

        if (ioStream == null) {
            throw new IllegalArgumentException(fileName + " is not found");
        }

        return ioStream;
    }

}
