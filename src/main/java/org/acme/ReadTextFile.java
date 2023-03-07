package org.acme;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReadTextFile {
    public static ArrayList<String> main(String[] args) {  
        ArrayList<String> rm = new ArrayList<String>();
        try {
            Path file = Paths.get("F:\\BBL\\Practice\\test_1.txt");
            BufferedReader reader = Files.newBufferedReader(file , 
                    StandardCharsets.UTF_8);
            String line = null;

            System.out.println("All record");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                rm.add(line);
            }

            reader.close();
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
        return rm;
    }
}
