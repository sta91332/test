﻿package attendance.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Members")
public class MemberBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer memberId;//id
	String memberNumber;	//員工編號
	String memberPassword;	//密碼
//	String name ; // 員工姓名
//	String email ; //員工信箱
//	String address ; // 員工地址
//	String gender ; // 員工性別
//	Blob coverImage ;// 員工圖片
//	String filename; //檔名
	String memberName;	//員工姓名
	String memberAddress;	//地址
	String memberGender;	//性別
	String memberEmail;	//信箱
	@JsonIgnore
	Blob memberPicture1;	//大頭照1
	String memberfilename;	//檔名
	String memberDepartment;	//部門
	String memberPhone;	//電話

	String memberBirthdaay;	//生日
	Date memberRegisterDate;	//註冊日期
	String memberPerformance;	//績效
	Integer memberSalary;	//薪資

	String memberAdmin; 	//登入身分
	
	@Transient
	private MultipartFile productImage ;
	
	public MemberBean() {
		super();
	}
	
	public MemberBean(String memberNumber, String memberPassword) {
		super();
		this.memberNumber = memberNumber;
		this.memberPassword = memberPassword;
	}

	public MemberBean(Integer memberId, String memberNumber, String memberPassword, String memberName,
			String memberAddress, String memberGender, String memberEmail, Blob memberPicture1, String memberfilename,
			String memberDepartment, String memberPhone, String memberBirthdaay, Date memberRegisterDate,
			String memberPerformance, Integer memberSalary, String memberAdmin) {
		super();
		this.memberId = memberId;
		this.memberNumber = memberNumber;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberAddress = memberAddress;
		this.memberGender = memberGender;
		this.memberEmail = memberEmail;
		this.memberPicture1 = memberPicture1;
		this.memberfilename = memberfilename;
		this.memberDepartment = memberDepartment;
		this.memberPhone = memberPhone;
		this.memberBirthdaay = memberBirthdaay;
		this.memberRegisterDate = memberRegisterDate;
		this.memberPerformance = memberPerformance;
		this.memberSalary = memberSalary;
		this.memberAdmin = memberAdmin;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public Blob getMemberPicture1() {
		return memberPicture1;
	}

	public void setMemberPicture1(Blob memberPicture1) {
		this.memberPicture1 = memberPicture1;
	}

	public String getMemberfilename() {
		return memberfilename;
	}

	public void setMemberfilename(String memberfilename) {
		this.memberfilename = memberfilename;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}






	public MultipartFile getProductImage() {
		return productImage;
	}
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

	

	public String getMemberDepartment() {
		return memberDepartment;
	}

	public void setMemberDepartment(String memberDepartment) {
		this.memberDepartment = memberDepartment;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberBirthdaay() {
		return memberBirthdaay;
	}

	public void setMemberBirthdaay(String memberBirthdaay) {
		this.memberBirthdaay = memberBirthdaay;
	}

	public Date getMemberRegisterDate() {
		return memberRegisterDate;
	}

	public void setMemberRegisterDate(Date memberRegisterDate) {
		this.memberRegisterDate = memberRegisterDate;
	}

	public String getMemberPerformance() {
		return memberPerformance;
	}

	public void setMemberPerformance(String memberPerformance) {
		this.memberPerformance = memberPerformance;
	}

	public Integer getMemberSalary() {
		return memberSalary;
	}

	public void setMemberSalary(Integer memberSalary) {
		this.memberSalary = memberSalary;
	}

	public String getMemberAdmin() {
		return memberAdmin;
	}

	public void setMemberAdmin(String memberAdmin) {
		this.memberAdmin = memberAdmin;
	}

	
	


}