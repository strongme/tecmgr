<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %> 
<fieldset>
<legend>基本信息</legend>
<table>
    <tr>
        <td class="labelname">编号</td>
        <td class="short">${teacherBasicInfo.teacherId}</td>
        <td class="labelname">性别</td>
        <td class="short">
        <j:if test="${teacherBasicInfo.gender==1 }">男</j:if>
        <j:if test="${teacherBasicInfo.gender==0}">女</j:if>
        </td>
        <td class="labelname">籍贯</td>
        <td class="short">${teacherBasicInfo.native_}</td>
        <td rowspan="4" class="labelname">${teacherBasicInfo.photo}</td>
    </tr>
    <tr>
        <td class="labelname">出生年月</td>
        <td class="short">${teacherBasicInfo.birth}</td>
        <td class="labelname">民族</td>
        <td class="short">${teacherBasicInfo.nation}</td>
        <td class="labelname">政治面貌</td>
        <td class="short">${teacherBasicInfo.politicsStatus}</td>
    </tr>
    <tr>
        <td class="labelname">学科专业</td>
        <td colspan="2" class="short">${teacherBasicInfo.subject}</td>
        <td class="labelname">最高学历</td>
        <td colspan="2" class="short">${teacherBasicInfo.highestDegree}</td>
    </tr>
    <tr>
        <td class="labelname">职称</td>
        <td colspan="2" class="short">${teacherBasicInfo.professionalTitle}</td>
        <td class="labelname">职务</td>
        <td colspan="2" class="short">${teacherBasicInfo.position}</td>
    </tr>
     <tr>
         <td class="labelname">联系电话</td>
         <td class="short">${teacherBasicInfo.phone}</td>
         <td class="labelname">邮箱/QQ号</td>
         <td class="short">${teacherBasicInfo.email}/${teacherBasicInfo.qq}</td>
         <td class="labelname">所在单位</td>
         <td colspan="2" class="short">${teacherBasicInfo.departmentName}</td>
     </tr>
     <tr>
         <td class="labelname">特长/才艺</td>
         <td colspan="6">${teacherBasicInfo.talent}</td>
     </tr>
    <tr>
        <td class="labelname">其他情况</td>
        <td colspan="6"><p>${teacherBasicInfo.remark2}</p></td>
    </tr>
    <tr>
        <td class="labelname">表彰奖励/荣誉称号情况</td>
        <td colspan="6" ><p>${honourInfo.honourDetail}</p></td>
    </tr>
</table>
</fieldset>