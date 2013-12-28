<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %> 
<fieldset>
<legend>阶段性总结</legend>
<table>
    <tr>
        <td class="labelname">教职工编号</td>
        <td class="short">${periodGrowPlan.teacherId}</td>
        <td class="labelname">时间</td>
        <td class="short">${periodGrowPlan.timeZone}</td>
    </tr>
    <tr>
        <td class="labelname">成长规划</td>
         <td colspan="3">${periodGrowPlan.growPlan}</td>
    </tr>
    <tr>
        <td class="labelname">达到的目标</td>
        <td colspan="3">${periodGrowPlan.selfCheckRealized}</td>
    </tr>
    <tr>
        <td class="labelname">未达到的目标</td>
        <td colspan="3">${periodGrowPlan.selfCheckUnrealized}</td>
    </tr>
    <tr>
        <td class="labelname">目标修订</td>
        <td colspan="3">${periodGrowPlan.goalRevise}</td>
    </tr>
    <tr>
        <td class="labelname">备注</td>
        <td colspan="3">${periodGrowPlan.remark}</td>
    </tr>
</table>
</fieldset>