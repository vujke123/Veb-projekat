function AddTrening(fitnes_id){
    var id=sessionStorage.getItem("id");
    let trening=document.getElementById("trening").value;
    let sala=document.getElementById("sala").value;
    let datum=document.getElementById("date").value;
    let vreme=document.getElementById("time").value;
    let cena=document.getElementById("price").value;
    var formData = JSON.stringify({
        "room_id": sala,
        "trening_id": trening,
        "day":datum,
        "time":vreme,
        "price":cena,
        "fitnes_id":fitnes_id
    });
    $.ajax({
        url: '/add_trening',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
        complete: function (xhr, status) {
            if (status === 'error') {
                alert("Something's wrong!");
            }
            else {
                window.location.replace("/profil/"+id+"/addTrening");
            }
        }
    });
}