//show input data from the form in the modal window
function showCollab() {
	  $('.name').on('input', function () {
		  event.preventDefault();
		  var val = $(this).val();
	    
		  if(val.length === 0 || val===null) {
			  alert(val.length==0);
			  $('#errMsg').addClass('hidden');
	    	 $('#confirmModal').modal('hide');
	    } 
	    else if (!val.match( /^([a-zA-Z]{2,16})$/)) {
	    	 $('#errMsg').removeClass('hidden');
	     
	      $(".modal-body").html('<p>Nom : '+ $("#formCtrlNom").val()+'<br>'+
	                'Prénom : '+$("#formCtrlPrenom").val()+'<br>'+
		    	    'Addresse : '+$("#formCtrlAdresse").val()+'<br>'+
		    		'Numéro de sécurité sociale :'+$("#formCtrlNSS").val()+'</p>');
	    }else{
	    	 $('#errMsg').addClass('hidden');
	    

	 		        $(".modal-body").html('<p>Nom : '+ $("#formCtrlNom").val()+'<br>'+
	 		                'Prénom : '+$("#formCtrlPrenom").val()+'<br>'+
	 			    	    'Addresse : '+$("#formCtrlAdresse").val()+'<br>'+
	 			    		'Numéro de sécurité sociale :'+$("#formCtrlNSS").val()+'</p>');
	    }
	  });
	};
//submit from the modal
 function form_submit(){
	document.creerCollabForm.submit();
};