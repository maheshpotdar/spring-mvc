package com.mahesh.Controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mahesh.Dao.Dbconnection;
import com.mahesh.Model.User;

@Controller
public class MainController {
	String sql = "";

	@Autowired
	private Dbconnection dbcon;

	@RequestMapping("/")
	public String getIndex() {
		return "index";
	}

	@RequestMapping("/registeradmin")
	public String getAdminRegister(@ModelAttribute("user") User user, ModelMap modelMap) {
		System.out.println("admin");
		modelMap.addAttribute("user", new User(0, "", "", "", "", "", 1, 0, true));

		return "registeradmin";
	}

	@RequestMapping("/register")
	public String getregister(@ModelAttribute("user") User user, ModelMap modelMap) {
		modelMap.addAttribute("user", new User(0, "", "", "", "", "", 1, 0, true));
		return "register";
	}

	@RequestMapping("/registerActionForm")
	public String getRegistForm(@Valid @ModelAttribute("user") User user, BindingResult result) {

		// when register clicked.
		if (result.hasErrors()) {
			return "register";
		} else {
			int val = dbcon.insertRegiForm(user);
			if (val > 0)
				return "redirect:/login";
			else
				return "redirect:/error";
		}
	}

	@RequestMapping("/registerAdminActionForm")
	public String getAdminRegistForm(@ModelAttribute("user") User user) {
		// when register clicked.

		int val = dbcon.insertRegiForm(user);
		if (val > 0)
			return "redirect:/login";
		else
			return "redirect:/error";
	}

	@RequestMapping("/user")
	public String getuser(@ModelAttribute("user") User user, ModelMap modelMap) {

		modelMap.addAttribute("user", new User(0, "", "", "", "", "", 0, 0, true));
		return "user";
	}

	@RequestMapping("/userActionForm")
	public String getuserActionForm(@ModelAttribute("user") User user, ModelMap modelMap) {
		// when user clicked.

		int val = dbcon.insertRegiForm(user);
		if (val > 0)
			return "redirect:/login";
		else
			return "redirect:/error";
	}

	@RequestMapping("/login")
	public String getLogin(@ModelAttribute("user") User user, ModelMap modelMap) {

		User user2 = new User(0, "", "", "", "", "", 0, 0, true);
		modelMap.addAttribute("user", user2);
		return "login";
	}

	@RequestMapping("/loginFormAction")
	public String getloginFormAction(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
		String view = "", role = null;
		int aprv = 0;
		System.out.println("1");
		if (bindingResult.hasErrors()) {
			System.out.println("2");
			view = "error";
			System.out.println("3");
		} else {
			if (dbcon.isValidUser(user)) {
				System.out.println("4");
				role = dbcon.getRoleOfUser(user);
				if (role.equals("admin")) {
					System.out.println("5");
					view = "redirect:/dashboard";

				} else if (role.equals("user")) {
					System.out.println("6");
					aprv = dbcon.isApproved(user, role);
					if (aprv > 0) {
						view = "redirect:/userform";
					} else {
						view = "redirect:/notapprove";
					}

				}
			}
		}
		System.out.println("7" + view);
		return view;

	}

	@RequestMapping("/notapprove")
	public String getapproval() {
		return "notapprove";
	}

	@RequestMapping("/dashboard")
	public String getdashBoard() {
		return "dashboard";
	}

	@RequestMapping("/userform")
	public String getEmployeePage() {
		return "userform";
	}

	@RequestMapping("/insertUser")
	public String insertUser(@ModelAttribute("user") User user, ModelMap modelMap) {
		// index jsp from insertUser() then call this method.
		// insert here
		dbcon.insertUser(user);
		modelMap.addAttribute("lst", dbcon.getUserList());
		return "redirect:/viewuser";
	}

	@RequestMapping("/adduser")
	public String getAddEmployee(@ModelAttribute("user") User user, ModelMap modelMap) {
		// index jsp from request for addEmployee so show addEmployee.jsp page
		modelMap.addAttribute("user", new User(0, "", "", "", "", "", 0, 0, true));
		return "adduser";
	}

	@RequestMapping("/viewuser")
	public String getviewEmployee(@ModelAttribute("user") User user, ModelMap modelMap) {
		// index jsp from request for viewEmployee so show viewEmployee.jsp page
		modelMap.addAttribute("lst", dbcon.getUserList());
		return "viewuser";
	}

	@RequestMapping("/edituser/{empId}")
	public String getEditEmployee(@PathVariable int empId, @ModelAttribute("user") User user, ModelMap modelMap) {
		User users = dbcon.getIdwiseUser(empId);
		modelMap.addAttribute("user", users);
		return "edituser";
	}

	@RequestMapping(value = "/updateuser/{userId}", method = RequestMethod.POST)
	public String UpdateEmpFormAction(@PathVariable("userId") int userId, @ModelAttribute("user") User user,
			ModelMap modelMap) {
		int val = dbcon.updateUser(user, userId);
		if (val > 0)
			return "redirect:/viewuser";
		else
			return "redirect:/error";
	}

	@RequestMapping("/updateMsg")
	public String updateMsg() {
		return "updateMsg";
	}

	@RequestMapping("/error")
	public String error() {
		return "error";
	}

	@RequestMapping("/deleteuser/{empId}")
	public String deleteEmployee(@PathVariable int empId) {
		int value = dbcon.deleteUser(empId);
		return (value > 0) ? "redirect:/viewuser" : "redirect:/error";
	}

	@RequestMapping("/userAdmin")
	public String getuserAdmin(@ModelAttribute("user") User user, ModelMap modelMap) {
		modelMap.addAttribute("user", new User(0, "", "", "", "", "", 0, 0, true));
		return "adminuser";
	}

	@RequestMapping("/useradminActionForm")
	public String getRegistAdminForm(@ModelAttribute("user") User user) {
		// when user clicked.

		int val = dbcon.insertRegiForm(user);
		if (val > 0)
			return "redirect:/login";
		else
			return "redirect:/error";
	}

}
