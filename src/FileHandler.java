import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

  Path contentPath = Paths.get("src/Files/content.txt");

  public void readContent() {
    try {
      List<String> lines = Files.readAllLines(contentPath);
      for (int i = 0; i < lines.size(); i++) {
        if (lines.get(i).startsWith("*")) {
          String adjustedLine = lines.get(i).substring(1); // will exclude 1st char, which is *
          System.out.println((i + 1) + " - [x] " + adjustedLine);
        } else {
          System.out.println((i + 1) + " - [ ] " + lines.get(i));
        }
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

      } catch (IOException e) {
        System.out.println("File with ToDo content is not accessable for changes");
      }
    }
  }

  public void removeContentFromFile(String[] args) {
    int numberOfLines = getNumberOfLines();
    if (args.length < 2) {
      throw new NullPointerException("Unable to remove: no index provided!");
    } else if (!argIsInteger(args[1])) {
    } else if (indexOfArgument(args) > numberOfLines) {
      System.out.println("Index of the task to be deleted '" + indexOfArgument(args) +
          "' does not exist! Index is out of bound.");
    } else {
      try {
        removeTask(contentPath, indexOfArgument(args));
      } catch (Exception e) {
        System.out
            .println("Something just went wrong, probably index of task to be removed is < 1");
      }
    }

  }

  private boolean argIsInteger(String arg) {
    try {
      Integer.parseInt(arg);
      return true;
    } catch (Exception e) {
      System.out.println("Unable to remove, remove index '" + arg + "' is not a number!");
      return false;
    }
  }


  private int indexOfArgument(String[] args) {
    int index = Integer.parseInt(args[1]);
    return index;
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

  public void checkTheTask(String[] args) {
    int numberOfLines = getNumberOfLines();
    if (args.length < 2) {
      throw new NullPointerException("Unable to check task: no index provided!");
    } else if (!argIsInteger(args[1])) {
    } else if (indexOfArgument(args) > numberOfLines) {
      System.out.println("Index of the task to be checked '" + indexOfArgument(args) +
          "' does not exist! The index is out of bound.");
    } else {
      try {
        updateTaskWithCheck(contentPath, indexOfArgument(args));
      } catch (Exception e) {
        System.out
            .println("Something just went wrong, probably index of task to be checked is < 1");
      }
    }
  }

  private void updateTaskWithCheck(Path contentPath, int indexOfArgument) throws IOException {
    List<String> contentList = Files.readAllLines(contentPath);
    String task = contentList.get(indexOfArgument - 1);
    if (task.startsWith("*")) {
      System.out.println("The task is already checked as completed!");
    } else {
      contentList.set(indexOfArgument-1, "*" + task);
      Files.write(contentPath, contentList);
      System.out.println("The task " + (indexOfArgument - 1) + " was checked as completed." );
    }
  }

}
