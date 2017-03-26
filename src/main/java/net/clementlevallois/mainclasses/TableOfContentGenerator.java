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
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LEVALLOIS
 */
public class TableOfContentGenerator {

    private static String bookRootFolder;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        System.out.println("geneating the table of content: ordered list of files which will be the chapters");
        bookRootFolder = args[1];
        BufferedWriter bw = new BufferedWriter(new FileWriter(bookRootFolder+File.separator+"toc.txt"));

        Files.walk(Paths.get(args[0])).filter(path -> path.toString().endsWith(".adoc") & !path.toString().contains("/book/"))
                .forEach((path) -> {
            try {
                bw.write(path.toString());
                bw.newLine();
            } catch (IOException ex) {
                Logger.getLogger(TableOfContentGenerator.class.getName()).log(Level.SEVERE, null, ex);
            }
                });
        bw.close();

    }

}
