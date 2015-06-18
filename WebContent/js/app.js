$.material.init();

$(function () {
	$('#value').maskMoney();
	$('input[name=value]').maskMoney(); 
	$('#date').bootstrapMaterialDatePicker({ format : 'DD/MM/YYYY', weekStart : 0, time: false, lang : 'pt-br', cancelText : 'Cancelar'});
	$('#type').change(function(){	
		if($('#type').val() == "Aluno"){
			$('#showColleger').fadeIn();
		}else{
			$('#showColleger').fadeOut();
		}
	});
	$('input[name=ra]').on('input', function (event) { 
	    this.value = this.value.replace(/[^0-9]/g, '');
	});
	
});
