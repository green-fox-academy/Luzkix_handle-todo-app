import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

  Path contentPath = Paths.get("Files/content.txt");

  public void readContent() {
    try {
      List<String> lines = Files.readAllLines(contentPath);
      for (int i = 0; i < lines.size(); i++) {
        System.out.println((i + 1) + " - " + lines.get(i));
      }

    } catch (Exception e) {
      System.out.println("File with ToDo content is not available");
    }
  }

  public boolean isEmpty() {
    try {
      List<String> lines = Files.readAllLines(contentPath);
      return lines.size() == 0;
    } catch (Exception e) {
      return false;
    }
  }

  public void addContent(String[] args) {
    try {
      List argument = new ArrayList();
      argument.add(args[1]);
      Files.write(contentPath, (argument+System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);

    } catch (Exception e) {
      System.out.println("File with ToDo content is not accessable for changes");
    }
  }
}
