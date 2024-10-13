package com.csc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Write_CSV {
  // Writes to_csv. Does not work like actual pandas would
  // Only intakes filelocation and then outputs prompted text
  // May overload this method later to allow for full dataframe output for extra credit items
  public static void to_csv(String fileLocation, String textInput)
  {

    try
    {
      File f = new File(fileLocation);
      FileWriter fw;
      // Checks if the file exists already. Does not overwrite / create a new one if exists
      if(!f.exists())
      {
        fw = new FileWriter(fileLocation);
      }
      else
      {
        fw = new FileWriter(fileLocation, true);
      }
      BufferedWriter writer = new BufferedWriter(fw);
      writer.write(textInput);
      writer.close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
