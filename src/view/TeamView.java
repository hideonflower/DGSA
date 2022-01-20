package view;

import domain.Employee;
import domain.Programmer;
import junit.framework.TestSuite;
import service.NameListService;
import service.TeamException;
import service.TeamService;

public class TeamView {
	private NameListService listSvc = new NameListService();
	private TeamService teamSvc = new TeamService();
	
	public void enterMainMenu() {
		boolean loopFlag = true;
		char menu = 0;
		while(loopFlag) {
			if(menu != '1') {
				listAllEmployees();
			}
			 
			System.out.print("1-Group 2-Add group member 3-delete group member 4-logout Please enter(1-4): ");
			menu = TSUtility.readMenuSelection();
			switch(menu) {
			case '1':
				getTeam();
				break;
			case '2':
				addMember();
				break;
			case '3':
				deleteMember();
				break;
			case '4':
				System.out.println("Confirm to logout(Y/N): ");
				char isExit = TSUtility.readConfirmSelection();
				if(isExit == 'Y') {
					loopFlag = false;
				} 
				break;
			}
		}
	}
	
	private void listAllEmployees() {
		System.out.println("--------Develop Group schedule App-----------------\n");
		
		Employee[] employees = listSvc.getAllEmployees();
		if(employees == null || employees.length == 0) {
			System.out.println("No information in company");
		}else {
			System.out.println("ID\tName\tAge\tSalary\tPosition\tStatus\tBonus\tStock\tEquipment");
			
			for(int i = 0; i<employees.length;i++) {
				System.out.println(employees[i]);
			}
		}
	}
	
	private void getTeam() {
		System.out.println("--------Group Member List-----------------\n");
		
		Programmer[] team = teamSvc.getTeam();
		if(team == null || team.length == 0) {
			System.out.println("No Group Member");
		} else {
			System.out.println("TID/ID\tName\t\tAge\tSalary\tPosition\tBonus\tStock");
			for(int i=0; i<team.length; i++) {
				System.out.println(team[i].getDetailsForTeam());
			}
		}
		System.out.println("-----------------------------");
		
	}
	
	private void addMember() {
		System.out.println("------------------Add member----------");
		System.out.println("Please enter employee's ID");
		int id = TSUtility.readInt();
		
		try {
			Employee emp = listSvc.getEmployee(id);
			teamSvc.addMember(emp);
			System.out.println("Add successfully!");
			TSUtility.readReturn();
		} catch(TeamException e) {
			System.out.println("Failed to add, because "+ e.getMessage());
		}
		TSUtility.readReturn();
	}
	
	private void deleteMember() {
		
	}
	
	public static void main(String[] args) {
		TeamView view = new TeamView();
		view.enterMainMenu();
	}
}
