<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %> 
<fieldset>
<legend>工作经验</legend>
<table>
    <tr>
        <th>起始年月</th>
        <th>终止年月</th>
        <th>单位部门</th>
        <th>职务职称</th>
        <th>备注</th>
    </tr>
    <tbody>
    <j:forEach items="${workExpInfo }" var="we">
        <tr>
            <td class="short">${we.startTime}</td>
            <td class="short">${we.endTime}</td>
            <td class="short">${we.uintOrDepartment}</td>
            <td class="short">${we.postOrProtitle}</td>
            <td class="short">${we.remark3}</td>
        </tr>
       </j:forEach>
    </tbody>
</table>
</fieldset>