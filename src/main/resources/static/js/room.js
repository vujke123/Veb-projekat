function addRoom(fitnes_id){

    var id=sessionStorage.getItem("id");
    let kapacitet=document.getElementById("kapacitet").value;
    let oznaka=document.getElementById("oznaka").value;
    var formData = JSON.stringify({
        "oznaka": oznaka,
        "kapacitet": kapacitet,
        "fitnes_id":fitnes_id
    });
    $.ajax({
        url: '/dodaj_sobu',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
        complete: function (xhr, status) {
            if (status === 'error') {
                alert("Something's wrong!");
            }
            else {
                window.location.replace("/profil/"+id+"/fitnes");
            }
        }
    });

}
function deleteRoom(soba_id,fitnes_id){

    var id=sessionStorage.getItem("id");
    $.ajax({
        url: '/brisanje_sobe/'+fitnes_id+'/soba/'+soba_id,
        dataType: 'json',
        type: 'delete',
        complete: function (xhr, status) {
            if (status === 'error') {
                alert("Something's wrong!");
            }
            else {
                window.location.replace("/account/"+id+"/cinema");
            }
        }
    });

}
function editRoom(room_id){

    var id=sessionStorage.getItem("id");
    let kapacitet=document.getElementById("kapacitet").value;
    let oznaka=document.getElementById("oznaka").value;
    var formData = JSON.stringify({
        "id":room_id,
        "oznaka": oznaka,
        "kapacitet": kapacitet,
    });
    $.ajax({
        url: '/izmena_sobe',
        dataType: 'json',
        type: 'put',
        contentType: 'application/json',
        data: formData,
        complete: function (xhr, status) {
            if (status === 'error') {
                alert("Something's wrong!");
            }
            else {
                window.location.replace("/profil/"+id+"/fitnes");
            }
        }
    });

}
function edit(room_id){
    let id=sessionStorage.getItem("id");
    window.location.replace("/profil/"+id+"/fitnes/soba/"+room_id);
}
function fitnes(){
    let id=sessionStorage.getItem("id");
    window.location.replace("/profil/"+id+"/fitnes");
}
function dodaj(){
    let id=sessionStorage.getItem("id");
    window.location.replace("/profil/"+id+"/addTrening");
}
