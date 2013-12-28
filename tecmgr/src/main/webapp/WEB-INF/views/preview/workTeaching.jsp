<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %> 
<fieldset>
<legend>指导学生</legend>
  <table>
    	<tr>
    		<th>时间</th>
    		<th>学生人数</th>
    		<th>指导情况</th>
    		<th>获奖情况</th>
    		<th>证明材料</th>
    		<th>备注</th>
    	</tr>
    	<tbody>
    		<j:forEach items="${workTeaching}" var="wt">
    		<tr>
    			 <td class="short">${wt.time}</td>
	            <td class="short">${wt.stunum}</td>
	            <td class="short">${wt.learnGuide}</td>
	            <td class="short">${wt.honour}</td>
	            <td class="short">${wt.proff}</td>
	            <td>${wt.remark}</td>
    		</tr>
    		</j:forEach>
    	</tbody>
    	</table>
</fieldset>