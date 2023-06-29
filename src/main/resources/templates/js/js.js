window.onload = function () {

}

$(document).ready(function () {
});

function abc (){
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        data: JSON.stringify(myData),
        url: "http://localhost:8080/account/" + id,
        success: function (data) {
            alert("Update success")
        }
    });
}