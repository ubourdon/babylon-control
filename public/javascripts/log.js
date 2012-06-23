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
        },

        fullScreen: function() {
            return $( document ).keypress( function(e) {
                if( e.which === X_KEY && e.ctrlKey === true ) {
                    var documentWidth = $( document ).innerWidth();
                    var documentHeight = $( document ).innerHeight();

                    $( '#displayLog' ).css( { 'position':'absolute', 'top':'0', 'left':'0', 'width':documentWidth + 'px', 'height':documentHeight + 'px' } );
                };

                if( e.keyCode === ESCAPE_KEY ) {
                    $( '#displayLog' ).css( { 'position':'static', 'width':'auto', 'height':'400px' } );
                }

                //console.log( e.which, e.altKey, e.ctrlKey, e.metaKey, e.keyCode );
            } );
        }
    }

    var X_KEY = 120;
    var ESCAPE_KEY = 27;
} ).call( this );