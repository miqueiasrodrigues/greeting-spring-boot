package br.com.rodrigues;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodrigues.exceptions.UnsupportedMathOperationException;

@RestController
public class GreetingController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong(); 
	
	@GetMapping("/greeting")
	
	public Greeting greeting(
			@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@GetMapping(value = "/calculator/{operation}/{num1}/{num2}")
	public Double calculator(
			@PathVariable(value = "num1") String num1,
	        @PathVariable(value = "num2") String num2,
	        @PathVariable(value = "operation") String operation
	) throws Exception {
	    if(!Validate.isNumeric(num1) || !Validate.isNumeric(num2)) {
	    	throw new UnsupportedMathOperationException("Please set a numeric value!");
	    }

	    Calculator calculator = new Calculator(Convert.toDouble(num1), Convert.toDouble(num2));
	    
	    double result;
	    
	    switch(operation) {
	    case "sum":
            result = calculator.sum();
            break;
	    case "sub":
            result = calculator.sub();
            break;
        case "mult":
            result = calculator.mult();
            break;
        case "div":
        	result = calculator.div();
            break;
        default:
            throw new Exception("Operation not supported: " + operation);
	    }
	    
	    return result;
	}

	

	
}
