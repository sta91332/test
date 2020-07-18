package attendance.dao;

import java.sql.Timestamp;
import java.util.List;

import attendance.model.MemberBean;
import attendance.model.Punch;

public interface PunchDao {

	List<Punch> getPunchTime();
	
	void punchWorkOn();

	Timestamp getWorkOnTime();

	void punchWorkOff(Timestamp punchWorkOn);
	
	int savePunchTime(Punch punch);
	
	boolean isPunchDateMemberExist(Punch punch);
	
	List<Punch> queryPunchTime(int memberNumber, String selectdate);

	List<MemberBean> getAllMember();

	Punch editPunchtimeFromPunchId(int punchId);

	void updatePunchTime(Punch punch);

	void deletePunchTimeByPunchId(int key);


}
