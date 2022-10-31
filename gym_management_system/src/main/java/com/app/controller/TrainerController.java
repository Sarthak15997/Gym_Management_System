package com.app.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Address;
import com.app.pojos.Diet;
import com.app.pojos.Excercise;
import com.app.pojos.Member;
import com.app.pojos.Trainer;
import com.app.service.IDietService;
import com.app.service.ILoginService;
import com.app.service.IMemberService;
import com.app.service.IRegisterService;
import com.app.service.ITrainerService;

@Controller
@RequestMapping("/trainer")
public class TrainerController {

	@Autowired
	private ILoginService loginService;
	@Autowired
	private IRegisterService registerService;
	@Autowired
	private IMemberService memberService;
	@Autowired
	private IDietService dietService;
	@Autowired
	private ITrainerService trainerService;

	public TrainerController() {
		System.out.println("in trainer Controller" + getClass().getName());
	}

	@GetMapping("/login")
	public String showAdminLogin() {
		System.out.println("Show trainner Login");
		return "/trainer/login";
	}

	@PostMapping("/login")
	public String processTrainnerLogin(@RequestParam String email, @RequestParam String password, HttpSession hs,
			RedirectAttributes flashMap, Model modelMap) {
		System.out.println("trainer login details " + email + " " + password);
		try {
			Trainer trainer = loginService.validateTrainer(email, password);
			String status = "NEW";
			hs.setAttribute("trainerDetails", trainer);
			if (trainer.getStatus().equals(status))
				return "redirect:/trainer/change_password";
			else {
				hs.setAttribute("trainerDetails", trainer);
				return "redirect:/trainer/trainer_dashboard";
			}

		} catch (RuntimeException e) {
			modelMap.addAttribute("message", "Invalid Email Password Try Again");
			return "/trainer/login";
		}
	}

	@GetMapping("/change_password")
	public String showChangePassword() {
		System.out.println("show change Password");
		return "/trainer/change_password";
	}

	@PostMapping("/change_password")
	public String changeTrainerPassword(@RequestParam String npassword, @RequestParam String cpassword, HttpSession hs,
			RedirectAttributes flashMap, Model modelMap) {
		System.out.println("change password Details " + npassword + " " + cpassword);
		Trainer trainer = (Trainer) hs.getAttribute("trainerDetails");
		if (trainer == null) {
			return "/trainer/login";
		} else {
			if (npassword.equals(cpassword)) {
				flashMap.addFlashAttribute("message", registerService.changePassword(trainer.getId(), cpassword));
				hs.setAttribute("trainerDetails", trainer);
				return "redirect:/trainer/trainer_dashboard";
			} else {
				modelMap.addAttribute("message", "password not matched");
				return "/trainer/change_password";
			}
		}
	}

	@GetMapping("/trainer_dashboard")
	public String showTrainerDashboard() {
		return "/trainer/trainer_dashboard";
	}

	@GetMapping("/add_diet")
	public String showAddDiet(Model modelMap, HttpSession hs) {
		Trainer trainer = (Trainer) hs.getAttribute("trainerDetails");
		if (trainer != null) {
			modelMap.addAttribute("memberList", memberService.fetchAllMember(trainer));
			return "/trainer/add_diet";
		} else {
			modelMap.addAttribute("message", "some Error Occoured");
			return "/trainer/add_diet";
		}
	}

	@PostMapping("/add_diet")
	public String saveDietInformation(@RequestParam String member, @RequestParam String forDate,
			@RequestParam String breakFast, @RequestParam String lunch, @RequestParam String eveningSnacks,
			@RequestParam String dinner, RedirectAttributes flashMap, Model modelMap, HttpSession hs) {
		System.out.println("in save diet ");
		Diet diet = new Diet(breakFast, lunch, eveningSnacks, dinner, LocalDate.now(), LocalDate.parse(forDate));
		try {
			flashMap.addFlashAttribute("message", dietService.saveDiet(diet, member));
			return "redirect:/trainer/trainer_dashboard";

		} catch (RuntimeException e) {
			modelMap.addAttribute("message", "some Error Occourd");
			return "/trainer/add_diet";
		}
	}

	@GetMapping("/member_registration")
	public String showMember_registration() {
		return "/trainer/member_registration";
	}

	@PostMapping("/member_registration")
	public String processMemberRegistration(@RequestParam String firstName, @RequestParam String middleName,
			@RequestParam String lastName, @RequestParam String email, @RequestParam String mobileNo,
			@RequestParam String city, @RequestParam String state, @RequestParam String district,
			@RequestParam String addLine1, @RequestParam String addLine2, @RequestParam String country,
			@RequestParam String pincode, @RequestParam String dateOfBirth, @RequestParam String gender,
			@RequestParam String height, @RequestParam String weight, @RequestParam String startTime,
			@RequestParam String endTime, @RequestParam MultipartFile image, @RequestParam String trainer,
			Model modelMap, RedirectAttributes flashMap, HttpSession hs) throws IOException {
		Address address = new Address(city, state, district, addLine1, addLine2, country, Integer.valueOf(pincode));
		String name = firstName + " " + middleName + " " + lastName;
		byte[] imageFile = image.getBytes();

		Member member = new Member(name, LocalDate.parse(dateOfBirth), gender, Double.valueOf(height),
				Double.valueOf(weight), mobileNo, email, "gym_member", imageFile, startTime, endTime, LocalDate.now());
		try {
			flashMap.addFlashAttribute("message", registerService.registerMember(address, member, trainer));
			return "redirect:/trainer/trainer_dashboard";
		} catch (RuntimeException e) {
			modelMap.addAttribute("message", "some error occured At member Registration");
			return "/trainer/member_registration";
		}
	}

	@GetMapping("/show_details")
	public String showMember(HttpSession hs, Model modelMap, RedirectAttributes flashMap) {
		Trainer t = (Trainer) hs.getAttribute("trainerDetails");
		try {
			hs.setAttribute("memberList", memberService.fetchAllMember(t));
			return "redirect:/trainer/member_details";
		} catch (RuntimeException e) {
			modelMap.addAttribute("message", "You Dont Have Members yet");
			return "/trainer/member_details";
		}
	}

	@GetMapping("/member_details")
	public String showMemberDetails() {
		return "/trainer/member_details";
	}

	@GetMapping("/member_delete")
	public String processMemberDelete(@RequestParam int mid, RedirectAttributes flashMap, Model modelMap,
			HttpSession hs) {
		try {
			flashMap.addFlashAttribute("message", memberService.deleteMember(mid));
			return "redirect:/trainer/show_details";
		} catch (RuntimeException e) {
			hs.setAttribute("message", "You dont have Permission to delete this Member");
			return "redirect:/trainer/show_details";
		}
	}

	@GetMapping("/checkDiet")
	public String showCheckDiet(HttpSession hs) {
		Trainer t = (Trainer) hs.getAttribute("trainerDetails");
		hs.setAttribute("memberList", memberService.fetchAllMember(t));
		return "/trainer/checkDiet";
	}

	@PostMapping("/searchDiet")
	public String processSearch(@RequestParam int member, RedirectAttributes flashMap, Model modelMap) {
		try {
			flashMap.addFlashAttribute("dietInfoUser", dietService.searchDiet(member));
			return "redirect:/trainer/checkDiet";
		} catch (RuntimeException e) {
			modelMap.addAttribute("message", "some Error Occoured");
			return "/trainer/checkDiet";
		}
	}

	@GetMapping("/addExcercise")
	public String showExcercise(HttpSession hs) {
		hs.setAttribute("excerciseList", trainerService.fetAllExcercise());
		return "/trainer/addExcercise";
	}

	@PostMapping("/addExcercise")
	public String processAddExcercise(@RequestParam String title, @RequestParam MultipartFile image,
			RedirectAttributes flashMap, Model modelMap, HttpSession hs,HttpServletRequest request,HttpServletResponse resp) throws IOException {
		try {
			byte[] imageFile = image.getBytes();
			Excercise e = new Excercise(title, imageFile);
			flashMap.addFlashAttribute("message", trainerService.addExcercise(e));
			resp.setHeader("refresh", "1;url=" + request.getContextPath() + "/trainer/addExcercise");
			return "/trainer/addExcercise";
		} catch (RuntimeException e) {
			modelMap.addAttribute("message", "Some Error Occoured");
			resp.setHeader("refresh", "1;url=" + request.getContextPath() + "/trainer/addExcercise");
			return "/trainer/addExcercise";
		}
	}
	@GetMapping("/deleteExcercise")
	public String processDelete(@RequestParam int eid,Model modelMap,RedirectAttributes flashMap,HttpServletRequest request,HttpServletResponse resp) {
		try {
			flashMap.addFlashAttribute("message", trainerService.deleteExcercise(eid));
			resp.setHeader("refresh", "1;url=" + request.getContextPath() + "/trainer/addExcercise");
			return "/trainer/addExcercise";
		} catch (RuntimeException e) {
			modelMap.addAttribute("message", "Some Error Occoured");
			resp.setHeader("refresh", "1;url=" + request.getContextPath() + "/trainer/addExcercise");
			return "/trainer/addExcercise";
		}
	}
	
}
