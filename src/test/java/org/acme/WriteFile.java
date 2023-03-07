package org.acme;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public record WriteFile() {
    public static void main(String[] args) {
        try {
            Path file = Paths.get("F:\\BBL\\Practice\\TestFile\\Write_1.txt");
            BufferedWriter writer = Files.newBufferedWriter(file, 
                    StandardCharsets.UTF_8);   

            for (int i = 0; i < 10; i++) {
                writer.write("This is content line " + (i + 1));
                writer.newLine();
            }

            writer.close();       
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }
}

