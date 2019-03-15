$(document).ready(function() {
  var userTable = $('#userOverviewTable').DataTable({
                "ajax":{
                        "url": "users/api/getusers",
                        "method": "GET",
                        "contentType": "application/json",
                        "dataSrc": ""
                    },
                "columns": [
                    { "data": "name" },
                    { "data": "lastName" },
                    { "data": "username" },
                    { "data": "email" }
                ]
  });

  $('#userOverviewTable tbody').on('click', 'tr', function () {
          var data = userTable.row( this ).data();

              $('.modal-dialog').load('/users/user/' + data.id,function(){
                  $('#myModal').modal({show:true});
              });
      } );


    document.getElementById("addUserButton").addEventListener("click",  function () {
          $('.modal-dialog').load('/users/create',function(){
          $('#modalCreateUser').modal({show:true});
           });
           jQuery.getScript("/userCreate.js")
           	.done(function() {
           		/* yay, all good, do something */
           	})
           	.fail(function() {
           		/* boo, fall back to something else */
           });
       } );


});


