<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %> 
<fieldset>
<legend>阶段性总结第一年</legend>
<table>
    <tr>
        <td class="labelname">教学情况及反思</td>
        <td>${sl1.rethink}</td>
    </tr>
    <tr>
        <td class="labelname">课改实践</td>
        <td>${sl1.practice}</td>
    </tr>
    <tr>
        <td class="labelname">听评课情况</td>
        <td>${sl1.learnEachOther}</td>
    </tr>
    <tr>
        <td class="labelname">开设校本科情况</td>
        <td>${sl1.schoolBasedEdu}</td>
    </tr>
    <tr>
        <td class="labelname">读书情况</td>
        <td>${sl1.reading}</td>
    </tr>
    <tr>
        <td class="labelname">班主任经历</td>
        <td>${sl1.classExperience}</td>
    </tr>
    <tr>
        <td class="labelname">家访</td>
        <td>${sl1.visitHome}</td>
    </tr>
    <tr>
        <td class="labelname">突出贡献</td>
        <td>${sl1.devote}</td>
    </tr>
    <tr>
        <td class="labelname">其他</td>
        <td>${sl1.remark}</td>
    </tr>
</table>
</fieldset>