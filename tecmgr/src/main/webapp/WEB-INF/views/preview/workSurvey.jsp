<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %> 
<fieldset>
<legend>调研督导</legend>
 <table>
    	<tr>
    		<th>时间</th>
    		<th>工作内容</th>
    		<th>组织单位</th>
    		<th>证明材料</th>
    		<th>备注</th>
    	</tr>
    	<tbody>
    	<j:forEach items="${workSurvey}" var="wSurvey">
    		<tr>
    			<td class="short">${wSurvey.time}</td>
	            <td class="short">${wSurvey.jobDetails}</td>
	            <td class="short">${wSurvey.org}</td>
	            <td class="short">${wSurvey.proff}</td>
	            <td>${wSurvey.remark}</td>
    		</tr>
   		</j:forEach>
		</tbody>
		</table>
</fieldset>