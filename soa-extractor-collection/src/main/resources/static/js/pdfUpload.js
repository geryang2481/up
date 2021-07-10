$(document).ready(function() {

	$('#btnUploadFile').attr("disabled", true);
	$("#customFile").change(function() {
		var fileName = $(this).val().replace(/C:\\fakepath\\/i, '');

		var ext = fileName.split('.').pop().toLowerCase();

		if (ext == 'csv'|| ext == 'tsv' || ext == 'xls' || ext == 'html') {
			$("#customFileHolder").val(fileName);
			$('#btnUploadFile').removeAttr("disabled");
		}
	});

	if ($('#divUploadSuccess').is(':visible')) {
		$('#divUploadSuccess').show(0).delay(10000).hide(0);
	}

	listPdfUploadedFiles();
	
});

function listPdfUploadedFiles() {
	$.ajax({
		url : $('#urlPdfFileList').val(),
		error : function() {
			$('#filePdfList').html('<p>An error has occurred</p>');
		},
		success : function(data) {
			$('#filePdfList').html(data);
		},
		type : 'GET'
	});
}
