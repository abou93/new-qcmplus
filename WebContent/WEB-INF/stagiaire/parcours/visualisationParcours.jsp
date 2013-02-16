<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<s:url value="/css/menu.css"/>" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="/js/menu.js"></script>
<title><s:text name="Titre.stagiaire.parcours" /></title>
</head>
<body>
	
	<div class="titleDiv">
		<s:text name="Titre.stagiaire.parcours" />
	</div><div id="menu">
		<s:include value="/WEB-INF/stagiaire/menuStagiaire.jsp" />
	</div>
	<br />

	<s:actionerror />
	
	<div class="formList">
		<s:form action="visualisationParcours">
			<%-- accès au questionnaires via le parcours - ! doublons ! 			
			<s:select name="qrid" theme="css_xhtml" list="listeParcours" --%>
			<%-- 				listKey="questionnaire.id" listValue="questionnaire.nom" size="5" /> --%>
			<s:select name="qrid" theme="css_xhtml"
				list="listeQuestionniairesStagiaire" listKey="id" listValue="nom"
				size="10" />
			<s:submit key="Bouton.parcours.effectues" cssClass="butStnd" name="selection" />

		</s:form>
	</div>

	<s:if test="(listeParcoursQuestionnaire != null)">
		<div class="form">
		<b><s:text name="Label.questionnaire"/> : </b> <s:property value="qr.nom" />
			<table class="borderAll">
				<tr>
					<td><b>Date de début</b></td>
					<td><b>Date de fin</b></td>
					<td><b>Durée</b></td>
				</tr>

				<s:iterator value="listeParcoursQuestionnaire" status="status">
					<tr
						class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
						<td class="nowrap"><s:date name="dateDebut" format="dd/MM/yyyy"/></td>
						<td class="nowrap"><s:date name="dateFin" format="dd/MM/yyyy"/></td>
						<td class="nowrap"><s:set var="duree" value="5-3" /><s:property value="#duree"/></td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</s:if>
</body>
</html>