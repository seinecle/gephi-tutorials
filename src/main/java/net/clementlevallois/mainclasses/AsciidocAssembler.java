/*
 * Copyright 2017 Clement Levallois
 * http://wwww.clementlevallois.net
 */
package net.clementlevallois.mainclasses;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
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
    private static String bookFullPathAndName;
    private static String bookCoverFullPathAndName;
    private static String bookTableOfContentFullPathAndName;

    private static String currPart = "";

    public static void main(String[] args) throws IOException {
        System.out.println("assembling the book!");
        bookRootFolder = args[0];
        System.out.println("bookRootFolder: " + bookRootFolder);
        bookFullPathAndName = bookRootFolder + File.separator + args[1];
        System.out.println("bookFullPathAndName: " + bookFullPathAndName);
        bookCoverFullPathAndName = bookRootFolder + File.separator + "cover.adoc";
        bookTableOfContentFullPathAndName = bookRootFolder + File.separator + "toc.txt";

        //adding the cover
        new AsciidocAssembler().coverAssembler();

        //adding chapters according to the table of content
        Path tocPath = Paths.get(bookTableOfContentFullPathAndName);

        int chapterCounter = 0;

        List<String> lines = Files.readAllLines(tocPath);
        for (String line : lines) {
            Path path = Paths.get(line);
            new AsciidocAssembler().chaptersAssembler(path, chapterCounter);
            chapterCounter++;
        }

    }

    private void chaptersAssembler(Path path, int chapterCounter) {

        try {
            BufferedWriter bw = null;
            System.out.println("in read and save for file " + path.toString());
            bw = Files.newBufferedWriter(Paths.get(bookFullPathAndName), StandardCharsets.UTF_8, StandardOpenOption.APPEND);

            StringBuilder sb = new StringBuilder();

            if (path.toString().contains("plugin") & !currPart.equals("plugin")) {
                currPart = "plugin";
                sb.append("\n");
                sb.append("<<<");
                sb.append("\n");
                sb.append("\n");
                sb.append("= " + "Plugins for Gephi");
                sb.append("\n");
                sb.append("\n");
                sb.append("<<<");
                sb.append("\n");

            }

            List<String> lines = Files.readAllLines(path);

            boolean firstTitleReached = false;
            boolean lastSectionReached = false;
            String docTitle = "";
            for (String line : lines) {

                //not writing lines from the header, wait to meet the first line starting with ==
                if (!firstTitleReached && line.startsWith("==")) {
                    firstTitleReached = true;
                    sb.append("\n");
                    sb.append("<<<");
                    sb.append("\n");
                    sb.append("\n");
                    sb.append("== " + docTitle);
                    sb.append("\n");
                    sb.append("\n");
                    sb.append("<<<");
                    sb.append("\n");
                }

                //the first line of the doc, starting with =, is the title of the doc
                if (line.startsWith("= ")) {
                    docTitle = line.replace("=", "").trim();
                }

                //the last section is always "== the end"
                if (line.toLowerCase().startsWith("== the end")) {
                    lastSectionReached = true;
                }

                //write all lines meeting the conditions
                if (firstTitleReached & !lastSectionReached) {
                    //transforming == into === to have no "chapter" inserted
                    if (line.startsWith("== ")) {
                        line = line.replace("== ", "=== ").trim();
                    }

                    sb.append(line);
                    sb.append("\n");
                }

            }
            bw.write(sb.toString());
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(AsciidocAssembler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void coverAssembler() {
        try {
            BufferedWriter bw = null;
            System.out.println("adding the cover");
            bw = Files.newBufferedWriter(Paths.get(bookFullPathAndName), StandardCharsets.UTF_8);

            StringBuilder sb = new StringBuilder();

            List<String> lines = Files.readAllLines(Paths.get(bookCoverFullPathAndName));
            for (String line : lines) {
                sb.append(line);
                sb.append("\n");

            }
            bw.write(sb.toString());
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(AsciidocAssembler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
