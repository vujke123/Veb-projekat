function initTreninzi(){

    let id = sessionStorage.getItem("id");
    let offline=document.getElementById("offline");
    let online=document.getElementsByClassName("online");
    let viewer=document.getElementsByClassName("viewer");
    if (id == null) {
        for (let i = 0; i < online.length; i++) {
            online[i].style.display = "none";
        }
        offline.style.display="block";
        for (let i = 0; i < viewer.length; i++) {
            viewer[i].style.display = "none";
        }

    } else {
        let uloga=sessionStorage.getItem("uloga");
        if (uloga == "CLAN") {
            for (let i = 0; i < viewer.length; i++) {
                viewer[i].style.display = "";
            }

        } else {
            for (let i = 0; i < viewer.length; i++) {
                viewer[i].style.display = "none";
            }

        }
        for (let i = 0; i < online.length; i++) {
            online[i].style.display = "";
        }
        offline.style.display="none";
    }
}

function initAcc(){

    let id = sessionStorage.getItem("id");
    let offline=document.getElementById("offline");
    let online=document.getElementsByClassName("online");
    let clan=document.getElementsByClassName("clan");
    let admin=document.getElementsByClassName("admin");
    let trener=document.getElementsByClassName("trener");
    if (id == null) {
        for (let i = 0; i < online.length; i++) {
            online[i].style.display = "none";
        }
        offline.style.display="block";
        for (let i = 0; i < clan.length; i++) {
            clan[i].style.display = "none";
        }
        for (let i = 0; i < admin.length; i++) {
            admin[i].style.display = "none";
        }
        for (let i = 0; i < trener.length; i++) {
            trener[i].style.display = "none";
        }
        alert("You have to be logged in to view your profile!");
        window.location.replace("/");
    } else {
        let role=sessionStorage.getItem("uloga");
        if (role == "CLAN") {
            for (let i = 0; i < clan.length; i++) {
                clan[i].style.display = "";
            }
            for (let i = 0; i < admin.length; i++) {
                admin[i].style.display = "none";
            }
            for (let i = 0; i < trener.length; i++) {
                trener[i].style.display = "none";
            }
        } else if(role=="ADMIN"){
            for (let i = 0; i < clan.length; i++) {
                clan[i].style.display = "none";
            }
            for (let i = 0; i < admin.length; i++) {
                admin[i].style.display = "";
            }
            for (let i = 0; i < trener.length; i++) {
                trener[i].style.display = "none";
            }
        }else{
            for (let i = 0; i < clan.length; i++) {
                clan[i].style.display = "none";
            }
            for (let i = 0; i < admin.length; i++) {
                admin[i].style.display = "none";
            }
            for (let i = 0; i < trener.length; i++) {
                trener[i].style.display = "";
            }
        }


        for (let i = 0; i < online.length; i++) {
            online[i].style.display = "";
        }
        offline.style.display="none";
    }
}
