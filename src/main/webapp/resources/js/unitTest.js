

var unitTest = function(arg){
	
    var param= arg.param;
    var unit = arg.unit;
    var startTime;
    var endTime;
    var result={};
    var error;
    
      
    function test(){
    	
    	startTime= new Date();
    	try{    	
    		endTime= new Date();
    		result["result"]=unit(param);
    		result["duration"]=endTime-startTime;
    	}catch(e){
    		result[error]=e;
    	}
    	return result;
    }	
	
	return {
		test: test		
	}
}