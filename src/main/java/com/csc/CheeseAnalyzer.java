package com.csc;

import java.util.ArrayList;

public class CheeseAnalyzer
{
  public static void main(String[] args)
  {
    String cheese = "cheese_data.csv";

    ArrayList<ArrayList<String>> df = Read_CSV.read_csv(cheese);

    String input = "The amount of cheeses that use pasteurized milk are: " + Contains.check(df, 9, "Pasteurized") + "\n";
    Write_CSV.statement("output.txt", input);
    
    input = "The amount of cheeses that use raw milk are: " + Contains.check(df, 9, "Raw Milk") + "\n";
    Write_CSV.statement("output.txt", input);

    input = "The amount of cheeses that are both organic and over 41% moisture are: " + Contains.orgAndMoist(df) + "\n";
    Write_CSV.statement("output.txt", input);

    String[] milkType = {"cow","goat","ewe", "buffalo"};
    String maxMilk = "";
    int currMax = 0;
    int test;

    // Iterates over milkType items to check for max
    // Then sets variables accordingly to retain max info
    for(String item : milkType)
    {
      test = Contains.check(df, 8, item);
      input = "The amount of cheeses that use milk from a(n) " + item + " is: " + test + "\n";
      Write_CSV.statement("output.txt", input);
      if(test > currMax)
      {
        currMax = test;
        maxMilk = item;
      }
    }

    input = "Milk from a " + maxMilk + " is the most used for cheeses in Canada with a total of: " + currMax + "\n";
    Write_CSV.statement("output.txt", input);

    input = "The average percent moisture of the cheeses listed is " + Contains.colAvg(df, 3) + "%\n";
    Write_CSV.statement("output.txt", input);

    Write_CSV.dfToCSV("cheese_without_headers.csv", df, false);
    Write_CSV.dfToCSV("cheese_without_ids.csv", Manipulation.dropColumn(df, 0), true);
  }
}