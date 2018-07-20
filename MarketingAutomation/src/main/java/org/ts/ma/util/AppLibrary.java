package org.ts.ma.util;

import java.util.Random;
import java.util.UUID;

public class AppLibrary {
	
	public static String randomListName()
	{ 
		Random r1 = new Random();
		int result =  10000 + r1.nextInt(99);  
		char u  = (char) (65+r1.nextInt(26));
		char l = (char)(97 + r1.nextInt(26));
		String randomValue=u+""+l+""+result;
		return randomValue;
	}

	public static String randomDefaultEmail()
	{ 
		Random r1 = new Random();
		int result =  10000 + r1.nextInt(99);  
		String uuid = UUID.randomUUID().toString();
		String domain="@gmail.com";
		String email=uuid+result+domain;
		return email;
	}
	public static String randomDefaultName()
	{ 
		
		String name = UUID.randomUUID().toString();
		return name;
	}
	
	public static String randomCompany()
	{ 
		
		String comp = UUID.randomUUID().toString();
		String reg="Pvt Ltd 2008-2018";
		String company=comp+" "+reg;
		return company;
	}
	
	public static String randomAddress()
	{ 
		Random r1 = new Random();
		int result =  100 + r1.nextInt(99); 
		String addrr = UUID.randomUUID().toString();
		String address= result+" "+addrr;
		
		return address;
	}
	public static String randomZipcode()
	{ 
		Random r1 = new Random();
		String Zipcode =  Integer.toString(1000000 + r1.nextInt(99));  
		
		return Zipcode;
	}
	
	public static String randomPhone()
	{ 
		Random r1 = new Random();
		String phone = Integer.toString(1000000000 + r1.nextInt(99)); 
		
		return phone;
	}
	
	
}
