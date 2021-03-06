exec = function(evt){
	var obj = {pass : $("#password").val() };
	$.get("/password/score",obj,
		  function(data){
			$("#score").text(data.score + "%");
			$("#complexity").text(data.complexity);
			var css = "";
			var score = data.score;
			if(score <=20) css = "label label-danger";
			else if(score <=40) css="label label-warning";
			else if(score <=60) css="label label-primary";
			else if(score <=80) css="label label-info";
			else css="label label-success";
			$("#complexity").removeClass().addClass(css);
		}
	);
};


$('#password').keyup(exec);