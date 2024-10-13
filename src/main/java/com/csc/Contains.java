package com.csc;

import java.util.ArrayList;

public class Contains {
  // Checks columns for a certain value and then returns the count of times it appears
  public static int check(ArrayList<ArrayList<String>> dataframe, int column, String value)
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
}
