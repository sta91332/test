package attendance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import attendance.dao.LeaveDao;
import attendance.model.Leave;
import attendance.model.MemberBean;
import attendance.service.LeaveService;

@Transactional
@Service
@EnableTransactionManagement
public class LeaveServiceImpl implements LeaveService {
    
	@Autowired
    LeaveDao dao;

	@Override
	public List<Leave> getLeave() {
		return dao.getLeave();
	}

	@Override
	public List<Leave> queryLeave(int memberNumber, String selectdate) {
		return dao.queryLeave(memberNumber, selectdate);
	}
	
	@Override
	public List<MemberBean> getAllMember(){
		return dao.getAllMember();
	}
    
	@Override
	public int saveLeave(Leave leave) {
		int n = dao.saveLeave(leave);
		return n;
		
	}
	
	@Override
	public Leave editLeaveFromLeaveId(int leaveId) {
		return dao.editLeaveFromLeaveId(leaveId);
	}
	
	@Override
	public void updateLeave(Leave leave) {
		dao.updateLeave(leave);
	}

	@Override
	public void deleteLeaveByLeavehId(int key) {
		dao.deleteLeaveByLeaveId(key);
	}
	
}
