$(document).ready(function() {
	$(".payForm").submit(function(e) {
		values = $(this).serializeArray();
		submitPayment(values[0].value, values[1].value, values[2].value);
		e.preventDefault();
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
		dataType : 'text',
		error: function() {
			alert("Error Occured");
		},
		success : function(data) {
			alert(data);
			window.location.replace("/dash");
		}
	});
}