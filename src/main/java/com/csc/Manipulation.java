package com.csc;

import java.util.ArrayList;

public class Manipulation
{
  public static ArrayList<ArrayList<String>> dropColumn(ArrayList<ArrayList<String>> df, int column)
  {
    ArrayList<ArrayList<String>> tempDF = new ArrayList<>();
    for(ArrayList<String> row : df)
    {
      ArrayList<String> tempRow = new ArrayList<>(row);
      tempRow.remove(column);
      tempDF.add(tempRow);
    }

    return tempDF;
  }
}
