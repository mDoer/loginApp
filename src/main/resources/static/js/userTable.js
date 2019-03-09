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

              $('.modal-body').load('/users',function(){
                  $('#myModal').modal({show:true});
              });

          alert( 'You clicked on '+data.name+'\'s row' );
      } );

});


