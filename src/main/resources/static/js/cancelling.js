function cancelReservation(projection_id){
    var id=sessionStorage.getItem("id");

    var formData = JSON.stringify({
        "clan_id": id,
        "odrzavanje_id": projection_id,
    });
    $.ajax({
        url: '/cancel_reservation',
        dataType: 'json',
        type: 'delete',
        contentType: 'application/json',
        data: formData,
        success: function(){
            window.location.replace("/profil/"+id+"/prijavljen");
        },
        error: function(){
            window.location.replace("/profil/"+id+"/prijavljen");
        }
    });

}