package com.csc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class pandas
{
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
  
  // Checks columns for a certain value and then returns the count of times it appears
  public int columnCheck(ArrayList<ArrayList<String>> dataframe, int column, String value)
  {
    int answer = 0;
    int i =  1;

    while(i < dataframe.size())
    {
      // Converts to UpperCase before doing any comparisons
      if(dataframe.get(i).get(column).toUpperCase().contains(value.toUpperCase()))
      {
        answer++;
      }
      i++;
    }

    return answer;
  }

  // Writes to_csv. Does not work like actual pandas would
  // Only intakes filelocation and then outputs prompted text
  // May overload this method later to allow for full dataframe output for extra credit items
  public void to_csv(String fileLocation, String textInput)
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

  // Created a filter function because I misunderstood the assignment
  // Kept the function in in case I needed it in the future
  public ArrayList<ArrayList<String>> filter(ArrayList<ArrayList<String>> dataframe, int column, String value)
  {
    ArrayList<ArrayList<String>> newDataFrame = new ArrayList<>();
    for(ArrayList<String> row : dataframe)
    {
      newDataFrame.add(row);
    }

    return newDataFrame;
  }

  // Was originally going to use unique to dynamically determine the unique milk types
  // Then go through the list to count each type of milk
  // This ended up not working out because there were combinations of milk types used
  // Kept this functionality in in case of future use cases
  public ArrayList<String> unique(ArrayList<ArrayList<String>> dataframe, int column)
  {
    ArrayList<String> uniqueList = new ArrayList<>();
    for(ArrayList<String> row: dataframe)
    {
      if(!uniqueList.contains(row.get(column)))
      {
        uniqueList.add(row.get(column));
      }
    }

    return uniqueList;
  }
}