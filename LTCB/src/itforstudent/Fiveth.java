package itforstudent;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;

public class Fiveth {
  public static void main(String[] args) {
    ArrayList<String> cars = new ArrayList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
    Collections.sort(cars); 
    System.out.println(cars);
    for (String i : cars) {
    	System.out.println(i);
    }
    LinkedList<String> clock = new LinkedList<String>();
    clock.addFirst("Rolex");
    clock.addLast("Hm");
    clock.addFirst("Td");
    clock.addLast("abs");
    Collections.sort(cars); 
    System.out.println(cars);
  }
}