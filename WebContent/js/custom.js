function addRow(elmt, type1, type2, qte)
{
    var ret = true;
    if (qte == "") {
      document.getElementById('qte').parentNode.parentNode.setAttribute('class', "form-group has-error");
      ret = false;
    }
    if (type1 == "Choisissez un type de produit") {
      document.getElementById('sel1').parentNode.parentNode.setAttribute('class', "form-group has-error");
      ret = false;
    }
    if (!ret) {
      return false;
    }
    var tr = document.getElementById(elmt).insertRow(1);
    var td0 = tr.insertCell(0);
    var td1 = tr.insertCell(1);
    var td2 = tr.insertCell(2);

    td0.innerHTML = type1+" - "+type2;
    td1.innerHTML = qte;
    var a = document.createElement('a');
    a.setAttribute('href', '#');
    a.setAttribute('onclick', 'delRow("'+elmt+'", this)');
    td2.appendChild(a);

    var span = document.createElement('span');
    span.setAttribute('class', 'glyphicon glyphicon-remove');
    span.setAttribute('style', 'color:crimson;');
    a.appendChild(span);

    document.getElementById('qte').parentNode.parentNode.setAttribute('class', "form-group");
    document.getElementById('sel1').parentNode.parentNode.setAttribute('class', "form-group");
}

function delRow(tableau, elmt)
{
  document.getElementById(tableau).deleteRow(elmt.parentNode.parentNode.rowIndex);
}

function setActive() 
{
  this.parentNode.setAttribute('class',this.perantNode.getAttribute('class')+' active');
}