<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %> 
<fieldset>
<legend>交流支教</legend>
  <table>
    	<tr>
    		<th>时间</th>
    		<th>原学校</th>
    		<th>交流支教学校</th>
    		<th>证明材料</th>
    		<th>备注</th>
    	</tr>
    	<tbody>
    		<j:forEach items="${workCommSupport}" var="wcs">
    		<tr>
    			<td class="short">${wcs.time}</td>
	            <td class="short">${wcs.originalSch}</td>
	            <td class="short">${wcs.exchang}</td>
	            <td class="short">${wcs.proff}</td>
	            <td>${wcs.remark}</td>
    		</tr>
    		</j:forEach>
    	</tbody>
    	</table>
</fieldset>