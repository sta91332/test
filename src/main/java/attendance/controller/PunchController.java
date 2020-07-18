package attendance.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import attendance.model.MemberBean;
import attendance.model.Punch;
import attendance.service.PunchService;

@Controller
@RequestMapping(value ="attendance/punch/")
@SessionAttributes({"punch"})
public class PunchController {
	public PunchController() { }

	@Autowired
	PunchService service;
	
	@Autowired
	ServletContext ctx;

	
	@GetMapping("/punchWorkOn")
	public String punchWorkOn(Model model) {
		service.punchWorkOn();
		return "redirect:/punchlist";
	}
	
	@GetMapping("/punchWorkOff")
	public String punchWorkOff(Model model) {
		Timestamp punchWorkOn = service.getWorkOnTime();
		if(punchWorkOn != null){
			service.punchWorkOff(punchWorkOn);
		}
		return "redirect:/punchlist";
	}
	
	@GetMapping("/workOnTime")
	public String WorkOnTime(Model model) {
		Timestamp workOnTime = service.getWorkOnTime();
		model.addAttribute("time", workOnTime);
		return "attendance/punch/punch";
	}
	
	@GetMapping(value="/insertPunchTime", produces= {"text/html"})
	public String insertPunchTime(Model model) {
		model.addAttribute("punch", new Punch());
		return "attendance/punch/insertPunchTime";
	}
	
	@PostMapping(value = "/saveInsertPunchTime", consumes = "application/x-www-form-urlencoded")   
	public String saveInsertPunchTime(@ModelAttribute("punch") Punch punch, BindingResult bindingResult) {
		int n = service.savePunchTime(punch);
		if (n==1) {
			return "redirect:/attendance/punch/queryPunchTime";
		} else {
			FieldError error = new FieldError("punch", "punchDate",punch.getPunchDate(), false, null, null,  (n==-1 ? "日期重複" : "資料庫錯誤"));
			bindingResult.addError(error);
			return "attendance/punch/insertPunchTime";
		}
	}
	
	@GetMapping("/queryPunchTime")
	public String  getQueryPunchTime()  {
		return "attendance/punch/queryPunchTime";
	}
	
	@GetMapping("/getAllMember")
	public ResponseEntity<List<MemberBean>>  getAllMember(){
		List<MemberBean> list = service.getAllMember();
		ResponseEntity<List<MemberBean>> re = new ResponseEntity<>(list, HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/queryPunchTimeData")
	public ResponseEntity<Map<String, Object>> queryPunchTime(
			@RequestParam(value="memberNumber", defaultValue = "0") int memberNumber,
			@RequestParam(value="selectdate", defaultValue = "0-0") String selectdate ){ 
		List<Punch> listTarget = service.queryPunchTime(memberNumber, selectdate);
		Map<String, Object> map =  new HashMap<>();
		map.put("punchtimes", listTarget);
		
		ResponseEntity<Map<String, Object>> re = new ResponseEntity<>(map, HttpStatus.OK);
		return re;
	}
	

	@GetMapping(value="/punchTimeEdit/{punchId}", produces= {"text/html"})
	public String editPunchtimeFromPunchId(@PathVariable Integer punchId, Model model) {
		Punch punch = service.editPunchtimeFromPunchId(punchId);
		model.addAttribute(punch);
		return "attendance/punch/updatePunchTime";
	}
	
	@PutMapping("/punchTime/update/{key}")   
	public String updatePunchTime(
			@PathVariable Integer key, Punch punch) {
		service.updatePunchTime(punch);
		System.out.println("hi");
		return "redirect:/punch";
	}

	@DeleteMapping("/punchTime/update/{key}")
	public String deletePunchTime(@PathVariable Integer key, Model model, HttpServletRequest req) {
		service.deletePunchTimeByPunchId(key);
		return "redirect:/punch";
	}
	
	@ModelAttribute("punch")
	public Punch createAttribute(Model model) {
		Punch punch = new Punch();
		return punch;
	}
}
