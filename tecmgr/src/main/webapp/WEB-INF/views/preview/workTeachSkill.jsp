<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %> 
<fieldset>
<legend>教育技术培训</legend>
  <table>
	   		<tr>
	    		<th>时间</th>
	    		<th>级别</th>
	    		<th>培训形式</th>
	    		<th>学习成绩</th>
	    		<th>证明材料</th>
	    		<th>备注</th>
	    	</tr>
	    	<tbody>
	    	<j:forEach items="${workTeachSkill}" var="wts">
	    		<tr>
	    			<td class="short">${wts.time}</td>
		            <td class="short">${wts.class_}</td>
		            <td class="short">${wts.form}</td>
		            <td class="short">${wts.score}</td>
		            <td class="short">${wts.proff}</td>
		            <td>${wts.remark}</td>
	    		</tr>
	    		</j:forEach>
	    	</tbody>
	    </table>
</fieldset>