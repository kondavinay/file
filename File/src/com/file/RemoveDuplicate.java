package com.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class RemoveDuplicate {

	
	public static void method(ArrayList<String> f) throws IOException, ClassNotFoundException {
		
		
		File file =new File("C:\\Users\\Vinay Konda\\Desktop\\New folder (3)\\1\\folder\\myOutput9.csv");
		FileOutputStream fos =new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		RemoveDuplicate red = new RemoveDuplicate();
		
		System.out.println("\n\n");

		Object[] st = f.toArray();
		for (Object s : st) {
			if (f.indexOf(s) != f.lastIndexOf(s)) {
				f.remove(f.lastIndexOf(s));
				for (String str : f) {
					System.out.println("Distinct List " + str);
				}
			}
			
			
		}
			
		
			
		
		System.out.println("distinct elements");

		
			
		 ArrayList<String> validFail= new ArrayList<String>();
  	   
  	   String value2[] = f.toArray(new String[f.size()]);
         
         for(String mack : value2) {
      	   String value[]=mack.split(",");
  	   

			if (((Double.parseDouble(value[3]) + (Double.parseDouble(value[4]))) == Double.parseDouble(value[5]))
					|| ((Float.parseFloat(value[3]) + Float.parseFloat(value[4])) == (Float.parseFloat(value[5])))) {

				System.out.println("\nRecord \nTransaction Reference : " + value[0]);

				
				System.out.println("Description: " + value[2]);

				oos.writeChars("\nRecord \nTransaction Reference : " + value[0]+"\n"+"Description: " + value[2]);

			} else if (((Double.parseDouble(value[3]) + Double.parseDouble(value[4])) != (Double.parseDouble(value[5])))
					|| ((Float.parseFloat(value[3]) + Float.parseFloat(value[4])) != (Float.parseFloat(value[5])))) {

				validFail.add("\nRecord\nTransaction Reference : " + value[0] + "\nAccount Number : " + value[1]
						+ "\nDescription  : " + value[2] + "\nstartBalance : " + value[3] + "\nEndBalance : " + value[4]
						+ "\nEnd Balance : " + value[5]);
				
			}
  	   
     }
     
       
   
     
     
     
     for(String s1: validFail) {
				
				System.out.println("failed records"+s1);
				oos.writeObject("\n\nfailed records"+s1);
				
			}
    
  oos.close();
  fos.close();
	}
	
}
