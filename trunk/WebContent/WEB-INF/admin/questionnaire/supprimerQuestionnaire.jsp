<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
	<link href="<s:url value="/css/menu.css"/>" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<div class="titleDiv">Supprimer un questionnaire</div>

	<div id="menu">
		<s:include value="/WEB-INF/admin/menuAdmin.jsp" />
	</div>
	<br/>
	<s:form action="selectSupprimerQuestionnaire">
	  	<s:select name="questionnaireSelected" list="listeQuestionnaires" listValue="nom+' ' +description" size="10" listKey="id"/>
	 	<s:submit value="Supprimer" name="supprimer" />    
	</s:form>
	
	<s:form action="validerSupprimerQuestionnaire">

	  	<s:textfield name="monQuestionnaire.nom"  label="Nom" size="40"/>
		<s:textarea name="monQuestionnaire.description" label="Description" cols="30" rows="3"/>

		<s:submit value="Valider" name="valider" />
	</s:form>
</body>
</html>