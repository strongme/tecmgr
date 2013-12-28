<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %> 
<fieldset>
<legend>总体成长规划</legend>
<table>
    <tr>
        <td class="labelname">教职工编号</td>
        <td class="short">${wholeGrowPlan.teacherId}</td>
        <td class="labelname">时间</td>
        <td class="short">${wholeGrowPlan.planTime}</td>
    </tr>
    <tr>
        <td class="labelname">我的教学理念</td>
        <td colspan="3">${wholeGrowPlan.eduIdea}</td>
    </tr>
    <tr>
        <td class="labelname">优势分析</td>
        <td colspan="3">${wholeGrowPlan.advanced}</td>
    </tr>
    <tr>
        <td class="labelname">不足分析</td>
        <td colspan="3">${wholeGrowPlan.disadvanced}</td>
    </tr>
    <tr>
        <td class="labelname">我的成长规划</td>
        <td colspan="3">${wholeGrowPlan.planDetail}</td>
    </tr>
    <tr>
        <td class="labelname">备注</td>
        <td colspan="3">${wholeGrowPlan.remark}</td>
    </tr>
</table>
</fieldset>