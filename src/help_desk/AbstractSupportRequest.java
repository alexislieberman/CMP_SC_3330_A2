package help_desk;

public abstract class AbstractSupportRequest {
	private final int id;
	private final String title;
	private final int basePoints;
	private boolean resolved;
	
	protected AbstractSupportRequest(int id, String title, int basePoints ) {
		if (id <= 0) {
			throw new IllegalArgumentException("ID must be greater than 0. ID: " + id);	
		}
		if (title == null|| title.strip().isEmpty()) {
			throw new IllegalArgumentException("Title cann be null, empty, or blank.");
		}
		if (basePoints <= 0) {
			throw new IllegalArgumentException("Base Points must be greater than 0. Basepoint:" + basePoints);
		}
		this.id = id;
		this.title = title.strip();
		this.basePoints = basePoints;
		this.resolved = false;
	}
	
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public int getBasePoints() {
		return basePoints;
	}
	public boolean isResolved() {
		return resolved;
	}
	
	public void resolve() {
		if(this.resolved) {
			throw new IllegalStateException("Resolution faild: Request with ID" + id + "Is already resolved.");
		}
		this.resolved = true;
	}
	
	@Override
	
	public String toString() {
		return String.format("%s [ID= %d, Title=%s,BasePoints=%d,Status=%s]",
			this.getClass().getSimpleName(),
			id,title,basePoints,resolved ? "RESOLVED": "OPEN"
				);
	}
}
