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
			<s:text name="Login.identification" />
		</div>
		
			<s:actionerror />

		<s:form action="login">
			<table align="center" class="borderAll">
				<s:textfield name="nom" size="30" cssClass="tdLabel" key="Label.nom"/> 
				<s:password name="mdp" size="30" cssClass="tdLabel"
					key="Label.mdp" /> 
			</table>
			<br />
			<table>
				<tr>
					<td><s:submit key="Bouton.valider" cssClass="butStnd" /></td>

				</tr>
			</table>
		</s:form>
	</center>

</body>
</html>