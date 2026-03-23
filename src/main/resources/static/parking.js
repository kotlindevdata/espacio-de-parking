function cancel()
{
    window.location.href='/';
}

function editSpot(spotId, button)
{
    var table = document.getElementById('tblSpots');
    var row = table.rows.namedItem(spotId);
    var textBoxes = row.getElementsByTagName('input');
    var selectOptions = row.getElementsByTagName('select');

    for (var i = 1; i < textBoxes.length; i++) {
        textBoxes[i].disabled = false;
    }
    for (var k = 0; k < selectOptions.length; k++) {
        selectOptions[k].disabled = false;
    }
}

function enableTextBoxesAndUpdate(form)
{
    var table = document.getElementById('tblSpots');
    var rows = table.rows;

    for(var j = 1; j < rows.length; j++) {
        var textBoxes = rows[j].getElementsByTagName('input');
        var selectOptions = rows[j].getElementsByTagName('select');
        for (var i = 0; i < textBoxes.length; i++) {
            textBoxes[i].disabled = false;
        }
        for (var k = 0; k < selectOptions.length; k++) {
            selectOptions[k].disabled = false;
        }
    }


    form.submit();
}

function removeSpot(spotId,form)
{
    form.action += '?deleteSpot=true';
    var table = document.getElementById('tblSpots');
    var row = table.rows.namedItem(spotId);
    table.deleteRow(row.rowIndex);
    enableTextBoxesAndUpdate(form);
}
