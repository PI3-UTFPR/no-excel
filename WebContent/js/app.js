$.material.init();

$(function () {
	$('#value').maskMoney();
	$('#date').bootstrapMaterialDatePicker({ format : 'DD/MM/YYYY', weekStart : 0, time: false, lang : 'pt-br', cancelText : 'Cancelar'});
	$('#type').change(function(){	
		if($('#type').val() == "Aluno"){
			$('#showColleger').fadeIn();
		}else{
			$('#showColleger').fadeOut();
		}
	});
});
