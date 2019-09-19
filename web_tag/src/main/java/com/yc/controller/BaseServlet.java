package com.yc.controller;

import java.io.IOException;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

public class BaseServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1242235178904034540L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

	public void toPrintString(HttpServletResponse response, Object obj,int total) throws IOException {
		Gson gson = new Gson();
		String info = gson.toJson(obj);
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("\"total\":"+total+",\"rows\":");
		sb.append(info);
		sb.append("}");
		response.getWriter().print(sb.toString());
	}
	
	public void toPrintString(HttpServletResponse response,Object obj) throws IOException {
		Gson gson = new Gson();
		String info = gson.toJson(obj);
		response.getWriter().print(info);
	}
	
	
	public void toPrintString(HttpServletResponse response, String str) throws IOException {
		Gson gson = new Gson();
		String info = gson.toJson(str);
		response.getWriter().print(info);
	}
	public void toPrintString(HttpServletResponse response, Integer total) throws IOException {
		Gson gson = new Gson();
		String info = gson.toJson(total);
		response.getWriter().print(info);
	}
	
	public <T> T parserRequestToObject(HttpServletRequest request, Class<T> cls){
		T t = null;
		try {
			Field [] fields = cls.getDeclaredFields();//属性
			Method [] methods = cls.getDeclaredMethods();//方法
			t = cls.newInstance();
			String value = null;
			String fieldName = null;
			for(Field field:fields){
				fieldName = field.getName();
				value = request.getParameter(fieldName);
				if("a_id".equalsIgnoreCase(fieldName)){
				}
				if(null==value || "".equals(value)){
					continue;
				}
				for(Method m : methods){
					if(("set"+fieldName).equalsIgnoreCase(m.getName())){
						String paramType = m.getParameterTypes()[0].getName();
						if("java.lang.Integer".equals(paramType)){
							m.invoke(t, Integer.parseInt(value));
						}else if("java.lang.Double".equals(paramType)){
							m.invoke(t, Double.parseDouble(value));
						}else if ("java.lang.Float".equals(paramType)) {
							m.invoke(t, Float.parseFloat(value));
						}else if ("java.lang.String".equals(paramType)) {
							m.invoke(t, value);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	
}
