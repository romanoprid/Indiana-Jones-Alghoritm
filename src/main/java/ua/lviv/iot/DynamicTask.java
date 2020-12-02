package ua.lviv.iot;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.Integer.parseInt;

public class DynamicTask {

  private List<String> words;
  private int height;
  private int width;

  public DynamicTask() {
    this.words = new ArrayList<String>();
    this.height = 0;
    this.width = 0;

  }

  public void readFromFile(String fileName) throws FileNotFoundException {
    try (Scanner scanner = new Scanner(new File(fileName))) {

      String input = scanner.nextLine();
      this.width = parseInt(input.split(" ")[0]);
      this.height = parseInt(input.split(" ")[1]);

      for (int i = 0; i < height; i++) {
        try {
          input = scanner.nextLine();
          this.words.add(input);
        } catch (NoSuchElementException ignored) {

        }
      }

    } catch (FileNotFoundException e) {
      System.out.println("File not found!!!");
    }
  }


  public void show() {
    for (String word : this.words) {
      System.out.println(word);

    }


  }

  public int iJones() {
    int[][] waysCount = new int[height][width];
    for (int i = 0; i < height; i++) {
      waysCount[i][0] = 1;
    }
    Map<Character, Integer> previous_columns = new HashMap<>();

    for (String row : words) {
      char letter = row.charAt(0);
      if (previous_columns.containsKey(letter)) {
        previous_columns.put(letter, previous_columns.get(letter) + 1);
      } else {
        previous_columns.put(letter, 1);
      }
    }

    for (int j = 1; j < width; j++) {
      Map<Character, Integer> currentColumn = new HashMap<>();
      for (int i = 0; i < height; i++) {
        char letter = words.get(i).charAt(j);
        waysCount[i][j] = 0;
        waysCount[i][j] = previous_columns.getOrDefault(letter, 0);
        if (letter != words.get(i).charAt(j - 1)) {
          waysCount[i][j] += waysCount[i][j - 1];
        }
        currentColumn.put(letter, currentColumn.getOrDefault(letter, 0) + waysCount[i][j]);
      }

      for (char letter : currentColumn.keySet()) {
        previous_columns.put(letter, previous_columns.getOrDefault(letter, 0) + currentColumn.get(letter));
      }

    }
    int number_of_ways_to_exit = waysCount[0][width - 1];
    if (height > 1) {
      number_of_ways_to_exit += waysCount[height - 1][width - 1];
    }

    return number_of_ways_to_exit;
  }


}


