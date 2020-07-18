package attendance.service;

import java.util.List;

import attendance.model.Leave;
import attendance.model.MemberBean;

public interface LeaveService {
	
	List<Leave> getLeave();
	
	List<Leave> queryLeave(int memberNumber, String selectdate) ;

	List<MemberBean> getAllMember();

	Leave editLeaveFromLeaveId(int leaveId);

	void updateLeave(Leave leave);

	void deleteLeaveByLeavehId(int key);

	int saveLeave(Leave leave);

}
