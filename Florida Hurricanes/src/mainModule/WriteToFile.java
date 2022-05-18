//Written By Maksim Artemev
//Spring 2022

package mainModule;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class WriteToFile {

  public final static String OUTPUT_DIRECTORY = "C:\\SFC\\COP2552\\Project4\\";

  public static boolean writeToFile(String filename, List<String> contents) {
    FileWriter writer;

    try {
      writer = new FileWriter(new File(OUTPUT_DIRECTORY + filename));
    } catch (IOException e) {
      System.out.print("Unable to read file: " + OUTPUT_DIRECTORY + filename);
      e.printStackTrace();
      return false;
    }
    
    PrintWriter outputWriter = new PrintWriter(writer);
    for (String line: contents) {
      outputWriter.println(line);
    }

    return true;
    
  }
}
