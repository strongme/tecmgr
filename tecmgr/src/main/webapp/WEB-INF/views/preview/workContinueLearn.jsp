<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %> 
<fieldset>
<legend>继续教育</legend>
 <table>
    	<tr>
    		<th>时间</th>
    		<th>内容成绩</th>
    		<th>主办单位</th>
    		<th>证明材料</th>
    		<th>备注</th>
    	</tr>
    	<tbody>
    	<j:forEach items="${workContinueLearn}" var="wcl">
    		<tr>
    			<td class="short">${wcl.time}</td>
	            <td class="short">${wcl.contentAndScore}</td>
	            <td class="short">${wcl.org}</td>
	            <td class="short">${wcl.proff}</td>
	            <td>${wcl.remark}</td>
    		</tr>
    		</j:forEach>
    	</tbody>
    	</table>
</fieldset>