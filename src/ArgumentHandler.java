public class ArgumentHandler {

  FileHandler fileHandler = new FileHandler();

  public void checkArgument (String[] args){
    if (args.length == 0) {
      printUsage();
    } else if (args[0].equals("-l") ) {
      if (fileHandler.isEmpty()) {
        System.out.println("No todos for today! :)");
      } else fileHandler.readContent();
    } else if (args[0].equals("-a")) {
      fileHandler.addContent(args);
    } else if (args[0].equals("-r")) {
      fileHandler.removeContentFromFile(args);
    } else {
      System.out.println("Unsupported argument!\n");
      printUsage();
    }

  }

  private void printUsage() {
    System.out.println("Command Line Todo application");
    System.out.println("=============================");
    System.out.println();
    System.out.println("Command line arguments:");
    System.out.println("    -l   Lists all the tasks");
    System.out.println("    -a   Adds a new task");
    System.out.println("    -r   Removes a task");
    System.out.println("    -c   Completes a task");
  }

}
