package com.csc;

import java.util.ArrayList;

public class CheeseAnalyzer
{
  public static void main(String[] args)
  {
    pandas pd = new pandas();
    String cheese = "cheese_data.csv";

    ArrayList<ArrayList<String>> df = pd.read_csv(cheese);

    String input = "The amount of cheeses that use pasteurized milk are: " + pd.columnCheck(df, 9, "Pasteurized") + "\n";
    pd.to_csv("output.txt", input);
    
    input = "The amount of cheeses that use raw milk are: " + pd.columnCheck(df, 9, "Raw Milk") + "\n";
    pd.to_csv("output.txt", input);

    input = "The amount of cheeses that are both organic and over 41% moisture are: " + orgAndMoist(df) + "\n";
    pd.to_csv("output.txt", input);

    String[] milkType = {"cow","goat","ewe", "buffalo"};
    String maxMilk = "";
    int currMax = 0;
    int test;

    for(String item : milkType)
    {
      test = pd.columnCheck(df, 8, item);
      input = "The amount of cheeses that use milk from a(n) " + item + " is: " + test + "\n";
      pd.to_csv("output.txt", input);
      if(test > currMax)
      {
        currMax = test;
        maxMilk = item;
      }
    }

    input = "Milk from a " + maxMilk + " is the most used for cheeses in Canada with a total of: " + currMax + "\n";
    pd.to_csv("output.txt", input);
  }

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