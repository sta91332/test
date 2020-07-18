package attendance.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import attendance.dao.LeaveDao;
import attendance.model.Leave;
import attendance.model.MemberBean;

@Repository
public class LeaveDaoImpl implements LeaveDao {
	
	@Autowired
	SessionFactory factory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Leave> getLeave() {
		String hql = "FROM Leave";
		Session session = null;
		List<Leave> list = new ArrayList<>();
		session = factory.getCurrentSession();
		list = session.createQuery(hql).getResultList();
    return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MemberBean> getAllMember() {
		Session session = null;
		String hql = "FROM MemberBean";
		System.out.println(Thread.currentThread().getName());
		try {
			session = factory.getCurrentSession();
			
		} catch (Exception e) {
			session = factory.openSession();
		}
		System.out.println("-----------------------2");
		List<MemberBean> list = new ArrayList<>();
		list = session.createQuery(hql).getResultList();
		System.out.println(list);
		return list;
	}

	@Override
	public int saveLeave(Leave leave) {
		int n = 0;
		boolean exist = isMemberExist(leave);
		if (exist) {
			return -1;
		}
		Session session = factory.getCurrentSession();
		try {
			session.save(leave);
			n = 1;
		} catch (Exception e) {
			n = -2;
		}
		return n;
	}

	@Override
	public boolean isMemberExist(Leave leave) {
		boolean exist = false;
		Session session = factory.getCurrentSession();
		String hql = "FROM Leave l WHERE l.memberName=:name";
		try {
			session.createQuery(hql).setParameter("name", leave.getMemberName()).getSingleResult();
			exist = true;
		} catch (NoResultException ex) {
			;
		}
		return exist;
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<Leave> queryLeave(int memberNumber, String selectdate) {
		System.out.println(selectdate);
		String timesplit[] = selectdate.split("-");
		if (timesplit.length == 1) {
			String hql = "FROM Leave WHERE memberNumber = :number";
			Session session = factory.getCurrentSession();
			List<Leave> listTarget = session.createQuery(hql)
											.setParameter("number", memberNumber)
											.getResultList();
			return listTarget;
		} else {
			String hql = "FROM Leave WHERE memberNumber = :number and DATEPART(yyyy,punchDate) = :yyyy and DATEPART(mm,punchDate) = :mm";
			Session session = factory.getCurrentSession();
			List<Leave> listTarget = session.createQuery(hql)
											.setParameter("number", memberNumber)
											.setParameter("yyyy", timesplit[0])
											.setParameter("mm", timesplit[1])
											.getResultList();
			return listTarget;
		}
	}

	@Override
	public Leave editLeaveFromLeaveId(int leaveId) {
		Session session = factory.getCurrentSession();
		Leave leave = session.get(Leave.class, leaveId);
		return leave;
	}

	@Override
	public void updateLeave(Leave leave) {
		Session session = factory.getCurrentSession();
		session.update(leave);

	}

	@Override
	public void deleteLeaveByLeaveId(int key) {
		Session session = factory.getCurrentSession();
		Leave leave = new Leave();
		leave.setLeaveId(key);
		session.delete(leave);
	}
}
