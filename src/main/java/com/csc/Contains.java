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

  // Opted to just hard code the check for this
  public static int orgAndMoist(ArrayList<ArrayList<String>> df)
  {
    int i = 1;
    int organicXMoist = 0;
    
    while(i < df.size())
    {
      if(!((df.get(i).get(6)).trim().isEmpty()) && !((df.get(i).get(3)).trim().isEmpty()))
      {
        if((Integer.valueOf(df.get(i).get(6)) == 1) && (Double.valueOf(df.get(i).get(3)) > 41.0))
        {
          organicXMoist++;
        }
      }
      i++;
    }

    return organicXMoist;
  }
}
