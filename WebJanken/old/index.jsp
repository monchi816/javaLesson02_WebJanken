<!-- All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited -->
<%@ page contentType="text/html;charset=UTF-8"%>
<!--<%@ page import="marketsystem.entity.*"%>-->
<!--<%@ page errorPage="marketsystem-error.jsp"%>-->

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name ="company" content ="scheming">
<title>じゃんけん(人数入力)</title>
<script type="text/javascript">
function check(chkform){
	i = chkform.persons.value;
	if(i<2){
		alert("じゃんけんは２人以上で行います。");
		return false;
	}
}
</script>
</head>
<body>
<h1><font size = "10" face = "Century">"じゃんけんプログラム"</font></h1>
<font size = "5" face = "Arial">言語：java、javascript、html</font><br/>
<font size = "5" face = "Arial">環境：jdk[1.8.0_25]、jre[1.8.0_25]、tomcat7</font><br/>
<font size = "5" face = "Arial">作成日：2015/4/5</font>
<hr>
	<h2 align = "center">対戦人数を入力して下さい。</h2>

<form method="post" action="/WebJanken/FrontControllerServlet" onSubmit="return check(this)">
	<table border=1  cellpadding="7" align = "center">
		<tr>
			<td>人数</td>
			<td><input name="persons" type="text"></td>
		</tr>
	</table>
	<br/>
	<div align = "center">
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<input type="submit" name ="battle"  value="勝負" />
	<input type = "hidden" name = "flag" value = "2">
	</div>
	<br/>

</form>
</body>
</html>