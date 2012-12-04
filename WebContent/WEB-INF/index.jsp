<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
</head>
<body>

	<div class="titleDiv">
		<s:text name="Login.identification" />
	</div>

	<s:actionerror />
	<div class="form">
		<s:form action="login">
			<s:textfield name="nom" size="30" cssClass="tdLabel" key="Label.nom" />
			<s:password name="mdp" size="30" cssClass="tdLabel" key="Label.mdp" />
			<br />
			<s:submit key="Bouton.valider" cssClass="butStnd" name="valider" />
		</s:form>
	</div>

</body>
</html>