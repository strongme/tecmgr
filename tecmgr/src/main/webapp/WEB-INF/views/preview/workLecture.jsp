<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %> 
<fieldset>
<legend>开课讲座</legend>
<table>
    <tr>
        <th>时间</th>
			<th>名称</th>
			<th>开课/讲座范围</th>
			<th>组织单位</th>
			<th>证明材料</th>
			<th>备注</th>
    </tr>
    <tbody>
      <j:forEach items="${workLecture}" var="wLecture">
      	  <tr>
      	  	 <td class="short">${wLecture.time}</td>
            <td class="short">${wLecture.name}</td>
            <td class="short">${wLecture.range}</td>
            <td class="short">${wLecture.org}</td>
            <td class="short">${wLecture.proff}</td>
            <td>${wLecture.remark}</td>
        </tr>
      </j:forEach>
    </tbody>
</table>
</fieldset>