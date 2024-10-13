package com.csc;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class TestCheeseAnalyzer {
  // You can put test code here
  CheeseAnalyzer cheeseAnalyzer;

  @BeforeEach
  void setUp() {
    cheeseAnalyzer = new CheeseAnalyzer();
  }

   @Test
  void itWorks() {
    assertEquals(true, true);
  }

  @Test
  void testColumn0() {
    ArrayList<ArrayList<String>> testList = new ArrayList<>();
    
    testList.add(new ArrayList<>(Arrays.asList("Header", "Header","Header")));
    testList.add(new ArrayList<>(Arrays.asList("Gouda", "1","Pasteurized")));
    testList.add(new ArrayList<>(Arrays.asList("PepperJack", "0","Pasteurized")));
    testList.add(new ArrayList<>(Arrays.asList("American", "0","Raw")));
    testList.add(new ArrayList<>(Arrays.asList("Swiss", "1","Raw")));
    testList.add(new ArrayList<>(Arrays.asList("Cheddar", "1","Raw")));

    assertEquals(1, Contains.check(testList,0,"American"));
  }

  @Test
  void testColumn1() {
    ArrayList<ArrayList<String>> testList = new ArrayList<>();

    testList.add(new ArrayList<>(Arrays.asList("Header", "Header","Header")));
    testList.add(new ArrayList<>(Arrays.asList("Gouda", "1","Pasteurized")));
    testList.add(new ArrayList<>(Arrays.asList("PepperJack", "0","Pasteurized")));
    testList.add(new ArrayList<>(Arrays.asList("American", "0","Raw")));
    testList.add(new ArrayList<>(Arrays.asList("Swiss", "1","Raw")));
    testList.add(new ArrayList<>(Arrays.asList("Cheddar", "1","Raw")));

    assertEquals(3, Contains.check(testList,1,"1"));
  }

  @Test
  void testColumn2() {
    ArrayList<ArrayList<String>> testList = new ArrayList<>();

    testList.add(new ArrayList<>(Arrays.asList("Header", "Header","Header")));
    testList.add(new ArrayList<>(Arrays.asList("Gouda", "1","Pasteurized")));
    testList.add(new ArrayList<>(Arrays.asList("PepperJack", "0","Pasteurized")));
    testList.add(new ArrayList<>(Arrays.asList("American", "0","Raw")));
    testList.add(new ArrayList<>(Arrays.asList("Swiss", "1","Raw")));
    testList.add(new ArrayList<>(Arrays.asList("Cheddar", "1","Raw")));

    assertEquals(2, Contains.check(testList,2,"Pasteurized"));
  }
}
