$(document).ready(function() {

    $('#example').DataTable( {
        "columnDefs": [{
        "defaultContent": "-",
        "targets": "_all"
      }],
        "ajax":{
                "url": "users/api/getusers",
                "method": "GET",
                "contentType": "application/json",
                "dataSrc": "result"
            },
            "columnDefs": [
                { "title": "id", "targets": 0 , 'bVisible': false},
                { "title": "Name", "targets": 1 },
                { "title": "Last Name", "targets": 2 },
                { "title": "Email", "targets": 3 },
                { "title": "Active", "targets": 4, 'bVisible': false }
              ],
            "aoColumns": [
                                {'mData': 'id', 'sType': 'string', 'bVisible': false},
                                {'mData': 'name', 'sType': 'string', 'bVisible': true},
                                {'mData': 'lastName', 'sType': 'string', 'bVisible': true},
                                 {'mData': 'email', 'sType': 'string'},
                                {'mData': 'active', 'sType': 'string', 'bVisible': false}
                                ],
             "initComplete": function () {
                         $( document ).on("click", "tr[role='row']", function(){
                              var row = $(this).closest('tr');
                                      var data = $('#example').dataTable().fnGetData(row);
                                      window.location.href = '/user/' + data.id;
                         });
                     }

    } );
} );

