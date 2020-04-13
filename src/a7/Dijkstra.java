package a7;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Dijkstra {

	public static Map<Vertex, List<DirectedEdge>> SSSP(DirectedGraph g, Vertex src) {
		Map<Vertex, List<DirectedEdge>> result = new HashMap<Vertex, List<DirectedEdge>>();
		Set<Vertex> vertex_set = g.getVertices();
		for(Vertex v : vertex_set) {
			v.clearPathToSource();
		}
		
		src.setPathFromSource(src);
		
		Queue<Vertex> pq = new PriorityQueue<Vertex>();
		pq.add(src);
		src.setPathWeight(0);
		result.put(src, new LinkedList<DirectedEdge>());
		
		while(pq.size()>0) {
			Vertex next = pq.remove();
			if(!next.hasProcessed()) {
				next.setProcessed();
				Vertex[] adj_vertices = g.getAdjacent(next);
				for(Vertex v : adj_vertices) {
					if(next.getPathWeight()+g.findEdge(next, v).getWeight() < v.getPathWeight()) {
						v.setPathFromSource(next);
						v.setPathWeight(next.getPathWeight()+g.findEdge(next, v).getWeight());
						if(!v.hasProcessed()) {
							pq.add(v);
						}
					}

				}
			}

		}
		
		for(Vertex v : vertex_set) {
			if(v.hasPathFromSource() && v != src) {
				Vertex current = v;
				Vertex previous = v.getPathFromSource();
				result.put(v, new LinkedList<DirectedEdge>());
				while(previous.hasPathFromSource()) {
					result.get(v).add(0, g.findEdge(previous, current));
					current = current.getPathFromSource();
					if(previous != src) {
						previous = previous.getPathFromSource();
					}
					else {
						break;
					}
				}
			}
		}
		
		return result;
	}
}
