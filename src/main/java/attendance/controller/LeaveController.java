package attendance.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import attendance.dao.impl.LeaveDaoImpl;
import attendance.model.Leave;
import attendance.model.MemberBean;

@Controller
@RequestMapping(value ="attendance/leave/")
@SessionAttributes({"leave"})
public class LeaveController {
	public LeaveController() { }

	@Autowired
	LeaveDaoImpl service;
	
	@Autowired
	ServletContext ctx;
	
	@GetMapping(value="/insertLeave", produces= {"text/html"})
	public String insertPunchTime(Model model) {
		model.addAttribute("leave", new Leave());
		return "attendance/leave/insertLeave";
	}

	@PostMapping(value = "/saveInsertLeave", consumes = "application/x-www-form-urlencoded")
	public String saveInsertPunchTime(@ModelAttribute("leave") Leave leave, BindingResult bindingResult) {
		int n = service.saveLeave(leave);
		if (n == 1) {
			return "redirect:attendance/leave/queryLeave";
		} else {
			FieldError error = new FieldError("punch", "punchDate",leave.getLeaveDate(), false, null, null,  (n==-1 ? "日期重複" : "資料庫錯誤"));
			bindingResult.addError(error);
			return "attendance/leave/insertLeave";
		}
	}
	
	@GetMapping("/queryLeave")
	public String  getQueryLeave()  {
		return "attendance/leave/queryLeave";
	}
	
	@GetMapping("/getAllMember")
	public ResponseEntity<List<MemberBean>>  getAllMember(){
		System.out.println("-----------------------SSSSS");
		List<MemberBean> list = service.getAllMember();
		ResponseEntity<List<MemberBean>> re = new ResponseEntity<>(list, HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/queryLeaveData")
	public ResponseEntity<List<Leave>> getLeaveData(
			@RequestParam(value="memberNumber", defaultValue = "0") int memberNumber,
			@RequestParam(value="selectdate", defaultValue = "0") String selectdate ){ 
		List<Leave> listTarget = service.queryLeave(memberNumber, selectdate);
		
		ResponseEntity<List<Leave>> re = new ResponseEntity<>(listTarget, HttpStatus.OK);
		return re;
	}
	
	
}
