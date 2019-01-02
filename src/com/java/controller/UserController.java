package com.java.controller;


import com.alibaba.fastjson.JSONObject;
import com.java.entity.User;
import com.java.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;

	/**
	 * 我们在Controller的目标方法上直接设置方法的参数。就可以直接传入请求参数的值。
	 * 如http://localhost:8080/ssmTestMySQL/user/getUser.do?id=1
	 * 要求：参数名必须和方法的参数名相匹配。
	 * @param map
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getUser" )
	public String getUser(Map map,int id) {

		User resultUser=userService.getUserFromId(id);
		System.out.println(resultUser.getUserName());

		map.put("userOne", resultUser);

		return "welcome";
	}
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request, HttpServletResponse response){

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String username=request.getParameter("userName");
		String password=request.getParameter("passWord");

		User users=new User(username, password);
		userService.add(users);
		return "reback";
	}


	//登录
	@RequestMapping("/login")
	public String login(User user,HttpServletRequest request,HttpServletResponse response) throws IOException {

		User resultUser=userService.login(user);
		System.out.println(resultUser);

		if(resultUser==null) {
			request.setAttribute("user", user);
			request.setAttribute("errorMsg", "用户名或密码错误！");

	//		response.sendRedirect("../index.jsp");//(为了冲破前缀后缀的束缚，用重定向)  重定向到index.jsp

			//重定向到首页
			return "redirect:../index.jsp";
		}else {
			HttpSession session=request.getSession();
			session.setAttribute("userOne", resultUser);
			return "welcome";
		}

	}


	/**
	 * @ResponseBody主要用来接收前端传递给后端的json字符串中的数据的(请求体中的数据的);
	 * GET方式无请求体，所以使用@RequestBody接收数据时，前端不能使用GET方式提交数据，而是用POST方式进行提交。
	 *
	 * 在后端的同一个接收方法里，@RequestBody 与@RequestParam()可以同时使用，@RequestBody最多只能有一个，而@RequestParam()可以有多个。
	 * 注:一个请求，只有一个RequestBody;一个请求，可以有多个RequestParam
	 *
	 * @param jsonStr
	 * @return
	 */
	@RequestMapping("/requestJson")
	@ResponseBody
	public String requestJson(@RequestBody String jsonStr){
		System.out.println(jsonStr);
		return jsonStr;
	}

	@RequestMapping("/responseJson")
	@ResponseBody
	public String responseJson(User user){
		System.out.println(user);
		return user.toString();
	}


	/**
	 * 返回json数据
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/getUsersJSON")
	public String getUsers(HttpServletRequest request,HttpServletResponse response) throws IOException {
		List<User> resultUsers=userService.getUsers();

		//转换成json
		String jsonStr=JSONObject.toJSON(resultUsers).toString();

		System.out.println(jsonStr);

		//通过response指定响应结果
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("application/json;charset=utf-8");
//		response.getWriter().write(jsonStr);

		return jsonStr;
	}

}
