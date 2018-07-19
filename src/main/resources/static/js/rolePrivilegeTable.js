
$(document).ready(function (){

    var rolePermissions=[];

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

                                rolePermissions.push(rowData);

                                if(rowData.isGranted === true){
                                 this.api().cell(td).checkboxes.select();
                              }
                          },
                       }
                    ],
               'select': {'style': 'multi'},
               'order': [[1, 'asc']],
               "initComplete": function () {

               }

   });


     $('#save_table').on('click', function(e){
      var form = this;
      var tableData = $('#example').dataTable().fnGetData()
      var rows_selected = table.column(0).checkboxes.selected();
      var fndata = $('#example').dataTable().fnGetData();

       rolePermissions.forEach(function(element) {
          element.isGranted=false;
        });


      $.each(rows_selected, function(index, rowId){
          //  var id = table.row( this ).id();
            var rowData = $.grep(tableData, function(obj){return obj.id === rowId;})[0];
            rowData.isGranted=true;
            console.log(JSON.stringify(rowData));
      });
                  $.ajax({
                  			type : "POST",
                  			contentType : "application/json",
                  			url : "/roles/api/roleprivilegemapping",
                  			data : JSON.stringify(rolePermissions),
                  			dataType : 'json',
                  			success : function(result) {

                  			},
                  			error : function(e) {
                  				alert("Error!")
                  				console.log("ERROR: ", e);
                  			}
                  		});
   });
});
