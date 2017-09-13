package graphEdgeRepresentation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {
	List<Vertex> vertices = new ArrayList<>();
	
//	public Graph addVertex(int value){
//		Vertex v = new Vertex(value);
//		vertices.add(v);
//		return this;
//	}
	
	
	public Graph addVertex(Vertex v){
		vertices.add(v);
		return this;
	}
	
	public List<Vertex> getVertices(){
		return vertices;
	}
	

	
//	public Graph addEdge(int value1, int value2){
//		Vertex v1 = new Vertex(value1);
//		Vertex v2 = new Vertex(value2);
//		v1.addAdjacentVertex(v2);
//		v2.addAdjacentVertex(v1);
//		return this;
//	}
	
	public Graph addEdge(Vertex v1, Vertex v2){
		if(!vertices.contains(v1)){
			addVertex(v1);
		}
		if(!vertices.contains(v2)){
			addVertex(v2);
		}
		v1.addAdjacentVertex(v2);
		v2.addAdjacentVertex(v1);
		return this;
	}
	

	
    public boolean areAdjacent(Vertex v1, Vertex v2){
    	if(v1.getAdjacentList().contains(v2)){
    		return true;
    	}
    	return false;
    }
    
    public List<Vertex> getAdjacentVertices(Vertex v1){
    	return v1.getAdjacentList();
    }
    
    public Graph removeVertex(Vertex v){
    	for(Vertex v1 : v.adjacentList){
    		v1.removeAdjacentVertex(v);
    	}
    	vertices.remove(v);
    	return this;
    }
    
    public void DFS(Vertex v){
    	DFS(v, new HashSet<Vertex>());
    }
    
    private void DFS(Vertex v, Set<Vertex> visitedVertices){
    	System.out.println(v.getValue());
    	visitedVertices.add(v);
    	for(Vertex v1: v.getAdjacentList()){
    		if(!visitedVertices.contains(v1)){
    			DFS(v1, visitedVertices);
    		}
    	}
    	
    }
    
    public void BFS(Vertex v){
    	List<Vertex> queue = new ArrayList<>();
    	queue.add(v);
    	for(int i=0;i<queue.size() ; i++){
    		Vertex v1 = queue.get(i);
    		int j = queue.size();
    		System.out.println(v1.getValue());
    		for(Vertex v2 : v1.getAdjacentList()){
    			if(!queue.contains(v2)){
    				queue.add(j, v2);
    				j++;
    			}
    		}
    	}
    }


}
