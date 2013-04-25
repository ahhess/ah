function getBurvMandantTemplate() {
    $.ajax({
        url: "tmpl/burvmandant.tmpl",
        dataType: "html",
        success: function( data ) {
            $( "head" ).append( data );
            updateBurvMandantTable();
        }
    });
}

/* Builds the updated table for the burvmandant list */
function buildBurvMandantRows(burvmandants) {
    return _.template( $( "#burvmandant-tmpl" ).html(), {"burvmandants": burvmandants});
}

/* Uses JAX-RS GET to retrieve current burvmandant list */
function updateBurvMandantTable() {
    $.ajax({
        url: "rest/burvmandants",
        cache: false,
        success: function(data) {
            $('#burvmandants').empty().append(buildBurvMandantRows(data));
        },
        error: function(error) {
            //console.log("error updating table -" + error.status);
        }
    });
}

/*
Attempts to save a new BurvMandant using a JAX-RS POST.  The callbacks
the refresh the BurvMandant table, or process JAX-RS response codes to update
the validation errors.
 */
function saveBurvMandant(burvMandantData) {
    //clear existing  msgs
    $('span.invalid').remove();
    $('span.success').remove();

    $.ajax({
        url: 'rest/burvmandants',
        contentType: "application/json",
        dataType: "json",
        type: "POST",
        data: JSON.stringify(burvMandantData),
        success: function(data) {
            //console.log("BurvMandant saved");

            //clear input fields
            $('#reg')[0].reset();

            //mark success on the registration form
            $('#formMsgs').append($('<span class="success">BurvMandant saved</span>'));

            updateBurvMandantTable();
        },
        error: function(error) {
            if ((error.status == 409) || (error.status == 400)) {
                //console.log("Validation error saving user!");

                var errorMsg = $.parseJSON(error.responseText);

                $.each(errorMsg, function(index, val) {
                    $('<span class="invalid">' + val + '</span>').insertAfter($('#' + index));
                });
            } else {
                //console.log("error - unknown server issue");
                $('#formMsgs').append($('<span class="invalid">Unknown server error</span>'));
            }
        }
    });
}
