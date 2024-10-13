package com.csc;

import java.util.ArrayList;

public class pandas
{
  
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

  // Created a filter function because I misunderstood the assignment
  // Kept the function in in case I needed it in the future
  public ArrayList<ArrayList<String>> filter(ArrayList<ArrayList<String>> dataframe, int column, String value)
  {
    ArrayList<ArrayList<String>> newDataFrame = new ArrayList<>();
    for(ArrayList<String> row : dataframe)
    {

      if(row.get(column).toUpperCase().contains(value.toUpperCase()))
      {
        newDataFrame.add(row);
      }
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