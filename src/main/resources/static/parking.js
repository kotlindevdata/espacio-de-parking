function cancel()
{
    window.location.href='/';
}

function editSpot(spotId, button)
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
