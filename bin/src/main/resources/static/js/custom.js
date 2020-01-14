//show input data from the form in the modal window
function showCollab() {
		 $(".modal-body").html('<p>Nom : '+ $("#formCtrlNom").val()+'<br>'+
	                'Prénom : '+$("#formCtrlPrenom").val()+'<br>'+
		    	    'Addresse : '+$("#formCtrlAdresse").val()+'<br>'+
		    		'Numéro de sécurité sociale :'+$("#formCtrlNSS").val()+'</p>');
	 };
//submit from the modal
 function form_submit(){
	document.creerCollabForm.submit();
}
