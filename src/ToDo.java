public class ToDo {
  public static void main(String[] args) {

    String[]testArgs = {"-l", "3"};
    ArgumentHandler argumentHandler = new ArgumentHandler();
    argumentHandler.checkArgument(testArgs);
    //argumentHandler.checkArgument(args);

  }
}
