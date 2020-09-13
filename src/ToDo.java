public class ToDo {
  public static void main(String[] args) {

    //String[]testArgs = {"-a", "test"};
    ArgumentHandler argumentHandler = new ArgumentHandler();
    //argumentHandler.checkArgument(testArgs);
    argumentHandler.checkArgument(args);

  }
}
