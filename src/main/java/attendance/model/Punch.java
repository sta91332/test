package attendance.model;


import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Punch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer punchId;
	Integer memberNumber;
	String memberName;
	String memberDepartment;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date punchDate;
//   @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	Timestamp punchWorkOn;
	String punchLate;
//	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	Timestamp punchWorkOff;
	String punchEarly;
	
	
	
	public Punch() {
		super();
	}
	
	public Punch(Integer punchId, String memberName, String memberDepartment,Integer memberNumber,Date punchDate, Timestamp punchWorkOn, Timestamp punchWorkOff) {
		super();
		this.punchId = punchId;
		this.memberName = memberName;
		this.memberDepartment = memberDepartment;
		this.memberNumber = memberNumber;
		this.punchDate = punchDate;
		this.punchWorkOn = punchWorkOn;
		this.punchWorkOff = punchWorkOff;
	}

	public Punch(Integer memberNumber, String memberName, String memberDepartment, int punchId, Date punchDate,
			Timestamp punchWorkOn, Timestamp punchWorkOff, String punchLate, String punchEarly) {
		super();
		this.memberNumber = memberNumber;
		this.memberName = memberName;
		this.memberDepartment = memberDepartment;
		this.punchId = punchId;
		this.punchDate = punchDate;
		this.punchWorkOn = punchWorkOn;
		this.punchWorkOff = punchWorkOff;
		this.punchLate = punchLate;
		this.punchEarly = punchEarly;
	
		
}

	public Integer getPunchId() {
		return punchId;
	}

	public void setPunchId(Integer punchId) {
		this.punchId = punchId;
	}

	public Integer getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(Integer memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberDepartment() {
		return memberDepartment;
	}

	public void setMemberDepartment(String memberDepartment) {
		this.memberDepartment = memberDepartment;
	}

	public Date getPunchDate() {
		return punchDate;
	}

	public void setPunchDate(Date date) {
		this.punchDate = date;
	}

	public Timestamp getPunchWorkOn() {
		return punchWorkOn;
	}

	public void setPunchWorkOn(Timestamp punchWorkOn) {
		this.punchWorkOn = punchWorkOn;
	}

	public String getPunchLate() {
		return punchLate;
	}

	public void setPunchLate(String punchLate) {
		this.punchLate = punchLate;
	}

	public Timestamp getPunchWorkOff() {
		return punchWorkOff;
	}

	public void setPunchWorkOff(Timestamp punchWorkOff) {
		this.punchWorkOff = punchWorkOff;
	}

	public String getPunchEarly() {
		return punchEarly;
	}

	public void setPunchEarly(String punchEarly) {
		this.punchEarly = punchEarly;
	}
	
}