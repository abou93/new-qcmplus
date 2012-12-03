<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:select name="sid" theme="css_xhtml" list="listeStagiaires"
	listKey="id" listValue="nom + ' ' + prenom" size="5" />
<s:submit key="Bouton.valider" cssClass="butStnd" name="selection" />

