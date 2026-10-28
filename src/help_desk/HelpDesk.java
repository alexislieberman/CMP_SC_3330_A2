package help_desk;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class HelpDesk {
	Map<Integer, SupportRequest> requestsByID = new HashMap<>();
	Map<Technician, List<SupportRequest>> assignments = new HashMap<>();
	
	public void addRequest(SupportRequest request) {

	}
	
	//public SupportRequest findRequest(int id) {
		
	//}
	
	public void assignRequest(Technician technician, int requestID) {
		return;
		//same report to same technician more than once?
		//multiple technicians?
	}
	
	public int resolveRequest(Technician technician, int requestID) {
		return 1;
	}
	
	public void printAllRequests() {
		return;
	}
	
	public void printAssignemnetsFor(Technician technician) {
		return;
	}
}
