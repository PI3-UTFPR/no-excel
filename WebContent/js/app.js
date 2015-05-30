$.material.init();

$(function () {
	$('#valueIpt').maskMoney();
	$('#date').bootstrapMaterialDatePicker({ format : 'DD/MM/YYYY', weekStart : 0, time: false, lang : 'pt-br', cancelText : 'Cancelar'});
});
