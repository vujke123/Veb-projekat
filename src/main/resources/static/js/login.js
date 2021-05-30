function login() {
    let email = document.getElementById('email').value;
    let lozinka = document.getElementById('lozinka').value;
    var formData = JSON.stringify({
        "email": email,
        "lozinka":lozinka
    });

    console.log(formData);
    $.ajax({
        url: '/prijava',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
        success: function(data){

            sessionStorage.setItem("id", data["id"]);
            sessionStorage.setItem("uloga",data["uloga"]);

            window.location.replace("/racun/"+data["id"]);
        },
        error: function( jqXhr, textStatus, errorThrown ){
            if (jqXhr.status == 404) {
                alert("Email nije pronadjen!");
                return;
            } else if (jqXhr.status == 400) {
                alert("Pogresna lozinka");
                return;
            } else if (jqXhr.status == 406) {
                alert("Server error");
                return;
            }
            // default handling
            alert("error")
        }
    });
}

function reg() {
    let email = document.getElementById('email').value;
    let ime = document.getElementById('ime').value;
    let prezime = document.getElementById('prezime').value;
    let broj_telefona = document.getElementById('br_telefona').value;
    let datum_rodjenja = document.getElementById('datum_rodjenja').value;
    let korisnicko_ime = document.getElementById('korisnicko_ime').value;
    let lozinka = document.getElementById('lozinka').value;

    var formData = JSON.stringify({
        "email":email,
        "ime": ime,
        "prezime": prezime,
        "broj_telefona": broj_telefona,
        "datum_rodjenja" : datum_rodjenja,
        "korisicko_ime" : korisnicko_ime,
        "lozinka" : lozinka,
        "uloga" : 0,
        "aktivnost" : false

    });

    console.log(formData);
    $.ajax({
        url: '/registracija-korisnika',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
        success: function(data){
            console.log("seccess");
            sessionStorage.setItem("id", data["id"]);
            sessionStorage.setItem("uloga",data["uloga"]);
            window.location.replace("/profil/"+data["id"]);
        },
        error: function( jqXhr, textStatus, errorThrown ){
            if (jqXhr.status == 409) {
                alert("Something went wrong!");
                return;
            }
        }

    });

}

function logOut()  {
    sessionStorage.clear();
    window.location.replace("/");
}

function profile() {
    var id= sessionStorage.getItem("id");
    window.location.replace("/racun/"+id);
}