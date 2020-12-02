package company;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    DynamicTask dynamicTask = new DynamicTask();
    dynamicTask.readFromFile("ijones.txt");
    dynamicTask.show();
    int res = dynamicTask.iJones();
    System.out.println(res);
    try {
      FileWriter fileWriter = new FileWriter("result.txt");
      fileWriter.write(Integer.toString(res));
      fileWriter.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
