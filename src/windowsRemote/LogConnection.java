package windowsRemote;

import java.io.InputStream;
import java.util.ArrayList;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

 
public class LogConnection {
	 
	/**
	 * JSch Example Tutorial
	 * Java SSH Connection Program
	 */
	public ArrayList<String>  getlog(String ip,String user,String command) {
	    //String host="192.168.202.2";
		String host=ip;
		
		remotecall rc=new remotecall();
	    String password=rc.getpassword(ip);
	    String command1="cat /var/log/"+command;
	    try{
	    	
	    	java.util.Properties config = new java.util.Properties(); 
	    	config.put("StrictHostKeyChecking", "no");
	    	JSch jsch = new JSch();
	    	Session session=jsch.getSession(user, host, 22);
	    	session.setPassword(password);
	    	session.setConfig(config);
	    	session.connect();
	    	System.out.println("Connected");
	    	
	    	Channel channel=session.openChannel("exec");
	        ((ChannelExec)channel).setCommand(command1);
	        channel.setInputStream(null);
	        ((ChannelExec)channel).setErrStream(System.err);
	        ArrayList<String> log = new ArrayList<>();
	        InputStream in=channel.getInputStream();
	        channel.connect();
	        byte[] tmp=new byte[1024];
	        while(true){
	          while(in.available()>0){
	            int i=in.read(tmp, 0, 1024);
	            if(i<0)break;
	            //System.out.print(new String(tmp, 0, i));
	            log.add(new String(tmp, 0, i));
	          }
	          if(channel.isClosed()){
	            System.out.println("exit-status: "+channel.getExitStatus());
	            break;
	          }
	          try{Thread.sleep(1000);}catch(Exception ee){}
	        }
	        channel.disconnect();
	        session.disconnect();
	        System.out.println("DONE");
	        return(log);
	       
	    }catch(Exception e){
	    	e.printStackTrace();
	    	ArrayList<String> error = new ArrayList<>();
	    	error.add("Cant fetch log Check Network Connection !!!!!!!");
	    	return error;
	    }
		

	}

}
