$(document).ready(function(){
	$("a[name='cart']").click(function(){
		$.ajax({
			url : $("#url").val()+"/AddToCart?Q="+$(this).parent().find('select[id="quantity"]').val()+"&d="+$($(this.parentElement.parentElement.parentElement.parentElement).find('a')[0]).find('img').data('imageid'),
			dataType:"json",
			success : function(result) {
				$("#CART").html("["+result.split('=')[1]+"]");
			},
			error : function(result) {
				$("#CART").html("["+result.responseText.split('=')[1]+"]");
			}
		});
	});
	
	
	$("a[id='remove']").click(function(){
		$.ajax({
			url : $("#url").val()+"/RemoveFromCart?cid="+$(this).data('params'),
			dataType:"json",
			success : function(result) {
				$("#CART").trigger('click');
			},
			error : function(result) {
				$("#CART").trigger('click');
			}
		});
	});
	
	   $('.quantity-right-plus').click(function(e){
		   var quantityTemp=0.0;        
	        // Stop acting like a button
	        e.preventDefault();
	        // Get the field name
	        var quantity = parseFloat($(this.parentElement).find('.quantity').val());
	        
	        // If is not undefined
	        quantityTemp = quantity+parseFloat(0.10); 
	        $(this.parentElement).find('.quantity').val(quantityTemp.toFixed(2));
	        calculateAmount(this);
	          
	            // Increment
	        
	    });

	     $('.quantity-left-minus').click(function(e){
	    	 var quantityTemp=0.0;
	    	 
	    	 // Stop acting like a button
	        e.preventDefault();
	        // Get the field name
	        var quantity = parseFloat($(this.parentElement).find('.quantity').val()).toFixed(2);
	        
	        // If is not undefined
	      
	            // Increment
	            if(quantity>0){
	            	quantityTemp = quantity-parseFloat(0.10); 
	            	$(this.parentElement).find('.quantity').val(quantityTemp.toFixed(2));
	            	calculateAmount(this);
	            }
	    });
	     
	     $("input[name='quantity']").change(function(){
	    	var enteredVal = $(this).val();
	    	$(this.parentElement).find('.quantity').val(parseInt(enteredVal));
	    	calculateAmount(this);
	     });
	     
	     function calculateAmount(_this){
	    	 var qntnty = parseFloat($($($(_this)).parent().find('.quantity')).val()).toFixed(2);
	    	 var amount = parseFloat($($($($(_this)).parent().parent().parent()).find('td[class="price"]')).text()).toFixed(2);
	    	 var total = parseFloat(0);
	    	 total = qntnty*amount;
	    	 $($($($(_this)).parent().parent().parent()).find('td[class="total"]')).text(parseFloat(qntnty*amount).toFixed(2));
	    	 var totalAmt = parseFloat(0);
	    	 for(var i=0;i<$($($($($(_this)).parent().parent().parent())).parent()).find('tr td[class="total"]').length;i++){
	    		 totalAmt = totalAmt + parseFloat($($($($($($($(_this)).parent().parent().parent())).parent()).find('tr td[class="total"]'))[i]).text());	    		 
	    	 }
	    	 $("#subTotal").text(totalAmt);
	    	 $("#finalAmt").text((parseFloat($("#subTotal").text()) + parseFloat($("#shipping").text())) - parseFloat($("#discount").text()));
	     }
	     
     
});
