package domain;

public class Architect extends Dsigner{
	private int stock;

	
	public Architect() {
		super();
		
	}


	public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
		super(id, name, age, salary, equipment, bonus);
		this.stock = stock;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public String toString() {
		return getDetails() + "\tArchitect\t" + getStatus() + "\t" + getBonus() + "\t" + stock + "\t" + getEquipment().getDescription();
	}
	
	public String getDetailsForTeam() {
		return getMemerid() + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary() + "\tArchitect\t" + getBonus() + "\t" + getStock();
	}
}
