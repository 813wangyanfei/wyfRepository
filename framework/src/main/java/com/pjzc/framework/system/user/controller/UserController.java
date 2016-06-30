/**
 * 
 */
package com.pjzc.framework.system.user.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pjzc.framework.system.user.model.User;
import com.pjzc.framework.system.user.service.IUserService;

/**
 * @author wangyanfei
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	IUserService userService;

	@RequestMapping("/hello")
	public String test() {
		return "hello";
	}

	@RequestMapping("/greeting")
	public String greeting(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	/**
	 * 
	 * 
	 * @return
	 */
	@RequestMapping("/manage")
	public String login(HttpSession session) {
		if (session.getAttribute("admin") != null) {
			return "main";
		}
		return "login";
	}

	/**
	 * 
	 * 
	 * @return
	 */
	@RequestMapping("/doLogin")
	public String doLogin(@ModelAttribute User user, HttpSession session,
			HttpServletRequest request,
			@RequestParam(value = "code", required = false) String code,
			Model model) {
		if (session.getAttribute("user") != null) {
			return "main";
		}
		User nuser = userService.findUserByLogin(user);
		if (nuser == null) {
			request.setAttribute("info", "用户名或密码错误");
			return "login";
		}
		System.out.println(user.toString());
		session.setAttribute("admin", user);
		return "main";
	}
	
	/**
	 * 添加用户
	 * @param user
	 * @param session
	 * @param request
	 * @param code
	 * @param model
	 * @return
	 */
	@RequestMapping("/addUser")
	public String addUser(@ModelAttribute User user, HttpSession session,
			HttpServletRequest request,
			@RequestParam(value = "code", required = false) String code,
			Model model) {
		userService.addUser(user);
		System.out.println(user.toString());
		session.setAttribute("admin", user);
		return "addUserSuccess";
	}
	
	/**
	 * 跳转到添加用户页面
	 * @param user
	 * @param session
	 * @param request
	 * @param code
	 * @param model
	 * @return
	 */
	@RequestMapping("/toAddUser")
	public String toAddUser(@ModelAttribute User user, HttpSession session,
			HttpServletRequest request,
			@RequestParam(value = "code", required = false) String code,
			Model model) {
		return "add";
	}

//	/**
//	 * 管理员列
//	 * 
//	 * @return
//	 */
//	@RequestMapping("/adminList")
//	public String adminList(Model model) {
//		List<User> admins = userService.findUserAll();
//		model.addAttribute("admins", admins);
//		return "admin/listUser";
//	}

	/**
	 * 管理员更
	 * 
	 * @return
	 */
	@RequestMapping("/admin/initUpdateUser")
	public String initUpdateUser(
			@RequestParam(value = "updateId", required = false, defaultValue = "0") int updateId,
			Model model) {

//		if (updateId != 0) {
//			User user = userService.findUser(updateId);
//			model.addAttribute("admin", user);
//			model.addAttribute("updateId", updateId);
//		}
		return "admin/addUser";
	}

	/**
	 * 管理员更
	 * 
	 * @return
	 */
	@RequestMapping("/admin/updateUser")
	public String updateUser(
			@ModelAttribute User user,
			@RequestParam(value = "updateId", required = false, defaultValue = "0") int updateId,
			Model model) {

		if (updateId != 0) {
//			User user2 = userService.findUser(updateId);
//			user2.setUserPwd(user.getUserPwd());
//			userService.updateUser(user2);
//			model.addAttribute("admin", user2);
			model.addAttribute("updateId", updateId);
			model.addAttribute("info", "更新成功");
		} else {
			model.addAttribute("info", "更新失败");
		}
		return "admin/addUser";
	}

	/**
	 * 管理员删
	 * 
	 * @return
	 */
//	@RequestMapping("/admin/delUser")
//	public String delUser(
//			@ModelAttribute User user,
//			@RequestParam(value = "updateId", required = false, defaultValue = "0") int updateId,
//			Model model) {
//
//		if (updateId != 0) {
//			User user2 = userService.findUser(updateId);
//			if (user2 != null && user2.getId() != 1) {
//				userService.deleteUser(user2);
//				model.addAttribute("info", "");
//			} else {
//				model.addAttribute("info", "");
//			}
//		} else {
//			model.addAttribute("info", "操作失败");
//		}
//		return adminList(model);
//	}

}
