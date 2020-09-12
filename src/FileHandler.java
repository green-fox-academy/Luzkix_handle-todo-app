import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileHandler {

  Path contentPath = Paths.get("content.txt");

  public void readContent() {
    try {
      List<String> lines = Files.readAllLines(contentPath);
      for (int i = 0; i <lines.size(); i++) {
        System.out.println((i+1) + " - " + lines.get(i));
      }

    } catch (Exception e) {
      System.out.println("file with ToDo content is not available");
    }
  }
}
