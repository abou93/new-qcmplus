<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
</head>
<body>

	<div class="titleDiv">
		QUESTIONNAIRE TROUVE !
		<p><s:property value="%{#session.questionnaire.id}"/> !</p>
	</div>

	<s:actionerror />




</body>
</html>