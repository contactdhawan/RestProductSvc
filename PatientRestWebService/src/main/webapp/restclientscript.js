function doGet(){
	$.ajax({
		type:"GET",
		contentType:"application/json",
		accept: "application/json",
		dataType:"json",
		url:"http://localhost:8090/PatientRestWebService/services/patients/patient/"+$('#patientId').val(),
		}).then(function(data){
			$('#patientId').val(data.id);
			$('#pateintName').val(data.name);
		});
}
function doPost(){
	$.ajax({
		type:"POST",
		contentType:"application/json",
		dataType:"json",
		data:JSON.stringify({name:$('#pateintName').val()}),
		url:"http://localhost:8090/PatientRestWebService/services/patients/patient/"
	}).then(function(data){
		$('#patientId').val(data.id);
		$('#pateintName').val(data.name);
	});
}
function doDelete(){
	$.ajax({
		type:"DELETE",
		contentType:"application/json",
		dataType:"json",
		url:"http://localhost:8090/PatientRestWebService/services/patients/patient/"+$('#patientId').val(),
		}).then(function(data){
			alert('Patient Deleted');
		});
}
function doUpdate(){
	$.ajax({
		type:"PUT",
		contentType:"application/json",
		accept: "application/json",
		dataType:"json",
		data:JSON.stringify({id:$('#patientId').val(),name:$('#pateintName').val()}),
		url:"http://localhost:8090/PatientRestWebService/services/patients/patient/"
	}).then(function(data){
		$('#patientId').val(data.id);
		$('#pateintName').val(data.name);
	});
}
