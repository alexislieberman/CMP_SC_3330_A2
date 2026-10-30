package help_desk;

public abstract class AbstractSupportRequest implements SupportRequest {
	private final int id;
	private final String title;
	private final int basePoints;
	private boolean resolved;
	
	protected AbstractSupportRequest(int id, String title, int basePoints ) {
		if (id <= 0) {
			throw new IllegalArgumentException("ID must be greater than 0. ID: " + id);	
		}
		if (title == null|| title.strip().isEmpty()) {
			throw new IllegalArgumentException("Title cannot be null, empty, or blank.");
		}
		if (basePoints <= 0) {
			throw new IllegalArgumentException("Base Points must be greater than 0. Basepoint:" + basePoints);
		}
		this.id = id;
		this.title = title.strip();
		this.basePoints = basePoints;
		this.resolved = false;
	}
	
	
	@Override
	public int getId() {
		return id;
	}
	
	
	@Override
	public String getTitle() {
		return title;
	}
	
	
	@Override
	public int getBasePoints() {
		return basePoints;
	}
	
	@Override
	public boolean isResolved() {
		return resolved;
	}
	
	
	@Override
	public final int resolveFor(Technician technician) {
		if (technician == null) {
			throw new IllegalArgumentException("Technician cannot be null.");
		}
		if (this.resolved) {
			throw new IllegalStateException("Resolution failed: Request with ID " + id + " is already resolved.");
		}
		int points = calculatePoints();
		this.resolved = true;
		technician.addPoints(points);
		return points;
	}
	
	
	protected abstract int calculatePoints();
	
	@Override
	public String toString() {
		return String.format("%s [ID: %d, Title: %s, BasePoints: %d, Status: %s]",
			this.getClass().getSimpleName(),
			id,title,basePoints,resolved ? "RESOLVED": "OPEN"
				);
	}
}
