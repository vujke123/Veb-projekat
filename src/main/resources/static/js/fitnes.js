function sortTable(n) {
    var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
    table = document.getElementById("Treninzi");
    switching = true;
    dir = "asc";
    var thead=document.getElementById("th"+n);
    thead.classList.add('fa-sort-asc');
    while (switching) {
        switching = false;
        rows = table.rows;
        for (i = 1; i < (rows.length - 1); i++) {
            shouldSwitch = false;
            x = rows[i].getElementsByTagName("TD")[n];
            y = rows[i + 1].getElementsByTagName("TD")[n];
            if (dir == "asc") {
                if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                    shouldSwitch = true;
                    break;
                }
            } else if (dir == "desc") {
                if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                    shouldSwitch = true;
                    break;
                }
            }
        }
        if (shouldSwitch) {
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
            switchcount ++;
        } else {
            if (switchcount == 0 && dir == "asc") {
                dir = "desc";
                thead.classList.remove('fa-sort-asc');
                thead.classList.add('fa-sort-desc');
                switching = true;
            }
        }
    }
    for (i = 1; i <6 ; i++)
    {
        var trows=document.getElementById("th"+i);
        if(i!=n)
        {
            if(trows.classList.contains('fa-sort-asc')){
                trows.classList.remove('fa-sort-asc');
            } else if(trows.classList.contains('fa-sort-desc')){
                trows.classList.remove('fa-sort-desc');
            }
        }
    }
}
function filterData() {
    var naziv= document.getElementById("treningName").value;
    var formData = JSON.stringify({
        "naziv": naziv,
    });

    console.log(formData);
    $.ajax({
        url: '/pretraga',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
        success: function(data) {
            console.log("seccess");


        },
      });
}

function addFitnes() {
    let id = sessionStorage.getItem("id");
    let email = document.getElementById('emailc').value;
    let naziv = document.getElementById('naziv').value;
    let br_tel_centrale = document.getElementById('br_tel_centrale').value;
    let adresa = document.getElementById('adresa').value;
    var formData = JSON.stringify({
        "email": email,
        "naziv": naziv,
        "br_tel_centrale": br_tel_centrale,
        "adresa": adresa,
        "schedule": null,
        "trener": null,
        "sala": null
    });
    console.log(formData);
    $.ajax({
        url: '/dodaj-fitnes',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
        success: function () {
            console.log("success");
            window.location.replace("/fitnesi");
        },
        error: function (jqXhr, textStatus, errorThrown) {
            if (jqXhr.status == 409) {
                alert("Something went wrong!");
                return;
            }
        }
    });
}

    function deleteFitnes(fitnesi_id) {
        let id = sessionStorage.getItem("id");
        $.ajax({
            url: '/ukloni-fitnes/' + fitnesi_id,
            dataType: 'json',
            type: 'delete',
            success: function () {
                console.log("success");
                window.location.replace("/fitnesi");
            },
            error: function (jqXhr, textStatus, errorThrown) {
                if (jqXhr.status == 409) {
                    alert("Something went wrong!");
                    return;
                }
            }
        });
    }

    function edit(cinema_id) {
        window.location.replace("/fitnes/" + fitnes_id);
    }

    function editCinema(cinema_id) {

        let naziv = document.getElementById("naziv").value;
        let adresa = document.getElementById("adresa").value;
        let br_tel_centrale = document.getElementById("br_tel_centrale").value;
        let email = document.getElementById("email").value;
        var formData = JSON.stringify({
            "id": cinema_id,
            "naziv": naziv,
            "adresa": adresa,
            "email": email,
            "br_tel_centrale": br_tel_centrale,
            "schedule": null,
            "trener": null,
            "sala": null
        });
        $.ajax({
            url: '/uredi-fitnes',
            dataType: 'json',
            type: 'put',
            contentType: 'application/json',
            data: formData,
            complete: function (xhr, status) {
                if (status === 'error') {
                    alert("Something's wrong!");
                } else {
                    window.location.replace("/fitnesi");
                }
            }
        });
}

function getTrening(id) {
    $.ajax( {
        url: '/trening/'+id,
        type: 'get',
        contentType: 'application/json',
        success: function() {
            window.location.replace("/trening"+id);
        },
        error: function() {
            alert("Server error");
            return;
        }
    });
}

