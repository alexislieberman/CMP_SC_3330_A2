package help_desk;
import java.util.List;

public class HelpDeskUtil {
	public static <T> void printAll(List<T> items){
		for (T item : items)
            System.out.println(item.toString());
	}
	
	public static int sumPoints(List<? extends Technician> technicians) {
		int total = 0;
		
		for (Technician tech : technicians) 
			total += tech.getServicePoints();
		
		return total;
	}
}
