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
	<!-- DEBUT selection questionnaire -->
	<s:form action="questionnaireNouvelleQuestion">

		<s:select name="qrid" list="listeQuestionnaires" listValue="nom"
			size="10" listKey="id" />
		<s:submit value="Afficher" name="afficher" />

	</s:form>
	<!-- FIN selection questionnaire -->

	<!-- DEBUT affichage questionnaire -->
	<s:if test="qr != null">
		<s:textfield name="qr.nom" size="30" cssClass="tdLabel" key="Label.nom" disabled="true"/>
		<s:textfield name="qr.description" size="100" cssClass="tdLabel" key="Label.description" disabled="true"/>
	
	<!-- FIN affichage questionnaire -->

	<!-- DEBUT affichage liste questions questionnaire -->
	<!--<s:if test="listeQuestionsQuestionnaire != null">-->
		<s:select name="QuestionsQuestionnaire" list="listeQuestionsQuestionnaire" listValue="intitule" size="10" listKey="id" />		
	<!--</s:if>-->
	<!-- FIN affichage liste questions questionnaire -->

	<!-- DEBUT formulaire nouvelle question  -->

	<form action="nouvelleQuestion">
	
		<s:textarea name="q.intitule" key="Label.intitule"/>
		<br>

		<!-- DEBUT affichage reponses -->
		
		
			<s:textfield name="reponse1.libelle"/><s:checkbox name="reponse1.estCorrecte"/>
			<s:textfield name="reponse2.libelle"/><s:checkbox name="reponse2.estCorrecte"/>
			<s:textfield name="reponse3.libelle"/><s:checkbox name="reponse3.estCorrecte"/>
			<s:textfield name="reponse4.libelle"/><s:checkbox name="reponse4.estCorrecte"/>
			<s:textfield name="reponse5.libelle"/><s:checkbox name="reponse5.estCorrecte"/>
			
		

		<!-- FIN affichage reponses -->
		
		<s:submit key="Bouton.valider" cssClass="butStnd" name="validerQuestion"/>
		
	</form>

	<!-- FIN formulaire nouvelle question -->
	</s:if>
</body>
</html>