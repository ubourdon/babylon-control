( function() {

    describe( 'log diplaying',
        function() {
            it( '1. should display pretty log when checkbox not checked', function() {
                setFixtures( '<input type="checkbox" id="decorate" />' +
                    '<p id="raw"></p><p style="display: none;" id="pretty"></p>' );

                LOG.displayPrettyLog()
                $( '#decorate' ).click();

                expect( $( '#raw' ).css( 'display' ) ).toEqual( 'none' );
                return expect( $( '#pretty' ).css( 'display' ) ).toEqual( 'block' );
            } );

            it( '2. should hide pretty log when checkbox is checked', function() {
                setFixtures( '<input type="checkbox" id="decorate"  checked="checked" />' +
                    '<p style="display: none;" id="raw"></p><p" id="pretty"></p>' );

                LOG.displayPrettyLog()
                $( '#decorate' ).click();

                expect( $( '#raw' ).css( 'display' ) ).toEqual( 'block' );
                return expect( $( '#pretty' ).css( 'display' ) ).toEqual( 'none' );
            } );
        } );
} ).call( this );