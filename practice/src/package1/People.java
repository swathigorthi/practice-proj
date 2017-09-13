package package1;

import java.util.HashMap;
import java.util.Map;

public class People {
	private String name;
	private Map<String, String> attrMap = new HashMap<>();
	
	public People(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	public People setAttribute(String attr, String value){
		attrMap.put(attr, value);
		return this;
	}
	
	public String getAttribute(String attr){
		List<String> l = new ArrayList<>();
		Collections.re
		return attrMap.get(attr);
		
	}
}
