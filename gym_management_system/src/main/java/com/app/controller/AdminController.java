package com.app.controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
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
import com.app.pojos.Admin;
import com.app.pojos.Member;
import com.app.pojos.Trainer;
import com.app.service.ILoginService;
import com.app.service.IMemberService;
import com.app.service.IRegisterService;
import com.app.service.ITrainerService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ILoginService loginService;

	@Autowired
	private IRegisterService registrationService;

	@Autowired
	private ITrainerService trainerSerice;
	@Autowired
	private IMemberService memberService;

	public AdminController() {
		System.out.println("in admin Controller" + getClass().getName());
	}

	@GetMapping("/login")
	public String showAdminLogin() {
		System.out.println("show Admin Login ");
		return "/admin/login";
	}

	@PostMapping("/login")
	public String processAdminLogin(@RequestParam String email, @RequestParam String password, HttpSession hs,
			RedirectAttributes flashMap, Model modelMap) {
		System.out.println("in admin login process admin details are " + email + " " + password);
		try {
			hs.setAttribute("countoftrainer", loginService.countOfTrainer());
			hs.setAttribute("countofmember", loginService.CountOfMember());
			hs.setAttribute("countofpayments", loginService.countOfPayments());
			hs.setAttribute("countofamount", loginService.countofPayment());
			hs.setAttribute("paymentList",memberService.fetchTodayesPayments());
			hs.setAttribute("adminDetails", loginService.validateAdmin(email, password));
			return "redirect:/admin/admin_dashboard";
		} catch (RuntimeException e) {
			modelMap.addAttribute("message", "Invalid Crendentials Try Again");
			return "/admin/login";
		}
	}

	@GetMapping("/admin_dashboard")
	public String showAdminDashboard(HttpSession hs) {
		Admin admin = (Admin) hs.getAttribute("adminDetails");
		if (admin == null)
			return "/admin/login";
		return "/admin/admin_dashboard";

	}

	@GetMapping("/logout")
	public String userLogout(HttpSession session, Model modelMap, HttpServletRequest request,
			HttpServletResponse resp) {
		System.out.println("in admin logout");

		modelMap.addAttribute("details", session.getAttribute("user_details"));
		session.invalidate();

		resp.setHeader("refresh", "1;url=" + request.getContextPath());
		return "/index";
	}

	@GetMapping("/trainer_registration")
	public String showTrainerRegistration() {
		System.out.println("show trainer registration");
		return "/admin/trainer_registration";
	}

	@PostMapping("/trainer_registration")
	public String processRegistration(@RequestParam String experience, @RequestParam String firstName,
			@RequestParam String middleName, @RequestParam String lastName, @RequestParam String email,
			@RequestParam String mobileNo, @RequestParam String city, @RequestParam String state,
			@RequestParam String district, @RequestParam String addLine1, @RequestParam String addLine2,
			@RequestParam String country, @RequestParam int pincode, HttpSession hs, RedirectAttributes flashMap,
			Model modelMap) {

		System.out.println("process trainer registration " + firstName + " " + middleName + " " + lastName + " "
				+ mobileNo + " " + email + " " + city + " " + state + " " + district + " " + addLine1 + " " + addLine2
				+ " " + pincode + " " + country);
		String fullName = firstName + " " + middleName + " " + lastName;
		Trainer trainer = new Trainer(fullName, email, mobileNo, experience, "NEW", "gym_management_system");
		Address address = new Address(city, state, district, addLine1, addLine2, country, pincode);
		try {
			flashMap.addFlashAttribute("message", registrationService.trainerRegistration(trainer, address));
			return "redirect:/admin/admin_dashboard";

		} catch (RuntimeException e) {
			modelMap.addAttribute("message", "error occour durinng trainer registration" + e);
			return "/admin/trainer_registration";
		}
	}

	@GetMapping("/member_registration")
	public String showMemberRegistrationForm(HttpSession hs) {
		hs.setAttribute("trainerList", trainerSerice.fetchAllTrainer());
		return "/admin/member_registration";
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
			flashMap.addFlashAttribute("message", registrationService.registerMember(address, member, trainer));
			return "redirect:/admin/admin_dashboard";
		} catch (RuntimeException e) {
			modelMap.addAttribute("message", "some error occured At member Registration");
			return "/admin/member_registration";
		}
	}

	@GetMapping("/trainer_details")
	public String showTrainerDetails(HttpSession hs) {
		hs.setAttribute("trainerList", trainerSerice.fetchAllTrainer());
		return "/admin/trainer_details";
	}

	@GetMapping("/member_details")
	public String showMemberDetails(HttpSession hs) {
		hs.setAttribute("memberList", memberService.fetchAllMember());
		return "/admin/member_details";
	}

	@GetMapping("/member_delete")
	public String processDelete(@RequestParam int mid, RedirectAttributes flashMap, Model modelMap, HttpSession hs) {
		System.out.println("in member delete");
		try {
			flashMap.addFlashAttribute("message", memberService.deleteMemberFromAdmin(mid));
			return "redirect:/admin/member_details";
		} catch (RuntimeException e) {
			System.out.println("error occoured "+e);
			modelMap.addAttribute("message", "SOME ERROR OCCOURED");
			return "/admin/member_details";
		}
	}
	
	@GetMapping("/showpayments")
	public String showPayments(HttpSession hs,RedirectAttributes flashMap,Model modelMap) {
		hs.setAttribute("paymentList", memberService.fetchPayments());
		return "/admin/showpayments";
	}
	
	@GetMapping("/showFeedback")
	public String showFeedBack(HttpSession hs,RedirectAttributes flashMap,Model modelMap) {
		try {
			hs.setAttribute("feedbackList", memberService.fetchAllFeedBack());
			return "/admin/showFeedback";	
		} catch (RuntimeException e) {
			modelMap.addAttribute("message", "some Error Occoured"+e);
			return "/admin/showFeedback";
		}
	}
}
