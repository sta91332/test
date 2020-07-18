package attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import attendance.model.Leave;
import attendance.model.Punch;
import attendance.service.LeaveService;
import attendance.service.PunchService;

@Controller
@RequestMapping
public class AttendanceController {

	@Autowired
	PunchService punchservice;
	@Autowired 
	LeaveService leaveservice;
	
	@RequestMapping("punch")
	public String punch(Model model) {
		List<Punch> list = punchservice.getPunchTime();
		model.addAttribute("punch",list);
		return "attendance/punch/punch";
	}
	
	@RequestMapping("leave")
	public String leavelist(Model model) {
		List<Leave> list = leaveservice.getLeave();
		model.addAttribute("leave",list);
		return "attendance/leave/leave";
	}
	
}
