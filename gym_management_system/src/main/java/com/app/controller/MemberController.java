package com.app.controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.IMemberDao;
import com.app.pojos.Diet;
import com.app.pojos.Feedback;
import com.app.pojos.Member;
import com.app.pojos.Payment;
import com.app.pojos.Trainer;
import com.app.pojos.TrainerRequest;
import com.app.service.IDietService;
import com.app.service.ILoginService;
import com.app.service.IMemberService;
import com.app.service.ITrainerService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private ILoginService loginService;
	@Autowired
	private ITrainerService trainerService;
	@Autowired
	private IDietService dietService;
	@Autowired
	private IMemberService memberService;

	public MemberController() {
		System.out.println("in member controller");
	}

	@GetMapping("/login")
	public String showLogin() {
		return "/member/login";
	}

	@PostMapping("/login")
	public String processLogin(@RequestParam String email, @RequestParam String password, HttpSession hs,
			RedirectAttributes flashMap, Model modelMap) {
		System.out.println("in process login " + email + " " + password);
		try {
			Member member = loginService.validateMember(email, password);
			if (member != null) {
				hs.setAttribute("memberDetails", member);
				// System.out.println("member details "+member);
				// shs.setAttribute("yesterdayDiet", diet);
				return "redirect:/member/member_dashboard";
			} else
				return "/member/login";
		} catch (RuntimeException e) {
			modelMap.addAttribute("message", "Some Error Occoured " + e);
			return "/member/login";
		}
	}

	@GetMapping("/member_dashboard")
	public String showDashboard(HttpSession hs) {
		return "/member/member_dashboard";
	}

	@GetMapping("/trainerDetails")
	public String showTrainerDetails(Model modelMap) {
		List<Trainer> listOfTrainer = trainerService.fetchAllTrainer();
		modelMap.addAttribute("tainerInfo", listOfTrainer);
		System.out.println("list of trainer " + listOfTrainer);

		return "/member/trainerDetails";
	}

	@GetMapping("/requestTrainer")
	public String requestTrainer(@RequestParam String tid, Model modelMap, RedirectAttributes flashMap,
			HttpSession hs) {
		Member member = (Member) hs.getAttribute("memberDetails");
		System.out.println("membeer Details" + member + " " + tid);
		Trainer trainerInfo = trainerService.findTrainerById(tid);
		TrainerRequest tr = new TrainerRequest("requested");
		flashMap.addFlashAttribute("message", memberService.saveRequest(tr, trainerInfo, member));
		return "redirect:/member/trainerDetails";
	}

	@GetMapping("/changePassword")
	public String showChangePassword() {
		return "/member/changePassword";
	}

	@PostMapping("/changePassword")
	public String processChangePassword(@RequestParam String old, @RequestParam String newp, @RequestParam String con,
			RedirectAttributes flashMap, Model modelMap, HttpSession hs) {
		System.out.println("change passwrod " + old + " " + newp + " " + con);
		if (newp.equals(con)) {
			Member m = (Member) hs.getAttribute("memberDetails");
			flashMap.addFlashAttribute("message", memberService.changepassword(m.getId(), con, old));
			return "redirect:/member/changePassword";
		} else {
			modelMap.addAttribute("message", "Password Not Matched");
			return "/member/changePassword";
		}
	}

	@GetMapping("/trainerInfo")
	public String showTrainerInfo(@RequestParam String id, RedirectAttributes flashMap, HttpSession hs,
			Model modelMap) {
		try {
			hs.setAttribute("trainerI", memberService.fetchMytrainer(id));
			return "redirect:/member/trainerShow";
		} catch (RuntimeException e) {
			modelMap.addAttribute("message", "trainer not assigned" + e);
			return "/member/trainerShow";
		}
	}

	@GetMapping("/trainerShow")
	public String showTrainer() {
		return "/member/trainerShow";
	}

	@GetMapping("/showdiet")
	public String showDiet(@RequestParam int id, RedirectAttributes flashMap, Model modelMap, HttpSession hs) {
		Diet d = dietService.findTodayesDiet(id, LocalDate.now());
		if (d != null) {
			hs.setAttribute("dietInfo", d);
			return "redirect:/member/mydiet";
		} else {
			modelMap.addAttribute("message", "todayes Diet Is not Updated contact your Trainer");
			return "/member/member_dashboard";
		}
	}

	@GetMapping("/mydiet")
	public String showMyDiet() {
		return "/member/mydiet";
	}

	@GetMapping("/myprofile")
	public String myProfile(@RequestParam int id, RedirectAttributes flashMap, HttpSession hs, Model modelMap) {
		Member m = memberService.fetchMyDetails(id);
		if (m != null) {
			hs.setAttribute("myInfo", m);
			return "redirect:/member/showProfile";
		} else {
			modelMap.addAttribute("message", "some Error Occoured");
			return "/member/showProfile";
		}
	}

	@GetMapping("/showProfile")
	public String showProfile() {
		return "/member/showProfile";
	}

	@GetMapping("/profile")
	public String profile(@RequestParam int id, HttpSession hs, RedirectAttributes flashMap, Model modelMap) {
		Member m = memberService.fetchMyDetails(id);
		if (m != null) {
			hs.setAttribute("myInfo", m);
			return "redirect:/member/updateProfile";
		} else {
			modelMap.addAttribute("message", "some Error Occoured");
			return "/member/showProfile";
		}
	}

	@GetMapping("/updateProfile")
	public String updateProfile() {
		return "/member/updateProfile";
	}

	@PostMapping("/updateProfile")
	public String processUpdateProfile(@RequestParam int id, @RequestParam String name, @RequestParam String email,
			@RequestParam String mobileNo, @RequestParam String city, @RequestParam String state,
			@RequestParam String district, @RequestParam String addLine1, @RequestParam String addLine2,
			@RequestParam String country, @RequestParam String pincode, @RequestParam String dateOfBirth,
			@RequestParam String gender, @RequestParam String height, @RequestParam String weight,
			@RequestParam String startTime, @RequestParam String endTime, @RequestParam MultipartFile image,
			Model modelMap, RedirectAttributes flashMap, HttpSession hs) throws IOException {
		try {
			byte[] imageFile = image.getBytes();
			flashMap.addFlashAttribute("message",
					memberService.updateMember(id, name, email, mobileNo, city, state, district, addLine1, addLine2,
							country, pincode, dateOfBirth, gender, height, weight, startTime, endTime, imageFile));
			return "redirect:/member/updateProfile";
		} catch (RuntimeException e) {
			modelMap.addAttribute("message", "SOme Error Occoured");
			return "/member/updateProfile";
		}
	}

	@GetMapping("/showExcercise")
	public String showExcercise(RedirectAttributes flashMap, Model modelMap, HttpSession hs) {
		try {
			hs.setAttribute("excerciseImage", memberService.showExcercise());
			return "/member/showExcercise";
		} catch (RuntimeException e) {
			modelMap.addAttribute("message", "some Error Occoured");
			return "/member/showExcercise";
		}
	}

	@GetMapping("/payments")
	public String showPayment() {
		return "/member/payments";
	}

	@GetMapping("/processPayment")
	public String processPayment(@RequestParam String rs, RedirectAttributes flashMap, Model modelMap) {
		modelMap.addAttribute("amount", rs);
		return "/member/PaymentOption";
	}

	@PostMapping("/cardPayment")
	public String cardPaymentSave(@RequestParam String amount, @RequestParam String username,
			@RequestParam String cardNumber, @RequestParam int month, @RequestParam int year, @RequestParam int cvv,
			RedirectAttributes flashMap, Model modelMap, HttpSession hs) {
		try {
			Member m = (Member) hs.getAttribute("memberDetails");
			String pack = "";
			if (amount.equals("3999"))
				pack = "platinum";
			else if (amount.equals("1299"))
				pack = "gold";
			else if (amount.equals("999"))
				pack = "silver";
			else if (amount.equals("699"))
				pack = "basic";
			Payment p = new Payment(pack, "CARD", username, cardNumber, month, year, cvv, Double.parseDouble(amount),
					null, LocalDate.now());
			flashMap.addFlashAttribute("message", memberService.addPayment(p, m));
			return "/member/paymentSuccess";

		} catch (RuntimeException e) {
			modelMap.addAttribute("message", "Some Technical Error Occoured Try After Some Time");
			return "/member/processPayment";
		}
	}

	@GetMapping("/paymentSuccess")
	public String successMessage() {
		return "/member/paymentSuccess";
	}

	@PostMapping("/upiPayment")
	public String upiPayment(@RequestParam String upi, @RequestParam String amount, RedirectAttributes flashMap,
			Model modelMap, HttpSession hs) {
		try {
			Member m = (Member) hs.getAttribute("memberDetails");
			String pack = "";
			if (amount.equals("3999"))
				pack = "platinum";
			else if (amount.equals("1299"))
				pack = "gold";
			else if (amount.equals("999"))
				pack = "silver";
			else if (amount.equals("699"))
				pack = "basic";
			Payment p = new Payment(pack, "UPI", null, null, 0, 0, 0, Double.parseDouble(amount), upi, LocalDate.now());
			flashMap.addFlashAttribute("message", memberService.addPayment(p, m));
			return "/member/paymentSuccess";
		} catch (RuntimeException e) {
			modelMap.addAttribute("message", "Some Techinical Eror Occoured Please Try Again");
			return "/member/processPayment";
		}
	}

	@GetMapping("/feedback")
	public String showFeedBack() {
		return "/member/feedback";
	}

	@PostMapping("/feedback")
	public String processfeedBack(@RequestParam String name, @RequestParam String email, @RequestParam String mobileNo,
			@RequestParam String comment, RedirectAttributes flashMap, Model modelMap, HttpSession hs) {
		Feedback f=new Feedback(name, email, mobileNo, comment);
		try {
			flashMap.addFlashAttribute("message", memberService.saveFeedBack(f));
			return "redirect:/member/feedback";
		} catch (RuntimeException e) {
			modelMap.addAttribute("message", "some error occoured");
			return "/member/feedback";
		}
		
	}

}
