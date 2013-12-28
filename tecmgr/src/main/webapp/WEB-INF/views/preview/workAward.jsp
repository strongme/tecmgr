<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %> 
<fieldset>
<legend>教学竞赛</legend>
<table>
    	<tr>
    		<th>时间</th>
    		<th>竞赛名称</th>
    		<th>所获奖项</th>
    		<th>组织单位</th>
    		<th>证明材料</th>
    		<th>备注</th>
    	</tr>
    	<tbody>
    	<j:forEach items="${workAward}" var="wAward">
    		<tr>
    			<td class="short">${wAward.time}</td>
	            <td class="short">${wAward.name}</td>
	            <td class="short">${wAward.award}</td>
	            <td class="short">${wAward.org}</td>
	            <td class="short">${wAward.proff}</td>
	            <td>${wAward.remark}</td>
    		</tr>
    		</j:forEach>
    	</tbody>
    	</table>
</fieldset>