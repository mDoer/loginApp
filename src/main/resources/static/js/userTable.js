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



    document.getElementById("addUserButton").addEventListener("click", function() {
          alert("User create dialog");
      }, false);

});


