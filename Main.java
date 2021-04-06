import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

class Main {

  static ArrayList<Person> people;
  static FileWriter writeFile;
  static FileReader myFile;

  public static void main(String[] args) {
    people = new ArrayList<Person>();

    people.add(new Person("Andrew", 22, "blue"));
    people.add(new Person("A", 52, "red"));
    people.add(new Person("B", 24, "yellow"));
    people.add(new Person("C", 29, "coral"));
    people.add(new Person("D", 19, "black"));

    try {
      writeFile = new FileWriter("data.txt");
      BufferedWriter output = new BufferedWriter(writeFile);

      for (int num = 0; num <people.size(); num++) {
        output.write(people.get(num).getName());
        output.newLine();
        output.write(Integer.toString(people.get(num).getAge()));
        output.newLine();
        output.write(people.get(num).getColor());
        output.newLine();

        output.flush();
      }
      output.close();
    }
     catch (IOException exception) {
      System.out.println("An error occured: " + exception);
    }
    try {
      myFile = new FileReader("data.txt");
      BufferedReader reader = new BufferedReader(myFile);

      String name = "";
      String color = "";
      int age = 0;
      while (reader.ready()) {
        name = reader.readLine();
        age = Integer.parseInt(reader.readLine());
        color = reader.readLine();

        System.out.printf("%-10s %-10s %-10s %n", name, age, color);
      }
      reader.close();
    }

    catch (IOException exception) {
      System.out.println("An error occured: " + exception);
    }
  }
}