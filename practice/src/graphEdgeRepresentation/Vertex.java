package graphEdgeRepresentation;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	int value;
//	List<Edge> incidentEdgeList = new ArrayList<>();
	
    List<Vertex> adjacentList = new ArrayList();
	
	public Vertex(int value){
		this.value = value;
	}
	
//	public Vertex setValue(int value){
//		this.value = value;
//	   return value;
//	}
	public int getValue(){
		return value;
	}
	
	public Vertex addAdjacentVertex(Vertex v){
		adjacentList.add(v);
//		v.adjacentList.add(this);
		return this;
		
	}
	
	public List<Vertex> getAdjacentList(){
		return adjacentList;
	}
	
	public List<Integer> getAdjacentListValues(){
		List<Integer> valueList = new ArrayList<>();
		for(Vertex v : adjacentList){
			valueList.add(v.getValue());
		}
		return valueList;
	}
	
	public void removeAdjacentVertex(Vertex v){
		adjacentList.remove(v);
	}
	
}
