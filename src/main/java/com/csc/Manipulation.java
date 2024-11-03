package com.csc;

import java.util.ArrayList;

public class Manipulation
{
  public static ArrayList<ArrayList<String>> dropColumn(ArrayList<ArrayList<String>> df, int column)
  {
    for(ArrayList<String> row : df)
    {
      row.remove(column);
    }

    return df;
  }
}
