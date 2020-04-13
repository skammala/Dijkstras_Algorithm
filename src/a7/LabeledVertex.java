package a7;

public class LabeledVertex implements Vertex {

	private String _label;
	private Vertex _path_from_source;
	private int _path_weight;
	private boolean hasProcessed = false;
	
	public LabeledVertex(String label) {
		if (label == null) {
			throw new IllegalArgumentException();
		}
		
		_label = label;		
		_path_from_source = null;
		_path_weight = Integer.MAX_VALUE;
	}
	
	@Override
	public String toString() {
		return _label;
	}
	
	public String getLabel() {
		return _label;
	}

	@Override
	public Vertex getPathFromSource() {
		if (_path_from_source == null) {
			throw new RuntimeException("No path from source");
		}
		
		if (_path_from_source == this) {
			// Null result used to indicate we are at the source.
			return null;
		}
		
		return _path_from_source;
	}

	@Override
	public void setPathFromSource(Vertex v) {
		_path_from_source = v;		
	}

	@Override
	public boolean hasPathFromSource() {
		return _path_from_source != null;
	}

	@Override
	public int getPathWeight() {
		return _path_weight;
	}

	@Override
	public void setPathWeight(int length) {
		_path_weight = length;
		
	}
	
	public void setProcessed() {
		hasProcessed = true;
	}

	public boolean hasProcessed() {
		return hasProcessed;
	}

	@Override
	public int compareTo(Vertex other) {
		if (this.getPathWeight() > other.getPathWeight()) {
			return 1;
		}
		else if (this.getPathWeight() < other.getPathWeight()) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
}
