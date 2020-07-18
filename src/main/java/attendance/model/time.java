package attendance.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class time {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	Timestamp tm;
	
	
	public time() {
		super();
	}
	public time(Integer id, Timestamp tm) {
		super();
		this.id = id;
		this.tm = tm;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Timestamp getTm() {
		return tm;
	}
	public void setTm(Timestamp tm) {
		this.tm = tm;
	}
	
}

