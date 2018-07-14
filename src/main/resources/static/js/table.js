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
                { "title": "Name", "targets": 0 },
                { "title": "Last Name", "targets": 1 },
                { "title": "Email", "targets": 2 },
                { "title": "Active", "targets": 3, 'bVisible': false }
              ],
            "aoColumns": [
                                {'mData': 'name', 'sType': 'string', 'bVisible': true},
                                {'mData': 'lastName', 'sType': 'string', 'bVisible': true},
                                 {'mData': 'email', 'sType': 'string'},
                                {'mData': 'active', 'sType': 'string', 'bVisible': false}
                                ],
            "initComplete": function () {
                        $( document ).on("click", "tr[role='row']", function(){
                             alert($(this).children('td:first-child').text())
                        });
                    }
    } );
} );

