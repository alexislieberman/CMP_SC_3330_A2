package help_desk;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class HelpDesk {
	private final Map<Integer, SupportRequest> requestsByID = new HashMap<>();
	private final Map<Technician, List<SupportRequest>> assignments = new HashMap<>();
	
	
	public void addRequest(SupportRequest request) {
		int id = request.getId();
		
		if (requestsByID.containsKey(id))
			throw new IllegalArgumentException("ID is already in use.");
		
		requestsByID.put(id, request);
	}
	
	
	public SupportRequest findRequest(int id) {
		return requestsByID.get(id);
	}
	
	
	public void assignRequest(Technician technician, int requestID) {
		SupportRequest newRequest = findRequest(requestID);
		if (newRequest == null)
			throw new IllegalArgumentException("Request does not exist.");
		
		
		if (assignments.containsKey(technician)) {
			List<SupportRequest> techRequests = assignments.get(technician);
			
			//cannot assign same request to the same technician more than once
			if (techRequests.contains(newRequest))
				throw new IllegalArgumentException("Request cannot be assigned to the same technician more than once.");
			
			techRequests.add(newRequest);
		}
		
		else {
			List<SupportRequest> newList = new ArrayList<>();
			newList.add(newRequest);
			assignments.put(technician, newList);
		}
		
	}
	
	
	
	public int resolveRequest(Technician technician, int requestID) {
		List<SupportRequest> requestsByTech = assignments.get(technician);
		SupportRequest toResolve = findRequest(requestID);
		
		if(!(requestsByTech.contains(toResolve)))
			System.out.println("That technician does not handle that request");
		else 
			toResolve.resolveFor(technician);
	
		return technician.getServicePoints();
	}
	
	
	public void printAllRequests() {
		for (Map.Entry<Integer, SupportRequest> wholeMap : requestsByID.entrySet())
            System.out.println(wholeMap.getValue().toString());
	}
	
	
	public void printAssignmentsFor(Technician technician) {
		List<SupportRequest> requestsByTech = assignments.get(technician);
		
		for (SupportRequest request : requestsByTech)
            System.out.println(request.toString());
	}
}
