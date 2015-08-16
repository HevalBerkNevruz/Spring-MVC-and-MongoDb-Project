<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Infonal Question</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css" />"/>
    <script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"></script>
    <script src="<c:url value="/resources/js/jquery.inputmask.js" />"></script>
    <script src="<c:url value="/resources/js/index.js" />"></script>
</head>
<body>

<h4>Başında yıldız bulunan alanları doldurmak zorunludur.</h4>
<img class="ajax-gif" src="<c:url value="/resources/images/ajax-loader.gif" />" alt=""/>
<form:form id="userForm" method="POST" modelAttribute="user" commandName="user">
    <table>
        <tr>
            <th>Kullanıcı Ekle</th>
        </tr>
        <tr>
            <td>Id :</td>
            <td>*<form:input path="id"/></td>
        </tr>
        <tr>
            <td>Ad :</td>
            <td>*<form:input path="userName"/></td>
        </tr>
        <tr>
            <td>Soyad :</td>
            <td>*<form:input path="userSurname"/></td>
        </tr>
        <tr>
            <td>Telefon Numarası :</td>
            <td><form:input path="telephoneNumber" size="10"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <label for="captcha"><img src="captcha.jpg" id="imgCaptcha"/></label> <br/>
                *<input type="text" name="captcha" id="captcha" value="" class="text ui-widget-content ui-corner-all">
            </td>
        </tr>
        <tr>
            <td>
                <button>Kullanıcı Ekle</button>
            </td>
        </tr>
    </table>
</form:form>

<table id="userList">
    <tr>
        <th>
            Kullanıcı Listesi
        </th>
    </tr>
    <c:forEach var="user" items="${userList}">
        <table id="${user.id}">
            <tr>
                <td>Id : ${user.id}</td>
            </tr>
            <tr>
                <td>Ad : ${user.userName}</td>
            </tr>
            <tr>
                <td>Soyad : ${user.userSurname}</td>
            </tr>
            <tr>
                <td>Telefon : ${user.telephoneNumber}</td>
            </tr>
            <tr>
                <td>
                    <a name="edituser"
                       onclick="editUser('${user.id}','${user.userName}','${user.userSurname}','${user.telephoneNumber}')">Güncelle</a>
                </td>
                <td>
                    <a name="deleteuser" onclick="deleteUser('${user.id}')">Sil</a>
                </td>
            </tr>
        </table>
    </c:forEach>

</table>
<div class="modal-dialog">
    <form:form id="editForm" method="POST" modelAttribute="user" commandName="user">
        <form:hidden path="id"/>
        <table>
            <tr>
                <td>Ad :</td>
                <td><form:input path="userName"/></td>
            </tr>
            <tr>
                <td>Soyad :</td>
                <td><form:input path="userSurname"/></td>
            </tr>
            <tr>
                <td>Telefon :</td>
                <td><form:input path="telephoneNumber" size="10"/></td>
            </tr>
            <tr>
                <td>
                    <button>Güncelle</button>
                </td>
                <td>
                    <button type="button" id="cancel">İptal</button>
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>