( function() {
    this.LOG = {
        displayPrettyLog: function() {
            return $( '#decorate' ).on( 'click', function() {
                if( $( '#decorate' ).attr('checked') !== "checked" ) {
                    $( '#pretty' ).show();
                    $( '#raw' ).hide();
                } else {
                    $( '#pretty' ).hide();
                    $( '#raw' ).show();
                }
            } );
        }

    }
} ).call( this );