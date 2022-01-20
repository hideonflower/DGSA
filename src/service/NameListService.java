package service;

import java.security.CodeSigner;

import domain.Architect;
import domain.Dsigner;
import domain.Employee;
import domain.Equipment;
import domain.NoteBook;
import domain.PC;
import domain.Printer;
import domain.Programmer;
import service.Data;

public class NameListService {
	private Employee[] employees;
	
	public NameListService() {
		employees = new Employee[Data.EMPLOYEES.length];
		for(int i = 0; i < employees.length; i++) {
			int type = Integer.parseInt(Data.EMPLOYEES[i][0]);
			
			int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
			String name = Data.EMPLOYEES[i][2];
			int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
			double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);
			Equipment equipment;
			double bonus = 0.0;
			int stock = 0;
					
			switch(type) {
			case Data.EMPLOYEE:
				employees[i] = new Employee(id, name, age, salary);
				break;
			case Data.PROGRAMMER:
				equipment = createEquipment(i);
				employees[i] = new Programmer(id, name, age, salary, equipment);
				break;
			case Data.DESIGNER:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
				employees[i] = new Dsigner(id, name, age, salary, equipment, bonus);
				break;
			case Data.ARCHITECT:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
				stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
				employees[i] = new Architect(id,name, age, salary, equipment, bonus, stock);
				break;
			}
		}
	}
	
	public Employee[] getAllEmployees() {
		return employees; 
	}
	
	public Employee getEmployee(int id) throws TeamException {
		for(int i = 0; i < employees.length; i++) {
			if (employees[i].getId() == id) {
				return employees[i];
			}
		}
		throw new TeamException("Can't find employee");
	}
	
	private Equipment createEquipment(int index) {
		int type = Integer.parseInt(Data.EQUIPMENTS[index][0]);
		String model = Data.EQUIPMENTS[index][1];
		switch(type) {
		case Data.PC:
			String display = Data.EQUIPMENTS[index][2];
			return new PC(model,display);
		case Data.NOTEBOOK:
			double price = Double.parseDouble(Data.EQUIPMENTS[index][2]);
			return new NoteBook(model, price);
		case Data.PRINTER:
			String printerType = Data.EQUIPMENTS[index][2];
			return new Printer(model, printerType);
		}
		return null;
	}
	
}
