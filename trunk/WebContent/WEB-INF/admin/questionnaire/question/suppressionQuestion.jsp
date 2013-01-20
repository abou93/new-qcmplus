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
	<s:form action="questionnaireSuppressionQuestion">

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
		<s:form action="formModificationQuestion">
			<s:select name="qid" list="listeQuestionsQuestionnaire" listValue="intitule" size="10" listKey="id" />		
		
			<s:submit key="Bouton.valider" cssClass="butStnd" name="selectionnerQuestion"/>
		
		</s:form>
	<br>
	<!--</s:if>-->
	<!-- FIN affichage liste questions questionnaire -->

	<!-- DEBUT formulaire nouvelle question  -->

	<form action="supprimerQuestion">
	
		<s:textarea name="q.intitule" key="Label.intitule"/>
		<br>

		<!-- DEBUT affichage reponses -->
		
		<s:iterator value="q.listeReponses" status="status" var="reponse">
			<s:textfield name="#reponse.libelle"/><s:checkbox name="#reponse.estCorrecte"/>			
		</s:iterator>
		
		<!-- FIN affichage reponses -->
		
		<s:submit key="Bouton.valider" cssClass="butStnd" name="validerSupprimerQuestion"/>
		
	</form>

	<!-- FIN formulaire nouvelle question -->
	</s:if>
</body>
</html>