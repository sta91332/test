package attendance.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer memberId;
	Integer memberNumber;
	String memberName;
	String memberDepartment;
	
	public Member() {
		super();
	}
	public Member(Integer memberId, Integer memberNumber, String memberName, String memberDepartment) {
		super();
		this.memberId = memberId;
		this.memberNumber = memberNumber;
		this.memberName = memberName;
		this.memberDepartment = memberDepartment;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer punchId) {
		this.memberId = punchId;
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
	
	
}