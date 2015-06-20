jQuery(function($){
	$("select[name=type]").change(function(){
		var value = $(this).val();
		if(value != "Aluno")
			$("[name=showColleger]").hide();
		else
			$("[name=showColleger]").show();
	})	
});