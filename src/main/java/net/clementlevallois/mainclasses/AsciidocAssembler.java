/*
 * Copyright 2017 Clement Levallois
 * http://wwww.clementlevallois.net
 */
package net.clementlevallois.mainclasses;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LEVALLOIS
 */
public class AsciidocAssembler {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    private static String bookRootFolder;

    public static void main(String[] args) throws IOException {
        System.out.println("in the MAIIIN!");
        bookRootFolder = args[1];
        Files.walk(Paths.get(args[0])).filter(path -> path.toString().endsWith(".adoc") & !path.toString().contains("/book/"))
                .forEach((path) -> {
                    new AsciidocAssembler().readAndSave(path);
                    System.out.println("file: " + path.toString());
                });
    }

    private void readAndSave(Path path) {
        BufferedWriter bw = null;
        System.out.println("in read and save for file "+ path.toString());
        try {
            bw = new BufferedWriter(new FileWriter(bookRootFolder + File.separator + "book-gephi-tutorials-en.adoc",true));

            StringBuilder sb = new StringBuilder();
            try {
                Files.lines(path).forEach(string
                        -> {
                    sb.append(string);
                    sb.append("\n");
                });
            } catch (IOException ex) {
                Logger.getLogger(AsciidocAssembler.class.getName()).log(Level.SEVERE, null, ex);
            }
            bw.write(sb.toString());
        } catch (IOException ex) {
            Logger.getLogger(AsciidocAssembler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(AsciidocAssembler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
