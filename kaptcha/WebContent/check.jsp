<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.google.code.kaptcha.Constants"%>
<%
   String k = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
   String str = request.getParameter("r");
   if(str.equals(k)){
	   out.println("true");
   }
   out.print(k +"-----" + str);
%>
