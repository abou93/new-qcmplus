<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:textarea name="q.intitule" key="Label.intitule"/>
		<br>

		<!-- DEBUT affichage reponses -->
		
		
			<s:textfield name="reponse1.libelle"/><s:checkbox name="reponse1.estCorrecte"/>
			<s:textfield name="reponse2.libelle"/><s:checkbox name="reponse2.estCorrecte"/>
			<s:textfield name="reponse3.libelle"/><s:checkbox name="reponse3.estCorrecte"/>
			<s:textfield name="reponse4.libelle"/><s:checkbox name="reponse4.estCorrecte"/>
			<s:textfield name="reponse5.libelle"/><s:checkbox name="reponse5.estCorrecte"/>
			
		

		<!-- FIN affichage reponses -->