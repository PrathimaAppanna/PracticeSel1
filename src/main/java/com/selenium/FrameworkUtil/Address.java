package com.selenium.FrameworkUtil;

import java.util.ArrayList;
import java.util.List;

public class Address {
	

	    private List<String> types;

	    private String website;

	    private String address;

	    private String name;

	    private String accuracy;

	    private Location location;

	    private String phone_number;

	    private String language;

	    public List<String> getTypes ()
	    {
	        return types;
	    }

	    public void setTypes (List<String> type)
	    {
	    	
	        this.types = type;
	    }

	    public String getWebsite ()
	    {
	        return website;
	    }

	    public void setWebsite (String website)
	    {
	        this.website = website;
	    }

	    public String getAddress ()
	    {
	        return address;
	    }

	    public void setAddress (String address)
	    {
	        this.address = address;
	    }

	    public String getName ()
	    {
	        return name;
	    }

	    public void setName(String name)
	    {
	        this.name = name;
	    }

	    public String getAccuracy ()
	    {
	        return accuracy;
	    }

	    public void setAccuracy (String accuracy)
	    {
	        this.accuracy = accuracy;
	    }

	    public Location getLocation ()
	    {
	        return location;
	    }

	    public void setLocation (Location location)
	    {
	        this.location = location;
	    }

	    public String getPhone_number ()
	    {
	        return phone_number;
	    }

	    public void setPhone_number (String phone_number)
	    {
	        this.phone_number = phone_number;
	    }

	    public String getLanguage ()
	    {
	        return language;
	    }

	    public void setLanguage (String language)
	    {
	        this.language = language;
	    }
	    
	    
	    public Address getAddressPOJO()
	    {
	    	Address address = new Address();
	    	Location location = new Location();
	    	List<String> type =new ArrayList<String>();
	    	type.add("shoe park");
	    	type.add("shop");
	    	location.setLat("-38.383494");
	    	location.setLng("33.427362");
	    	address.setLanguage("French-IN");
	    	address.setWebsite("http://google.com");
	    	address.setAddress("29, side layout, cohen 09");
	    	
	    	address.setName("HSR");
	    	address.setAccuracy("50");
	    	address.setPhone_number("8987565");
	    	address.setTypes(type);
	    	
	    	
	    	
	    	address.setLocation(location);
	    	
	    	return address;
	    }

	   
	}
				
	
	
