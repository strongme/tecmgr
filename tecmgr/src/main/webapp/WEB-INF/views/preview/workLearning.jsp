<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %> 
<fieldset>
<legend>青年教师</legend>
  <table>
    	<tr>
    		<th>时间</th>
    		<th>师傅姓名</th>
    		<th>学习情况</th>
    		<th>取得成绩</th>
    		<th>证明材料</th>
    		<th>备注</th>
    	</tr>
    	<tbody>
    	<j:forEach items="${workLearning}" var="wlearning">
    		<tr>
    			 <td class="short">${wlearning.time}</td>
	            <td class="short">${wlearning.name}</td>
	            <td class="short">${wlearning.guideInfo}</td>
	            <td class="short">${wlearning.award}</td>
	            <td class="short">${wlearning.proff}</td>
	            <td>${wlearning.remark}</td>
    		</tr>
    		</j:forEach>
    	</tbody>
    	</table>
</fieldset>