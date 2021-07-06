function registerManager() {
    let email = document.getElementById("email1").value;
    let ime = document.getElementById('ime').value;
    let prezime = document.getElementById('prezime').value;
    let kontakt_broj = document.getElementById('kontakt_broj').value;
    let lozinka = document.getElementById('lozinka1').value;
    let korisnicko_ime = document.getElementById('korisnicko_ime').value;
    let datum_rodjenja=document.getElementById('datum_rodjenja').value;
    let fitnes=document.getElementById('fitnes').value;
    let id=sessionStorage.getItem("id");

    var formData = JSON.stringify({
        "email": email,
        "ime": ime,
        "kontakt_broj":kontakt_broj,
        "prezime":prezime,
        "lozinka":lozinka,
        "korisnicko_ime":korisnicko_ime,
        "datum_rodjenja":datum_rodjenja,
        "uloga":1,
        "aktivnost":true,
        "fitnes_id":fitnes
    });
    $.ajax({
        url: '/registracija-tren',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
        success: function(data){
            window.location.replace("/profil/"+id+"/treneri");
        },
        error: function( jqXhr, textStatus, errorThrown ){
            window.location.replace("/profil/"+id+"/treneri");
        }
    });

}
function managers(){
    var id=sessionStorage.getItem("id");
    window.location.replace("/profil/"+id+"/treneri");
}
function createManager(){
    var id=sessionStorage.getItem("id");
    window.location.replace("/profil/"+id+"/registracija-trenera");
}
function deleteManager(trener_id){
    let id=sessionStorage.getItem("id");
    $.ajax({
        url: '/ukloni-trenera/'+trener_id,
        dataType: 'json',
        type: 'delete',
        contentType: 'application/json',
        success: function(){
            window.location.replace("/profil/"+id+"/treneri");
        },
        error: function(){
            window.location.replace("/profil/"+id+"/treneri");
        }
    });
}

function showAll(korisnik) {
    for(let i = 0; korisnik.odradjen_trening.length;i++){
        document.getElementById(korisnik.odradjen_trening[i].id).style.display="";
    }
}

function showRated(korisnik){
    showAll(korisnik);
    for(let i=0;i<korisnik.odradjen_trening.length;i++){
        if(korisnik.odradjen_trening[i].ocena!=0)
            document.getElementById(korisnik.odradjen_trening[i].id).style.display="";
        else
            document.getElementById(korisnik.odradjen_trening[i].id).style.display="none";
    }
}

function showUnrated(korisnik){
    showAll(korisnik);
    for(let i=0;i<korisnik.odradjen_trening.length;i++){
        if(korisnik.odradjen_trening[i].ocena==0)
            document.getElementById(korisnik.odradjen_trening[i].id).style.display="";
        else
            document.getElementById(korisnik.odradjen_trening[i].id).style.display="none";
    }
}