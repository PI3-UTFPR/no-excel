window.onload = function(){
	jQuery(function($){
		$('input[name=login]').on('input', function (event) { 
		    this.value = this.value.replace(/[^0-9]/g, '');
		});

		$('#value').maskMoney();
		$('input[name=value]').maskMoney();
		$("select[name=type]").change(function(){
			var value = $(this).val();
			if(value != "Aluno")
				$("[name=showColleger]").hide();
			else
				$("[name=showColleger]").show();
		});	
		
		$('.editar').click(function(){
			$('.registro').show("fade-in");
		});
		
			
	});
}