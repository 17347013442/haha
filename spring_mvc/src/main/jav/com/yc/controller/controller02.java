package com.yc.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.yc.po.StudentPO;

@Controller
@RequestMapping("/springmvc02")
public class controller02 {

	
	@RequestMapping("/testmodelandview")
	public ModelAndView testmodelandview() {
		ModelAndView mv=new ModelAndView();
		StudentPO po=new StudentPO();
		po.setAge(12);
		po.setPwd("a");
		po.setUname("lisi");
		mv.addObject("student",po);
		mv.setViewName("success");
		return mv;
	}
	
	
	@RequestMapping("testAjax")
	@ResponseBody
	public  StudentPO testAjax(@RequestBody StudentPO po) {
		System.out.println("po:"+po);
		System.out.println("该方法执行!!!!!!!");
		po.setPwd("cc");
		po.setAge(20);
		return po;
		
	}
	
	
	
//	@RequestMapping("testAjax")
//	@ResponseBody
//	public  StudentPO testAjax( StudentPO po) {
//		System.out.println("po:"+po);
//		System.out.println("该方法执行!!!!!!!");
//		po.setPwd("cc");
//		po.setAge(20);
//		return po;
//		
//	}
	//spring mvc 文件上传
	@RequestMapping("testUpload")
	@ResponseBody
	public  String testUpload(MultipartFile[] uploads,HttpServletRequest request,StudentPO po) {
		String path=request.getSession().getServletContext().getRealPath("/upload/");
		System.out.println("path:"+path);
		System.out.println("uname"+po.getUname());
		File file=new File(path);
		if(!file.exists()) {
			file.mkdir();
		}
		
		
		if(null!=uploads && uploads.length>0 &&!uploads[0].isEmpty()) {
			System.out.println("-----------");
			for(MultipartFile upload:uploads ) {
				System.out.println("upload:"+upload);
				String name=upload.getOriginalFilename();
				String fileName=UUID.randomUUID().toString().replace("-", "")+name;
				try {
					upload.transferTo(new File(path,fileName));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			return "success";
		}
		
		
		return "error";
		
	}
	
	
	//spring mvc 异常处理
	
	@RequestMapping("testException")
	
	public  String testException() throws SysException {
		try {
			int i=3/0;
		} catch (Exception e) {
			throw new SysException("除0错误");
		}
		
		return "success";
		
	}
	
}
