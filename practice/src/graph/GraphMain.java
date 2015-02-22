package graph;

public class GraphMain {

	public static void main(String[] args) {
		Graph graph = new Graph();
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);
	
		
		graph.addEdge(v1, v2).addEdge(v1, v3).addEdge(v2,  v3).addEdge(v3,  v4).addEdge(v4,  v5).addEdge(v1, v5);
		
		for(Vertex v : graph.getVertices()){
			System.out.println(v.getValue()+ "-"+v.getAdjacentListValues().toString());
		}
		
		graph.DFS(v1);
		
		graph.BFS(v1);
		
		

	}

}
