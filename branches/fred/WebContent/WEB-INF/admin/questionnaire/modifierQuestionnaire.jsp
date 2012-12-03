<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
</head>
<body>
<div class="titleDiv">Liste des questionnaires</div>	
<br><br/>
	<s:form action="selectModifierQuestionnaire">
	
	  	<s:select name="questionnaireSelected" list="listeQuestionnaires" listValue="nom+' ' +description" size="10" listKey="id"/>
	 	<s:submit value="Modifier" name="modifier" />    
	
	</s:form>
	
	<s:form action="selectValiderQuestionnaire">
	
	  	<s:textfield name="monQuestionnaire.nom"  label="Nom" size="40"/>
		<s:textarea name="monQuestionnaire.description" label="Description" cols="30" rows="3"/>
		<s:submit value="Valider" name="valider" />
	</s:form>
</body>
</html>