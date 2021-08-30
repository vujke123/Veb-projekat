function registerRoom() {
    let kapacitet = document.getElementById("kapacitet").value;
    let oznaka_sale = document.getElementById('oznaka_sale').value;
    let id=sessionStorage.getItem("id");

    var formData = JSON.stringify({
        "kapacitet": kapacitet,
        "oznaka_sale": oznaka_sale
    });
    $.ajax({
        url: '/registracija-sal',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
        success: function(data){
            window.location.replace("/profil/"+id+"/sale");
        },
        error: function( jqXhr, textStatus, errorThrown ){
            window.location.replace("/profil/"+id+"/sale");
        }
    });

}

function editR(sala_id) {
    window.location.replace("/sala/" + sala_id);
}

function editRoom(sala_id) {

    let oznaka_sale = document.getElementById("oznaka_sale").value;
    let kapacitet = document.getElementById("kapacitet").value;
    let id=sessionStorage.getItem("id");
    var formData = JSON.stringify({
        "id": sala_id,
        "oznaka_sale": oznaka_sale,
        "kapacitet": kapacitet
    });
    $.ajax({
        url: '/uredi_salu',
        dataType: 'json',
        type: 'put',
        contentType: 'application/json',
        data: formData,
        complete: function (xhr, status) {
            if (status === 'error') {
                alert("Something's wrong!");
            } else {
                window.location.replace("/profil/" +id+ "/sale");
            }
        }
    });
}

function createRoom(){
    var id = sessionStorage.getItem("id");
    window.location.replace("/profil/"+id+"/registracija-sale");
}
function viewRoom() {
    var id=sessionStorage.getItem("id");
    window.location.replace("/profil/" +id+ "/sale");
}

function fitnes(){
    let id=sessionStorage.getItem("id");
    window.location.replace("/profil/"+id+"/fitnes");
}
function dodaj(){
    let id=sessionStorage.getItem("id");
    window.location.replace("/profil/"+id+"/addTrening");
}
