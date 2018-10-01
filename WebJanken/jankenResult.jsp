<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="webJanken.*"%>
<!--<%@ page errorPage="marketsystem-error.jsp"%>-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="JankenHelper"  scope="session" class="webJanken.JankenHelper" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name ="company" content ="scheming">
<title>じゃんけん(結果)</title>
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
<form method="post" action="/WebJanken/FrontControllerServlet" >

	<%JankenEntity jankenEntity = JankenHelper.getJankenResult(request);%>

<h1><font size = "10" face = "Century">"じゃんけんプログラム"</font></h1>
<font size = "5" face = "Arial">言語：java、javascript、html</font><br/>
<font size = "5" face = "Arial">環境：jdk[1.8.0_25]、jre[1.8.0_25]、tomcat7</font><br/>
<font size = "5" face = "Arial">作成日：2015/4/5</font>
<hr>
	<h2 align = "center">じゃんけん結果</h2><br/>
<form method="post" action="/WebJanken/FrontControllerServlet" onSubmit="return check(this)">
	<table border="1" align = "center" width="10%">
		<tr bgcolor = "powderblue">
			<td align="center">対戦人数</td>
		</tr>
		<tr>
			<td align="center"><input name="persons" type="text" value="<%=jankenEntity.getPlayers().size()%>" style="text-align:center"></td>
		</tr>
	</table>
	<br/>
	<br/>
	<table border="1" align = "center" width="20%">
		<tr bgcolor = "powderblue">
			<td align="center">選択した手</td>
		</tr>
		<% for(int i = 0 ; i < jankenEntity.getPlayers().size() ; i++){ %>
		<tr>
			<% Player player = (Player)jankenEntity.getPlayers().get(i); %>
			<% int hand = ((Integer)jankenEntity.getHands().get(i)).intValue(); %>
			<td align="left"><%=player.getName()%>'s hand is <%=Player.valueOf(hand)%></td>
		</tr>
		<% } %>

	</table>
	<br/>
	<br/>
	<table border="1" align = "center" width="10%">
		<tr bgcolor = "powderblue">
			<td align="center">結果</td>
		</tr>
		<% if(jankenEntity.getWinners().isEmpty()){ %>
		<tr>
			<td align="center">drow !</td>
		</tr>
		<% }else{ for(int i =0;i<jankenEntity.getWinners().size();i++){ %>
		<tr>
			<% Player player = (Player)jankenEntity.getWinners().get(i);%>
			<td align="center">Winner is <%=player.getName()%></td>
		</tr>
			<% } %>
		<% } %>

	</table><br/><br/><br/>
	<div align = "center">
	<input type="submit" name ="rebattle"  value="今の人数でもう一度勝負" />
	<input type = "hidden" name = "flag" value = "2">
	</div>
</form>
	<br/><br/>
	<div align = "center">
	<a href="/WebJanken?flag=1">トップへ戻る</a>
	</div>

</form>
</body>
</html>