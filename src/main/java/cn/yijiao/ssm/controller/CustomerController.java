package cn.yijiao.ssm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yijiao.ssm.po.Customer;
import cn.yijiao.ssm.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@ResponseBody
	@RequestMapping(value = "/selectCount")
	public int selectCount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Customer customer = new Customer();
		String customerName = request.getParameter("customerName");
		customer.setFirst_name(customerName);
		int count = customerService.selectCount(customer);
		if(count==1){
			request.getSession().setAttribute("customerName", customerName);
		}
		return count;
	}

}
