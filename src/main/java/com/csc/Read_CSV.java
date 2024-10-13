package com.csc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Read_CSV {
  // Reads CSV to a dataframe
  public ArrayList<ArrayList<String>> read_csv(String sourceData)
  {
    ArrayList<ArrayList<String>> dataframe = new ArrayList<>();
    // RegEx to separate on a comma and to keep items within double quotes together
    String dataSep = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";

    try
    {
      FileReader fr = new FileReader(sourceData);
      BufferedReader br = new BufferedReader(fr);
      String line;

      while((line = br.readLine()) != null)
      {
        String[] values = line.split(dataSep);
        ArrayList<String> row = new ArrayList<>();
        for (String value: values)
        {
          row.add(value);
        }
        dataframe.add(row);
      }
      br.close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

    return dataframe;
  }
}
