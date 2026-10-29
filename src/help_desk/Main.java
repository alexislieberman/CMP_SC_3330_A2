package help_desk;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		
	
		Technician joe = new Technician("Joe");
		Technician kyle = new Technician("Kyle");
		Technician evan1 = new Technician("Evan");
		Technician evan2 = new Technician("Evan");
		
	
		PasswordResetRequest request1 = new PasswordResetRequest(1, "Student1 new Password", 5, "account1");
		PasswordResetRequest request2 = new PasswordResetRequest(2, "Student2 new Password", 5, "account2");
		NetworkIssueRequest request3 = new NetworkIssueRequest(3, "Wifi Out in Building", 5, 200);
		NetworkIssueRequest request4 = new NetworkIssueRequest(4, "Slow Wifi in Building", 5, 450);
		DeviceSetupRequest request5 = new DeviceSetupRequest(5, "New Students", 5, 3);
		DeviceSetupRequest request6 = new DeviceSetupRequest(6, "New Faculty", 5, 7);
		
		HelpDesk helpDesk = new HelpDesk();
		helpDesk.addRequest(request1);
		helpDesk.addRequest(request2);
		helpDesk.addRequest(request3);
		helpDesk.addRequest(request4);
		helpDesk.addRequest(request5);
		helpDesk.addRequest(request6);
		
		helpDesk.assignRequest(joe, 1);
		helpDesk.assignRequest(joe, 2);
		helpDesk.assignRequest(kyle, 3);
		helpDesk.assignRequest(kyle, 4);
		helpDesk.assignRequest(evan2, 5);
		helpDesk.assignRequest(evan1, 6);

		

		helpDesk.resolveRequest(joe, 2);
		helpDesk.resolveRequest(kyle, 4);
		helpDesk.resolveRequest(evan1, 6);
		
		System.out.println("\nPrinting all requests:");
		helpDesk.printAllRequests();
		
		System.out.println("\n\nPrinting all requests for evan:");
		helpDesk.printAssignmentsFor(evan2);
		
		System.out.println("\nJoe has " + joe.getServicePoints() + " points");
		System.out.println("Kyle has " + kyle.getServicePoints() + " points");
		System.out.println("Evan has " + evan1.getServicePoints() + " points ");
		
		List<Technician> allTechs = new ArrayList<>();
		allTechs.add(joe);
		allTechs.add(evan1);
		allTechs.add(kyle);
		allTechs.add(evan2);
		
		int totalPoints = HelpDeskUtil.sumPoints(allTechs);
		System.out.println("Total Points: " + totalPoints);
		
		
		//fail-fast:
		helpDesk.addRequest(request3);
		//helpDesk.resolveRequest(joe, 2);
	}
}

