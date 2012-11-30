<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<div class="titleDiv">
		Modifier Questionnaire
	</div>

	<s:actionerror />

	<s:form action="modifierQuestionnaire">
		
			<s:select list="listQuestionnaire" listValue="nom" />
		
		<br />			
			<s:submit key="Bouton.valider" cssClass="butStnd" />

	</s:form>

<div class="titleDiv">Liste des Questionnaires</div>	
<br><br/>
<table align='center' class="borderAll">
    <tr>
        <td><b>Nom</b></td>
        <td><b>Description</b></td>    
    </tr>
    <s:iterator value="lQuestionnaire" status="status">
        <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
            <td class="nowrap"><s:property value="nom"/></td>
            <td class="nowrap"><s:property value="description"/></td>
            <td class="nowrap"><s:select list="listQuestionnaire" listValue="nom" /></td>
        </tr>  		
	 </s:iterator>
    </table>
    
</body>
</html>