package windowsRemote;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
 
public class ping {
	
	public ArrayList<String> checkHosts(String subnet) throws UnknownHostException, IOException{
		   int timeout=1000;
		   ArrayList<String> ip = new ArrayList<>();
		   for (int i=1;i<2;i++){
		       String host=subnet + "." + i;
		       if (InetAddress.getByName(host).isReachable(timeout)){
		           //System.out.println(InetAddress.getByName(host) + " is reachable");
		           //System.out.println(InetAddress.getByName(host).getHostName());
		    	   ip.add(InetAddress.getByName(host).toString());
		    	   ip.add(InetAddress.getByName(host).getHostName());
		           
		       }
		   }
		   return ip;
		}
 
	public  ArrayList<String> getIP()throws IOException {
		//checkHosts("192.168.201");
		InetAddress localhost = InetAddress.getLocalHost();
		byte[] ip = localhost.getAddress();
		System.out.println(InetAddress.getByAddress(ip));
		String myip = InetAddress.getByAddress(ip).toString();
		myip=myip.substring(1);
		myip=myip.substring(0,myip.lastIndexOf(".")); 
		//System.out.println(myip);
		return(checkHosts("10.100.53"));

	}
}