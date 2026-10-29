package help_desk;

public class Technician {
	private String name;
	private int servicePoints;
	
	public Technician(String name) {
		if(name==null || name.length() == 0)
			throw new IllegalArgumentException("Name must be defined.");
		
		this.name = name;
		this.servicePoints = 0;
	} 
	
	
	public void addPoints(int amount) {
		if(amount <= 0) {
			throw new IllegalArgumentException("Cannot add negative points");
		}
		servicePoints += amount;
	}
	
	
	public int getServicePoints() {
		return servicePoints;
	}
	
	//overriding equals and hash code to just be for name
	@Override 
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof Technician))
			return false;
		
		Technician other = (Technician) o;
		return this.name.equals(other.name);
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
}
