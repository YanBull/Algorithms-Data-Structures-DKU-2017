package capitalize;
import java.net.*;
public class InetAdressTest {
	public static void main(String args[]) throws UnknownHostException {
		InetAddress Address = InetAddress.getLocalHost();
		System.out.println(Address);
		Address = InetAddress.getByName("vk.com");
		System.out.println(Address);
		InetAddress SW[] = InetAddress.getAllByName("dku.kz");
		for(int i=0; i< SW.length; i++) {
			System.out.println(SW[i]);
		}
	}

}
