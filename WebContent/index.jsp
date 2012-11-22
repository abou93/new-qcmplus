<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<center>
		<div class="titleDiv">
			<s:text name="Identification" />
		</div>
		<h1>
			<s:actionmessage />
		</h1>


		<s:form action="userverifLogin">
			<table align="center" class="borderAll">
				<s:textfield name="login" size="30" cssClass="tdLabel" label="Login" />
				<s:password name="password" size="30" cssClass="tdLabel"
					label="Mot de passe" />
			</table>
			<br />
			<table>
				<tr>
					<td><s:submit value="S'identifier" cssClass="butStnd" /></td>

				</tr>
			</table>
		</s:form>

		<table width='600' align='center'>
			<tr>
				<td><s:a href="afficheForminscription">cliquer pour l'inscription</s:a></td>
			</tr>
		</table>
	</center>

</body>
</html>