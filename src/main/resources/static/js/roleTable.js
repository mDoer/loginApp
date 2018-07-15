$(document).ready(function() {

    $('#example').DataTable( {
        "columnDefs": [{
        "defaultContent": "-",
        "targets": "_all"
      }],
        "ajax":{
                "url": "roles/api/getroles",
                "method": "GET",
                "contentType": "application/json",
                "dataSrc": "result"
            },
            "columnDefs": [
                { "title": "id", "targets": 0 , 'bVisible': false},
                { "title": "Role", "targets": 0 }
              ],
            "aoColumns": [
                                {'mData': 'id', 'sType': 'string', 'bVisible': false},
                                {'mData': 'role', 'sType': 'string', 'bVisible': true}
                                ],
             "initComplete": function () {
                         $( document ).on("click", "tr[role='row']", function(){
                              var row = $(this).closest('tr');
                                      var data = $('#example').dataTable().fnGetData(row);
                                      window.location.href = '/role/' + data.id;
                         });
                     }

    } );
} );

