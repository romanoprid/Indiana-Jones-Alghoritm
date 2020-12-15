package test;

import company.DynamicTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DynamicTaskTest {

  @BeforeEach
  public void initializeScanner() {
    try {
      Scanner scanner = new Scanner(new File("result.txt"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  @Test
  void testExample() throws FileNotFoundException {
   DynamicTask dynamicTask = new DynamicTask();
   dynamicTask.readFromFile("ijones.txt");
    int res = dynamicTask.iJones();

    try {
      FileWriter fileWriter = new FileWriter("result.txt");
      fileWriter.write(Integer.toString(res));
      fileWriter.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    assertEquals(201684, res);
  }


}