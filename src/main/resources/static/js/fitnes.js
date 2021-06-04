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
function filterData(treninziDTO)
{
    var naziv = document.getElementById("naziv").value;
    var tip_treninga = document.getElementById("tip_treninga").value;
    var trajanje = document.getElementById("trajanje").value;
    var ocena = document.getElementById("ocena").value;
    var opis = document.getElementById("opis").value;
    var cena = document.getElementById("cena").value;
    var filter = [];
    var treninzi=treninziDTO.treninzi;
    for(let i=0; i<treninzi.length; i++){
        document.getElementById(treninzi[i].id).style.display="";
    }

    if(naziv!="")
        filter["treningName"]= naziv;

    if(tip_treninga!="Tip")
        filter["tip"] = tip_treninga;

    if(ocena != "")
        filter["ocena"] = ocena;

    if(opis != "")
        filter["opis"]= opis;

    if(cena != "")
        filter["cena"]= cena;

    if(tajanje!="")
        filter["trajanje"]= trajanje;

    for(const [kljuc, vrednost] of Object.entries(filter)) {
        filterOne(treninzi, kljuc, vrednost);
    }
}

function filterOne(treninzi, kljuc, vrednost){
    for(let i=0 ; i< treninzi.length;i++)
    {
        finalFilter(treninzi[i],kljuc, vrednost);
    }
}

function finalFilter(trening,key,value)
{
    if(document.getElementById(trening.id).style.display=="none")
    {
        return;
    }
    let flag=false;
    if(key=="cena"){
        for(let i=0;i<trening.odrzavanje.length;i++){
            if(parseInt(value)>=trening.odrzavanje[i].cena)
                flag=true;
        }
    }
    else if(key=="trajanje"){
        let help=value.split(":");
        for(let i=0;i<trening.length;i++)
        {
            let arr=trening[i].trajanje.split(":");
            if(parseInt(help[0])>=parseInt(arr[0]))
            {
                if(parseInt(help[1])>=parseInt(arr[1]))
                    flag=true;
            }
        }
    }
    else if(key=="ocena"){
        if(parseFloat(value)<=parseFloat(trening.ocena))
            flag=true;
    }else if(key=="naziv"){
        if(trening.naziv.toLowerCase().indexOf(value.toLowerCase())>-1)
            flag=true;
    }else if(key=="opis"){
        if(trening.opis.toLowerCase().indexOf(value.toLowerCase())>-1)
            flag=true;
    }else if(key=="tip_treninga"){
        if(value!="tip")
        {
            if(movie.tip==value)
                flag=true;
        }
        else
            flag=true;
    }

    if(flag){
        document.getElementById(trening.id).style.display="";
    }
    else{
        document.getElementById(trening.id).style.display="none";
    }


}