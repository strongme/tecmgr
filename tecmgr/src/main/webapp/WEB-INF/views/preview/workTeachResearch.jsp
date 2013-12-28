<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %> 
<fieldset>
<legend>教学科研</legend>
  <table>
    	<tr>
    		<th>时间</th>
    		<th>课题名称</th>
    		<th>立项部门</th>
    		<th>本人承担责任</th>
    		<th>结题情况</th>
    		<th>证明材料</th>
    		<th>备注</th>
    	</tr>
    	<tbody>
    	<j:forEach  items="${workTeachResearch}" var="wtr">
    		<tr>
    			<td class="short">${wtr.time}</td>
	            <td class="short">${wtr.name}</td>
	            <td class="short">${wtr.org}</td>
	            <td class="short">${wtr.role}</td>
	            <td class="short">${wtr.finishedDetails}</td>
	            <td class="short">${wtr.proff}</td>
	            <td>${wtr.remark}</td>
    		</tr>
    		</j:forEach>
    	</tbody>
    	</table>
</fieldset>