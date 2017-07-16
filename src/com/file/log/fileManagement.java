package com.file.log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class fileManagement {
	
	public void storefile(ArrayList<String> log,String user){
		try{
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			Date time=cal.getTime();
			String file=time.toString().replace(":","-").replace("IST", "");
			String filename=""+user+"-"+file.toString()+"";
			System.out.println(filename);
		    PrintWriter writer = new PrintWriter("logfile//"+filename+".txt", "UTF-8");
		    for(int i=0;i<log.size();i++)
		    {
		    writer.println(log.get(i));
		    }
		    
		    writer.close();
		} catch (Exception e) {
		   // do something
		}
		
	}
	  public  List<String> getfile(String user) {
    	  List<String> textFiles = new ArrayList<String>();
    	  File dir = new File("logfile");
    	  for (File file : dir.listFiles()) {
    	    if (file.getName().endsWith((".txt"))&&file.getName().startsWith((user))) {
    	      textFiles.add(file.getName());
    	    }
    	  }
    	  return textFiles;
    	}
	  public ArrayList<String> showfile(String filename) {
		   
		   ArrayList<String> al = new ArrayList<>();
		   try {
			   BufferedReader br = new BufferedReader(new FileReader("logfile//"+filename));
		       StringBuilder sb = new StringBuilder();
		       String line = br.readLine();
	         
		       while (line != null) {
		           sb.append(line);
		           sb.append(System.lineSeparator());
		           al.add(line.toString());
		           line = br.readLine();
		           
		       }
		       //String everything = sb.toString();
		       br.close();
		       return al;
		       
		       
		   }catch(Exception e){
			   al.add(e.toString());
			 return al;
		   }
		  
		
		  
	  }

}
