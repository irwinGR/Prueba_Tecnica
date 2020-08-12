var table;
$(function() {
	console.log('inicia JS');
	initDataTable();
	initEVentos();
});

function initDataTable(){
	$.ajax({
        async: true,
        method : "POST",
		url : ctx + '/organizacionController/getOrganizaciones',
        
        success: function (data) {
            table = $('#dtOrganizacion').DataTable({
                "searching": true,
                fixedHeader: true,
                destroy: true,
                data: data,
                columns: [
                	{ data: "idExterno" },
                	{ data: "nombre" }
                ],
                "sDom": "<'dt-toolbar'<'col-xs-12 col-sm-6 hidden-xs'l><'col-sm-6 col-xs-12 hidden-xs'<'toolbar'>>r>"
                    + "t"
                    + "<'dt-toolbar-footer'<'col-sm-6 col-xs-12 hidden-xs'i><'col-xs-12 col-sm-6'p>>",
                deferRender: true,
                "pageLength": 5,
                "language": {
                    "url": "//cdn.datatables.net/plug-ins/1.10.19/i18n/Spanish.json"
                }

            });


        }
    });
}
function initEVentos(){
	
	$('#btnPlus').click(function() {

		$('#divActividad').hide('fast',function() {
			$('#divCrear').show('fast',function() {
				$('#nombreAcividad').html('<b>Registro de Organizacion </b>');
			});
        });
		
		validacion();
	});
	
	$('#fmOrganizaciones')[0].reset();
	$('#fmOrganizaciones').bootstrapValidator('destroy');
	
	$('#codigo').keypress(function (event) {
      if (event.which < 48 || event.which > 57 || this.value.length === 4) {
        return false;
      }
    });
	
	$('#btnCancel').click(function() {
		$('#divCrear').hide('fast', function() {
			$('#divActividad').show('fast', function() {
				$('#fmOrganizaciones')[0].reset();
				$('#fmOrganizaciones').bootstrapValidator('destroy');

				validacion();
			});
		});
	});
	
	$('#btnSave').click(function() {

		$('#fmOrganizaciones').data('bootstrapValidator').validate();
		var n = $('#fmOrganizaciones').data('bootstrapValidator').isValid();
		if (n) {
			saveActividad();

		} else {

			validacion();
		}
	});
	
}

function validacion() {
	$('#fmOrganizaciones')
			.bootstrapValidator(
					{
						live : 'enabled',
						submitButtons : 'button[id="btnSave"]',
						message : 'Valor invalido',
						// excluded: ':disabled',
						fields : {
							nombreO : {
								group : '.col-md-6',
								selector : '#nombreO',
								validators : {
									notEmpty : {
										message : 'El Nombre es obligatorio.'
									}
								}
							},
							direccion : {
								group : '.col-md-6',
								selector : '#direccion',
								validators : {
									notEmpty : {
										message : 'La Direccion es obligatoria.'
									}
								}
							},
							telefono : {
								group : '.col-md-6',
								selector : '#telefono',
								validators : {
									notEmpty : {
										message : 'El Telefono es obligatorio.'
									}
								}
							},
							codigo : {
								group : '.col-md-6',
								selector : '#codigo',
								validators : {
									notEmpty : {
										message : 'El Codigo es obligatorio.'
									}
								}
							}
							

						}
					});
}
function saveActividad(){
	$('#btnSave').prop("disabled", true);
	$.ajax({
		type : "POST",
		url : ctx + '/organizacionController/addOrganizacion',
		data : {
			idExterno:"ff",
			nombre:$("#nombreO").val(),
			direccion:$("#direccion").val(),
			codigo:$("#codigo").val(),
			telefono:$("#telefono").val()
		},
		success : function(data) {
			showOkMessage('¡Operación Exitosa!', 'Actividad Guardada. <b>');
			$('#divCrear').hide('fast', function() {
				$('#divActividad').show('fast', function() {
				});
			});
			$('#btnSave').prop("disabled", false);
			$('#fmOrganizaciones').bootstrapValidator('destroy');
		}
	});
}
function idExterno(){
	var cadenaNombre = $("#nombreO").val();
	var cadenaTelefono = $("#telefono").val();
}