function cancel()
{
    window.location.href='/';
}

function editSpot(spotId)
{
    var table = document.getElementById('tblSpots');
    var row = table.rows.namedItem(spotId);
    var textBoxes = row.getElementsByTagName('input');
    for (var i = 0; i < textBoxes.length; i++) {
        textBoxes[i].disabled = false;
    }
}



function enableTextBoxes(form)
{
    var table = document.getElementById('tblSpots');
    var rows = table.rows;

    for(var j = 0; j < rows.length; j++) {
        var textBoxes = rows[j].getElementsByTagName('input');
        for (var i = 0; i < textBoxes.length; i++) {
            textBoxes[i].disabled = false;
        }
    }
    form.submit();
}

function removeSpot(spotId)
{
  //  alert('Removing spot with index: ' + spotId);
    var table = document.getElementById('tblSpots');
    var row = table.rows.namedItem(spotId);
    table.deleteRow(row.rowIndex);
}


function newSpot()
{
    var table = document.getElementById('tblSpots');
    var newIndex = table.rows.length-1;
    var row = table.insertRow(-1);
    row.id = newIndex;

    // Cell for id
    var cell1 = row.insertCell(0);
    var input1 = document.createElement('input');
    input1.name = 'parking.spots[' + newIndex + '].id';
    input1.id = 'parking.spots[' + newIndex + '].id';
    input1.disabled = true;
    cell1.appendChild(input1);

    // Cell for type
    var cell2 = row.insertCell(1);
    var input2 = document.createElement('input');
    input2.name = 'parking.spots[' + newIndex + '].type';
    input2.id = 'parking.spots[' + newIndex + '].type';
    input2.disabled = true;
    cell2.appendChild(input2);

    // Cell for location
    var cell3 = row.insertCell(2);
    var input3 = document.createElement('input');
    input3.name = 'parking.spots[' + newIndex + '].location';
    input3.id = 'parking.spots[' + newIndex + '].location';
    input3.disabled = true;
    cell3.appendChild(input3);

    // Cell for pricePerHour
    var cell4 = row.insertCell(3);
    var input4 = document.createElement('input');
    input4.name = 'parking.spots[' + newIndex + '].pricePerHour';
    input4.id = 'parking.spots[' + newIndex + '].pricePerHour';
    input4.disabled = true;
    cell4.appendChild(input4);

    // Cell for buttons
    var cell5 = row.insertCell(4);
    var btnEdit = document.createElement('button');
    btnEdit.type = 'button';
    btnEdit.textContent = 'Edit';
    btnEdit.onclick = function() { editSpot(newIndex); };
    cell5.appendChild(btnEdit);

    var btnRemove = document.createElement('button');
    btnRemove.type = 'button';
    btnRemove.textContent = 'Remove';
    btnRemove.onclick = function() { removeSpot(newIndex); };
    cell5.appendChild(btnRemove);
}

//to add new spot
//https://developer.mozilla.org/en-US/docs/Web/API/HTMLTableElement/insertRow