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