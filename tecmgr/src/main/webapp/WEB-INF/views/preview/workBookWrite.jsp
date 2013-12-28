<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %> 
<fieldset>
<legend>论文论著编写</legend>
  <table>
    	<tr>
    		<th>时间</th>
    		<th>文著名称|教材名称</th>
    		<th>承担部分</th>
    		<th>出版发表获奖|交流情况</th>
    		<th>证明材料</th>
    		<th>备注</th>
    	</tr>
    	<tbody>
    	<j:forEach items="${workBookWrite}" var="wbw">
    		<tr>
    			<td class="short">${wbw.time}</td>
	            <td class="short">${wbw.name}</td>
	            <td class="short">${wbw.role}</td>
	            <td class="short">${wbw.publicAndHonour}</td>
	            <td class="short">${wbw.proff}</td>
	            <td>${wbw.remark}</td>
    		</tr>
    		</j:forEach>
    	</tbody>
    	</table>
</fieldset>