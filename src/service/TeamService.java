package service;

import java.beans.DesignMode;

import domain.Architect;
import domain.Dsigner;
import domain.Employee;
import domain.Programmer;

/**
 * 
 * @author aaa
 *
 */
public class TeamService {
	private static int counter = 1; // 给member id赋值
	private final int MAX_MEMBER = 5; // 限制开发团队人数
	private Programmer[] team = new Programmer[MAX_MEMBER]; // 保存开发团队成员
	private int total; // 用来记录开发团队中实际的人数
	public TeamService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Programmer[] getTeam() {
		Programmer[] team = new Programmer[total];
		for(int i = 0; i<total; i++) {
			team[i] = this.team[i];
		}
		return team;
	}
	
	public void addMember(Employee e) throws TeamException {
		if(total >= MAX_MEMBER) {
			throw new TeamException("full capacity, failed to add new member");
		}
		if(!(e instanceof Programmer)) {
			throw new TeamException("this person is not our develop member, failed to add");
		}
		if(isExist(e)) {
			throw new TeamException("this person is in the develop group");
		}
		
		Programmer p = (Programmer)e;
		if("BUSY".equalsIgnoreCase(p.getStatus().getNAME())) {
			throw new TeamException("this person is in other group");
		} else if ("VOCATION".equalsIgnoreCase(p.getStatus().getNAME())) {
			throw new TeamException("this person is in vovation, failed to add");
		}
		
		int countA=0, countD=0, countP=0;
		for(int i = 0; i<total; i++	) {
			if(this.team[i] instanceof Architect) {
				countA++;
			} else if (this.team[i] instanceof Dsigner) {
				countD++;
			} else if (this.team[i] instanceof Programmer) {
				countP++;
			}
		}
		if(e instanceof Architect) {
			if(countA >= 1) {
				throw new TeamException("Maximun one Architect");
			}
		} else if(e instanceof Dsigner) {
			if(countD >= 2) {
				throw new TeamException("Maximun two Dsigner");
			}
		} else if(e instanceof Programmer) {
			if(countP >= 3) {
				throw new TeamException("Maximum three Programmer");
			}
		}
		
		this.team[total] = p;
		total++;
		
		p.setStatus(Status.BUSY);
		p.setMemerid(counter++);
	}
	
	private boolean isExist(Employee e) {
		for(int i = 0; i<total; i++) {
			if(e.getId() == this.team[i].getId()) {
				return true;
			}
		}
		return false;
	}
	
	public void removerMember(int memberId) throws TeamException {
		//遍历看是否能找到这个人
		int i=0;
		for(; i<total; i++) {
			if(team[i].getMemerid() == memberId) {
				team[i].setStatus(Status.FREE);
				break;
			}
		}
		//没有找到人的情况
		if(i == total) {
			throw new TeamException("cant find this person, failed to add");
		}
		//找到人的情况
		for(int j = i+1; j<total; j++) {
			team[j-1] = team[j];
		}
		
		team[total-1] = null;
		total--;
	}
}
