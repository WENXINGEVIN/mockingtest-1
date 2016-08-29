<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%
HttpSession s=request.getSession(false);
s.setAttribute("duration","1"); //30 secs
String duration=(String)s.getAttribute("duration");
//this is a bug
int a=Integer.parseInt(duration); %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
var cmin=<%= a %>;
var total=cmin*60;
cmin=cmin-1;
var ctr=0;
var dom=document.getElementById("kulu");


function ram() { 
var dom=document.getElementById("kulu");
dom.value=(cmin)+"minutes"+(total%60)+"seconds";
<% String t=(String)s.getAttribute("over"); %>
var tt=<%= t %>
if(tt=="false"){ 
	ram1();
}

total=total-1;
ctr++;

if(ctr==60) {
	ctr=0;
	cmin=cmin-1;
}

if (total==0) {
	ram1();
}

	setTimeout("ram()", 1000);
}

function ram1(){
	window.location.replace("timeout.jsp");
	var dom =document.getElementById("kulu");
	dom.value="0";
}
</script>

</head>
<body background="" onload="ram()">
<form name="form1">
<input type="text" id="kulu"/>
</form>
</html>