package domain;

public class Dsigner extends Programmer{
	private double bonus;


	



	public double getBonus() {
		return bonus;
	}



	public void setBonus(double bonus) {
		this.bonus = bonus;
	}



	public Dsigner() {
		super();
	}



	public Dsigner(int id, String name, int age, double salary, Equipment equipment, double bonus) {
		super(id, name, age, salary, equipment);
		this.bonus = bonus;
	}
	
	@Override
	public String toString() {
		return getDetails() + "\tDesigner\t" + getStatus() + "\t" + bonus + "\t\t" + getEquipment().getDescription();
	}
	
	public String getDetailsForTeam() {
		return getMemerid() + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary() + "\tDesigner\t" + getBonus();
	}
}
