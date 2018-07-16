
$(document).ready(function (){
   var table = $('#example').DataTable({

      "ajax":{
                      "url": "roles/api/roleprivilegemapping",
                      "method": "GET",
                      "data": {"id":1},
                      "contentType": "application/json",
                      "dataSrc": "result"
      },
       "columns": [
                  { "data": "id" },
                  { "data": "privilege.privilege" }
              ],
              'columnDefs': [
                       {
                          'targets': 0,
                          'checkboxes': {'selectRow': true},
                          'createdCell':  function (td, cellData, rowData, row, col){
                                if(rowData.isGranted === true){
                                 this.api().cell(td).checkboxes.select();
                                console.log(JSON.stringify(rowData.data));
                                 console.log(JSON.stringify(table.rows().data));

                              }
                          }
                       }
                    ],
               'select': {'style': 'multi'},
               'order': [[1, 'asc']],


                            "initComplete": function () {
                                        $( document ).on("click", "tr[role='row']", function(){
                                             var row = $(this).closest('tr');
                                                     var data = $('#example').dataTable().fnGetData();
                                                     console.log(JSON.stringify(data));



                                        });
                                    }

   });


console.log(table.rows('selected').data);
   // Handle form submission event
   $('#frm-example').on('submit', function(e){
      var form = this;

      var rows_selected = table.column(0).checkboxes.selected();

      // Iterate over all selected checkboxes
      $.each(rows_selected, function(index, rowId){
         // Create a hidden element
         $(form).append(
             $('<input>')
                .attr('type', 'hidden')
                .attr('name', 'id[]')
                .val(rowId)
         );
      });
   });
});


