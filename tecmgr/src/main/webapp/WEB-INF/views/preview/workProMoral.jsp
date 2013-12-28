<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %> 
<fieldset>
<legend>教师职业道德</legend>
  <table>
    	<tr>
    		<th>时间</th>
    		<th>有偿家教</th>
    		<th>体罚学生</th>
    		<th>接受财务</th>
    		<th>违规订资料</th>
    		<th>备注</th>
    	</tr>
    	<tbody>
    	<j:forEach items="${workProMoral}" var="wpm">
	    	<tr>
    		<td class="short">${wpm.time}</td>
            <td class="short">
            <j:if test="${wpm.famEdu==1}">是</j:if>
            <j:if test="${wpm.famEdu==0}">否</j:if>
            </td>
            <td class="short">
            <j:if test="${wpm.phyPunishiment==1}">是</j:if>
            <j:if test="${wpm.phyPunishiment==0}">否</j:if>
            </td>
            <td class="short">
             <j:if test="${wpm.financialRelation==1}">是</j:if>
            <j:if test="${wpm.financialRelation==0}">否</j:if>
            </td>
            <td class="short">
              <j:if test="${wpm.reference==1}">是</j:if>
            <j:if test="${wpm.reference==0}">否</j:if>
            </td>
            <td>${wpm.remark}</td>
	    	</tr>
	    	</j:forEach>
   		</tbody>
    	</table>
</fieldset>