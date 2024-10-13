package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

  /*@Test
  void testInteger() {
    ArrayList<ArrayList<String>> outerList = new ArrayList<>();
    ArrayList<String> innerList = new ArrayList<>();

    innerList.add("Cheese");
    innerList.add("Gouda");
    innerList.add("Swiss");
    innerList.add("American");
    innerList.add("PepperJack");
    outerList.add(innerList);

    System.out.println(outerList);

    assertEquals(1, Contains.check(outerList,0,"American"));
  }*/

}
