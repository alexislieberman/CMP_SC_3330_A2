package help_desk;
import java.util.Objects;

public class Technician {
	private final String name;
	private int servicePoints;
	
	public Technician(String name) {
		if(name==null || name.length() == 0)
			throw new IllegalArgumentException("Name must be defined.");
		
		this.name = name;
		this.servicePoints = 0;
	} 
	
	
	public void addPoints(int amount) {
		if(amount < 0) {
			throw new IllegalArgumentException("Cannot add negative points");
		}
		servicePoints += amount;
	}
	
	
	public int getServicePoints() {
		return servicePoints;
	}
	
	@Override
	public String toString() {
		return String.format("Technician: %s has %d Service Points", name, servicePoints);
	}
	
	//overriding equals and hash code to just be equal if names are the same
	@Override 
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof Technician))
			return false;
		
		Technician other = (Technician) o;
		return Objects.equals(this.name, other.name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(name);
	}
}
