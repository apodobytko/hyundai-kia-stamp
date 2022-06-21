package stationdm.euapi.header;

import java.util.Base64;

public class RemoteHttpHeader {
  static {
    System.loadLibrary("native-lib");
  }

  public static int MAX_STAMPS = 1000;
  public static int STEP_IN_SECONDS = 120;

  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Please give an input");
      return;
    }

    if (args.length != 2) {
      return;
    }

    String command = args[0];
    String clientId = args[1];

    if (command.equalsIgnoreCase("single")) {
      int unixTime = (int) (System.currentTimeMillis() / 1000L);
      String stamp = getStamp(clientId + ":" + unixTime);
      System.out.println(stamp);
    }

    if (command.equalsIgnoreCase("list")) {
      int start = (int) (System.currentTimeMillis() / 1000L);
      for (int i = 0; i < MAX_STAMPS; i++) {
        int unixTime = start + i * STEP_IN_SECONDS;
        String stamp = getStamp(clientId + ":" + unixTime);
        System.out.println(stamp);
      }
    }
  }

  public static String getStamp(String payload) {
    return Base64.getEncoder().encodeToString(stringFromJNI(payload));
  }

  public static native byte[] stringFromJNI(String str);
}
