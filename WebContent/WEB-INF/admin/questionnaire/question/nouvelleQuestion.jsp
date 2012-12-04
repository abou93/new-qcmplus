<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<div class="titleDiv">Nouvelle question</div>
	<br>
	<br />
	<s:form action="selectQuestionnaireQuestion">

		<s:select name="lgQuestionnaireSelected" list="listeQuestionnaires" listValue="nom+' ' +description" size="10" listKey="id" />
		<s:submit value="Afficher" name="afficher" />

	</s:form>

	<s:if test="listeMesQuestions != null">
		<s:form action="validerQuestion">
			<s:select name="MesQuestions" list="listeMesQuestions" listValue="intitule" size="10" listKey="id" />
			<s:submit value="Valider" name="valider" />
		</s:form>
	</s:if>
	
</body>
</html>