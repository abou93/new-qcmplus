<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:select name="questionnaireSelected" theme="css_xhtml" list="listeQuestionnaires"
	listValue="nom+' ' +description" size="10" listKey="id" />
<s:submit key="Bouton.valider" cssClass="butStnd" name="valider" />