package attendance.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import attendance.dao.PunchDao;
import attendance.model.MemberBean;
import attendance.model.Punch;
import attendance.service.PunchService;

@Transactional
@Service
@EnableTransactionManagement
public class PunchServiceImpl implements PunchService {
    
	@Autowired
    PunchDao dao;

	@Override
	public List<Punch> getPunchTime() {
		return dao.getPunchTime();
	}
 
	@Override
	public void punchWorkOn() {
    	dao.punchWorkOn();
	}

	@Override
	public void punchWorkOff(Timestamp punchWorkOn) {
    	dao.punchWorkOff(punchWorkOn);
    }

	@Override
	public Timestamp getWorkOnTime() {
    	return dao.getWorkOnTime();
    }

	@Override
	public List<Punch> queryPunchTime(int memberNumber, String selectdate) {
		return dao.queryPunchTime(memberNumber, selectdate);
	}
	
	@Override
	public List<MemberBean> getAllMember(){
		return dao.getAllMember();
	}
    
	@Override
	public int savePunchTime(Punch punch) {
		int n = dao.savePunchTime(punch);
		return n;
		
	}
	
	@Override
	public Punch editPunchtimeFromPunchId(int punchId) {
		return dao.editPunchtimeFromPunchId(punchId);
	}
	
	@Override
	public void updatePunchTime(Punch punch) {
		dao.updatePunchTime(punch);
	}

	@Override
	public void deletePunchTimeByPunchId(int key) {
		dao.deletePunchTimeByPunchId(key);
	}
}
