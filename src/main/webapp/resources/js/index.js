$(function () {

    $("#telephoneNumber").mask("(999)999-99-99")

    $("#cancel").click(function () {
        $(".modal-dialog").hide(1000);
    });

    $("#userForm").submit(function (e) {
        var id = $("#id").val();
        var userName = $("#userName").val();
        var userSurname = $("#userSurname").val();
        var telephoneNumber = $("#telephoneNumber").val();
        var captcha = $("#captcha").val();
        telephoneNumber = telephoneNumber.replace(/\D/g, '');
        var json = {"id": id, "userName": userName, "userSurname": userSurname, "telephoneNumber": telephoneNumber};

        if (id == "" || userName == "" || userSurname == "" || captcha == "") {
            alert("Lütfen Gerekli Alanları Doldurunuz");
            return false;
        } else {
            $.ajax({
                url: "/newuser/" + captcha,
                data: JSON.stringify(json),
                type: "POST",
                contentType: 'application/json; charset=utf-8',
                dataType: 'json',

                beforeSend: function () {
                    $(".ajax-gif").show();
                },
                error: function () {
                    $(".ajax-gif").hide(1000);
                },
                success: function (data) {
                    $(".ajax-gif").hide(1000);
                    $("#userList").last().append("" +
                    "<tr>" +
                        "<td>Id : " + data.id + "</td>" +
                    "</tr>" +
                    "<tr>" +
                        "<td>Ad : " + data.userName + "</td>" +
                    "</tr>" +
                    "<tr>" +
                        "<td>Soyad : " + data.userSurname + "</td>" +
                    "<tr>" +
                        "<td>Telefon : " + data.telephoneNumber + "</td>" +
                    "</tr>" +
                    "<tr>" +
                        "<td><a name=edituser onclick=editUser(" + data.id + "," + data.userName + "," + data.userSurname + "," + data.telephoneNumber + ")>Güncelle</a></td>" +
                        "<td><a name=deleteuser onclick=deleteUser(" + data.id + ")>Sil</a></td>" +
                    "</tr>");
                }
            });
        }
        e.preventDefault();
    });

    $("#editForm").submit(function (e) {
        var id = $("#editForm #id").val();
        var userName = $("#editForm #userName").val();
        var userSurname = $("#editForm #userSurname").val();
        var telephoneNumber = $("#editForm #telephoneNumber").val();
        var json = {"id": id, "userName": userName, "userSurname": userSurname, "telephoneNumber": telephoneNumber};
        if (userName == "" || userSurname == "") {
            alert("Lütfen Gerekli Alanları Doldurunuz");
        } else {
            $.ajax({
                url: "/edituser",
                data: JSON.stringify(json),
                type: "POST",
                contentType: 'application/json; charset=utf-8',
                dataType: 'json',
                beforeSend: function () {
                    $(".ajax-gif").show();
                },
                error: function () {
                    $(".ajax-gif").hide(1000);
                },
                success: function (data) {
                    $("#" + id).remove();
                    $(".ajax-gif").hide(1000);
                    $("#userList").last().append("" +
                    "<tr>" +
                        "<td>Id : " + data.id + "</td>" +
                    "</tr>" +
                    "<tr>" +
                        "<td>Ad : " + data.userName + "</td>" +
                    "</tr>" +
                    "<tr>" +
                        "<td>Soyad : " + data.userSurname + "</td>" +
                    "<tr>" +
                        "<td>Telefon : " + data.telephoneNumber + "</td>" +
                    "</tr>" +
                    "<tr>" +
                        "<td><a name=edituser onclick=editUser(" + data.id + "," + data.userName + "," + data.userSurname + "," + data.telephoneNumber + ")>Güncelle</a></td>" +
                        "<td><a name=deleteuser onclick=deleteUser(" + data.id + ")>Sil</a></td>" +
                    "</tr>");
                    $(".modal-dialog").hide(1000);
                }
            });
        }
        e.preventDefault();
    });
});

function deleteUser(id) {
    if (confirm("Bu Kayıtı Silmek İstediğinizden Emin Misiniz?")) {
        $.ajax({
            url: "/deleteuser/" + id,
            type: "DELETE",
            beforeSend: function () {
                $(".ajax-gif").show();
            },
            error: function () {
                $(".ajax-gif").hide(1000);
            },
            success: function () {
                $("#" + id).remove();
                $(".ajax-gif").hide(1000);

            }
        });
    } else {
        return false;
    }
}

function editUser(id, name, surname, number) {
    $("#editForm #telephoneNumber").mask("(999)999-99-99")
    $(".modal-dialog").show(1000);
    $("#editForm #id").val(id);
    $("#editForm #userName").val(name);
    $("#editForm #userSurname").val(surname);
    $("#editForm #telephoneNumber").val(number);
}