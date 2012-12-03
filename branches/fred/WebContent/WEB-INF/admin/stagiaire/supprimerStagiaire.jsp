<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
<title><s:text name="Titre.stagiaire.supprimer" /></title>
</head>
<body>

	<div class="titleDiv">
		<s:text name="Titre.stagiaire.supprimer" />
	</div>

	<s:include value="selectionStagiaire.jsp" />

	<s:actionerror />

	<s:form action="supprimerStagiaire">

		<s:textfield name="s.nom" size="30" cssClass="tdLabel" key="Label.nom" />
		<s:textfield name="s.prenom" size="30" cssClass="tdLabel"
			key="Label.prenom" />
		<s:textfield name="s.societe" size="30" cssClass="tdLabel"
			key="Label.societe" />
		<s:textfield name="s.motDePasse" size="30" cssClass="tdLabel"
			key="Label.mdp" />

		<br />


		<s:submit key="Bouton.valider" cssClass="butStnd" name="modification" />


	</s:form>


</body>
</html>