package com.yc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yc.po.StudentPO;
@SessionAttributes(value={"stu"},types= {StudentPO.class})
@Controller
@RequestMapping(value="/springmvc")
public class HelloWorld {
	private static final String SUCCESS="success";
	@RequestMapping(value="testMethod",method=RequestMethod.POST)

	public String TestMethod() {
		System.out.println("aaa");
		return SUCCESS;
	}
	
	//根据请求方法 和参数找到对应方法 所以路径可以相同
	@RequestMapping(value="taget/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public String delete(@PathVariable Integer id ) {
		System.out.println("delete"+"id:"+id);
		return SUCCESS;
	}
	//@PathVariable获取url地址的拼接信息
	@RequestMapping(value="taget/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public String update(@PathVariable("id") Integer id ) {
		System.out.println("update"+"id:"+id);
		return SUCCESS;
	}
	
	
	/*
	 * @RequestMapping映射请求的URL
	 * 返回值通过视图解析器转为物理视图 对于internalResouceViewResolver 视图解析器 会做如下解析：
	 * 通过prefix + returnValue +suffix 这样的方式得到物理视图 然后转发
	 * web-info/view/success.jsp
	 * */
	@RequestMapping("/hello")
	public String say() {
		System.out.println("hello world");
		return "success";
	}
	@RequestMapping("/testSessionAbttribute")
	public String testSession(Map<String, Object> map) {
	StudentPO studentPO=new StudentPO();
	studentPO.setAge(10);
	studentPO.setPwd("a");
	studentPO.setUname("wangwu");
	map.put("address", "hunan");
	map.put("stu", studentPO);
	
	return SUCCESS;
	}
	
	
	//给jababBean做封装
	@RequestMapping(value="/testpo"  )
	public String testtestpo(StudentPO po) {
//	System.out.println("studentPO"+studentPO);
		System.out.println("po:"+po);
	return SUCCESS;
	}
	
@RequestMapping("/requestparmdad")
public String testRequesparm(@RequestParam(name="uname") String name) {
	System.out.println(name);
	return SUCCESS;
}


@RequestMapping("/testModelAttribute")
public String testModelAttribute(StudentPO po,Map<String, Object> map) {
	System.out.println("po1:"+po);
	System.out.println("stu:"+map.get("stu"));
	System.out.println("address:"+map.get("address"));
	return SUCCESS;
}
@ModelAttribute
public void ModelAttr(StudentPO po) {
	po.setPwd("aa");
	System.out.println("model:"+po);
}
}
