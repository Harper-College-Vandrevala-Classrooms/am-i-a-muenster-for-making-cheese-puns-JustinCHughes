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
  public ArrayList<ArrayList<String>> read_csv(String sourceData)
  {
    ArrayList<ArrayList<String>> dataframe = new ArrayList<>();
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
  
  public int columnCheck(ArrayList<ArrayList<String>> dataframe, int column, String value)
  {
    int answer = 0;
    int i =  1;

    while(i < dataframe.size())
    {
      if(dataframe.get(i).get(column).toUpperCase().contains(value.toUpperCase()))
      {
        answer++;
      }
      i++;
    }

    return answer;
  }

  public void to_csv(String fileLocation, String textInput)
  {

    try
    {
      File f = new File(fileLocation);
      FileWriter fw;
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

  public ArrayList<ArrayList<String>> filter(ArrayList<ArrayList<String>> dataframe, int column, String value)
  {
    ArrayList<ArrayList<String>> newDataFrame = new ArrayList<>();
    for(ArrayList<String> row : dataframe)
    {
      newDataFrame.add(row);
    }

    return newDataFrame;
  }

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