package a7;

public interface Vertex extends Comparable<Vertex>{

	Vertex getPathFromSource();
	void setPathFromSource(Vertex v);
	default void clearPathToSource() {
		setPathFromSource(null);
	}
	boolean hasPathFromSource();
	
	int getPathWeight();
	
	void setPathWeight(int length);
	
	void setProcessed();
	
	boolean hasProcessed();
	
	
}
