package stationdm.euapi.header;
import java.util.Base64;

public class RemoteHttpHeader {
	static {
		System.loadLibrary("native-lib");
	}

	public static void main(String[] args) {
		if(args.length == 0) {
			System.out.println("Please give an input");
			return;
		}

		if(args.length != 2) {
			return;
		}

		String command = args[0];
		String clientId = args[1];

		if (command.equalsIgnoreCase("single")) {
			String stamp = getStamp(clientId);
			System.out.println(stamp);
		}

		if (command.equalsIgnoreCase("list")) {
			System.out.println("Generating 1k stamps...");
			for(int i=0; i<1000; i++) {
				int unixTime = (int) (System.currentTimeMillis() / 1000L) + i;
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
