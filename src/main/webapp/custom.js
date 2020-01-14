//show input data from the form in the modal window
function showCollab() {
	if($('formCtrlNom').val() !="" &&
	        $('formCtrlPrenom').val() != '' &&
	        $('amount').val() != '' &&
	        $('BeneficiaryName').val() != '' &&
	        $('BeneficiaryBank').val() != '' &&
	        $('BeneficiaryAccount').val() != '' &&
	        $('PaymentReference').val() != '') {

	        $(".modal-body").html('<p>Nom : '+ $("#formCtrlNom").val()+'<br>'+
	                'Prénom : '+$("#formCtrlPrenom").val()+'<br>'+
		    	    'Addresse : '+$("#formCtrlAdresse").val()+'<br>'+
		    		'Numéro de sécurité sociale :'+$("#formCtrlNSS").val()+'</p>');
	}else{
		$('.modal.fade').modal('hide')
	}
};
//submit from the modal
 function form_submit(){
	document.creerCollabForm.submit();
}
