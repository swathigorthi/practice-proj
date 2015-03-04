package package1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PeopleMain {

	public static void main(String[] args) {
		People p1 = new People("p1");
		p1.setAttribute("sex", "M").setAttribute("occupation", "cop");
		People p2 = new People("p2");
		p2.setAttribute("sex", "F").setAttribute("occupation", "cop");
		People p3 = new People("p3");
		p3.setAttribute("sex", "M").setAttribute("occupation", "doc");
		People p4 = new People("p4");
		p4.setAttribute("sex", "F").setAttribute("occupation", "doc");
		People p5 = new People("p5");
		p5.setAttribute("sex", "M").setAttribute("occupation", "cop");
		
		List<People> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		List<String> groupByList = Arrays.asList("sex","occupation");
		 groupBy(list, groupByList);
		
		
	}
	
	public static void groupBy(List<People>peopleList, List<String> attrList){
		List<List<People>> lol = new ArrayList<>();
		lol.add(peopleList);
		for(String attr: attrList){
			lol = groupByAttribute(lol, attr);
		}
		for(List<People> list : lol ){
			for(People p : list)
			System.out.println(p.getName());
		}
		
		
		 
	}
	
	private static List<List<People>> groupByAttribute(List<List<People>> lol, String attr){
		List<List<People>> newLol = new ArrayList<>();
		for(List<People> list : lol ){
			Map<String, List<People>> map= new HashMap<>();
			for (People p  : list){
				String value = p.getAttribute(attr);
				if(map.containsKey(value)){
					map.get(value).add(p);
				}
				else{
					List<People> newList = new ArrayList<>();
					newList.add(p);
					map.put(value,newList);
				}
			}
			for(String str : map.keySet()){
				newLol.add(map.get(str));
			}
		}
		
		return newLol;
	}

}
