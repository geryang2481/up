 function clicked() {
	       if (confirm('Do you want to submit?')) {
	    	   dbConfigForm.submit();
	       } else {
	           return false;
	       }
	    }