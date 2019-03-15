$(document).ready(function() {

    document.getElementById("submitCreate").addEventListener("click",  function () {
         var data = userTable.row( this ).data();
          $('.modal-dialog').load('/users/create',function(){
          $('#modalCreateUser').modal({show:true});
           });
       } );


});