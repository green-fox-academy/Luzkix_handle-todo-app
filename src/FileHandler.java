import java.io.IOException;
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
    if (args.length == 1) {
      System.out.println("Unable to add: no task provided");
    } else {
      try {
        List<String> argument = new ArrayList();
        argument.add(args[1]);
        //Arrays.asList(argument);
        Files.write(contentPath, argument, StandardOpenOption.APPEND);

      } catch (Exception e) {
        System.out.println("File with ToDo content is not accessable for changes");
      }
    }
  }

  public void removeContentFromFile(String[] args) {
    if (args.length < 2) {
      System.out.println("You must specify index of task to be removed!");
    } else {
      int indexOfArgument = Integer.parseInt(args[1]);
      int numberOfLines = getNumberOfLines();
      if (Integer.parseInt(args[1]) > numberOfLines) {
        System.out
            .println("Index of the task to be deleted '" + indexOfArgument + "' does not exist!");
      } else {
        try {
          removeTask(contentPath, indexOfArgument);
        } catch (Exception e) {
          System.out.println("Something just went wrong, probably index of task to be removed is < 1");
        }
      }
    }
  }

  private void removeTask(Path contentPath, int indexOfArgument) throws IOException {
    List<String> contentList = Files.readAllLines(contentPath);
    contentList.remove(indexOfArgument - 1);
    Files.write(contentPath, contentList);
  }

  private int getNumberOfLines() {
    try {
      List<String> contentList = Files.readAllLines(contentPath);
      return contentList.size();

    } catch (Exception e) {
      return 0;
    }
  }
}
