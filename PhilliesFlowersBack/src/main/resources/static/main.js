$(document).ready(function() {
	$(".payForm").submit(function(e) {
		values = $(this).serializeArray();
		submitPayment(values[0].value, values[1].value, values[2].value);
		e.preventDefault();
	});
	
	$("#locales").change(function () {
        var selectedOption = $('#locales').val();
        if (selectedOption != ''){
            window.location.replace('?lang=' + selectedOption);
        }
    });
});

function submitPayment(payment, order, token) {
	$.ajax({
		type: "POST",
		url: "payOrder",
		data: {
			payment: payment,
			order: order,
			token: token
		},
		dataType : 'json',
		error: function() {
			window.location.replace("/error");
		},
		success : function(data) {
			if(data.code==1)
				window.location.replace("/dash");
			else if(data.code==2)
				alert("Payment could not be completed");
			else if(data.code==3)
				window.location.replace("/login");
			$(".token").html($(".token").attr("title"));
		}
	});
}