function login() {
    let email = document.getElementById('email').value;
    let lozinka = document.getElementById('lozinka').value;
    var formData = JSON.stringify({
        "email": email,
        "lozinka":lozinka
    });

    console.log(formData);
    $.ajax({
        url: '/login',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
        success: function(data){

            sessionStorage.setItem("id", data["id"]);
            sessionStorage.setItem("uloga",data["uloga"]);

            window.location.replace("/profil/"+data["id"]);
        },
        error: function( jqXhr, textStatus, errorThrown ){
            if (jqXhr.status == 404) {
                alert("Email ili lozinka nisu ispravni!");
                return;
            } else  {
                alert("Server error");
                return;
            }

        }
    });
}

function reg() {
    let email = document.getElementById('email').value;
    let ime = document.getElementById('ime').value;
    let prezime = document.getElementById('prezime').value;
    let kontakt_broj = document.getElementById('kontakt_broj').value;
    let datum_rodjenja = document.getElementById('datum_rodjenja').value;
    let korisnicko_ime = document.getElementById('korisnicko_ime').value;
    let lozinka = document.getElementById('lozinka').value;

    var formData = JSON.stringify({
        "email":email,
        "ime": ime,
        "prezime": prezime,
        "kontakt_broj": kontakt_broj,
        "datum_rodjenja" : datum_rodjenja,
        "korisnicko_ime" : korisnicko_ime,
        "lozinka" : lozinka,
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

function profile() {
    var id = sessionStorage.getItem("id");
    window.location.replace("/profil/" + id);
}

function logOut()  {
    sessionStorage.clear();
    window.location.replace("/");
}

function odradjen_trening(){
    var id=sessionStorage.getItem("id");
    window.location.replace("/profil/"+id+"/odradjeni_treninzi");
}

function reservations(){
    var id=sessionStorage.getItem("id");
    window.location.replace("/profil/"+id+"/prijavljen");
}
