<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<s:url value="/css/menu.css"/>" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="/js/menu.js"></script>
</head>
<body>

	<div id="menu">
		<s:include value="../menuAdmin.jsp" />
	</div>

	<p>
		<s:property value="%{#session.utilisateur.nom}" />
		!
	</p>
	<p>
		<s:actionmessage />
	<p>
</body>
</html>