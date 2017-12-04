package com.user.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.Order;
import com.entity.Shopcar;
import com.user.service.FindProductService;
import com.user.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Resource 
	private OrderService orderService;
	@Resource
	private FindProductService findProductService;
	//展示到订单页面
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String findByI(Model model,HttpSession session){
		List<Shopcar> list=findProductService.findByUserName((String) session.getAttribute("name"));
		model.addAttribute("list",list);
		return "order";
	}
}
