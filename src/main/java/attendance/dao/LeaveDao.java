package attendance.dao;

import java.util.List;

import attendance.model.Leave;
import attendance.model.MemberBean;

public interface LeaveDao {

	List<Leave> getLeave();

	int saveLeave(Leave leave);
	
	boolean isMemberExist(Leave leave);
	
	List<Leave> queryLeave(int memberNumber, String selectdate);

	List<MemberBean> getAllMember();

	Leave editLeaveFromLeaveId(int leaveId);

	void updateLeave(Leave leave);

	void deleteLeaveByLeaveId(int key);
}
