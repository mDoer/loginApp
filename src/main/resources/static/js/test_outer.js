$(document).ready(function() {

    document.getElementById("addUserButton").addEventListener("click",  function () {
          $('.modal-dialog').load('/test_inner',function(){
          $('#modalCreateUser').modal({show:true});
           });
           $.getScript( "js/test_inner.js", function( data, textStatus, jqxhr ) {
                                 console.log( data ); // Data returned
                                 console.log( textStatus ); // Success
                                 console.log( jqxhr.status ); // 200
                                 console.log( "Load was performed." );
                               });
       } );
});

