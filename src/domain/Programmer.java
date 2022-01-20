package domain;

import service.Status;

public class Programmer extends Employee{
	private int memberid;
	private Status status = Status.FREE;
	private Equipment equipment;
	public Programmer() {
		super();
	}
	public Programmer(int id, String name, int age, double salary, Equipment equipment) {
		super(id, name, age, salary);
		this.equipment = equipment;
	}
	public int getMemerid() {
		return memberid;
	}
	public void setMemerid(int memerid) {
		this.memberid = memerid;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	
	@Override
	public String toString() {
		return getDetails() + "\tProgrammer\t" + status + "\t\t\t" + equipment.getDescription();
	}
	
	public String getDetailsForTeam() {
		return memberid + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary() + "\t" +
			   getStatus();
	}
}
