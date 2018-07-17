
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
                              }
                          },
                       }
                    ],
               'select': {'style': 'multi'},
               'order': [[1, 'asc']],
               "initComplete": function () {

                  //    $( document ).on("click", "tr[role='row']", function(){
                  //          var row = $(this).closest('tr');
                  //          var data = $('#example').dataTable().fnGetData();
                  //      });
               }

   });





     $('#save_table').on('click', function(e){
      var form = this;

      var tableData = $('#example').dataTable().fnGetData()

      var rows_selected = table.column(0).checkboxes.selected();
      // Iterate over all selected checkboxes

      var fndata = $('#example').dataTable().fnGetData();
      console.log(fndata);


      $.each(rows_selected, function(index, rowId){
            var id = table.row( this ).id();
            console.log(rowId);
            console.log(index);

            var rowData = $.grep(tableData, function(obj){return obj.id === rowId;})[0];

            // set granted value if checked
         //    data.isGranted = true;
             console.log(rowData.isGranted);
          //   $(form).append($('<input>').attr('type', 'hidden').attr('name', 'roleprivilege[]').val(JSON.stringify(data)));

      });
   });
});


