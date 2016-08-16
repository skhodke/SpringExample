package RestfulTest.com.mycompany;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	 protected final Logger log = LoggerFactory.getLogger(this.getClass());
	private static List<Customer> list = new ArrayList<Customer>();
	static{
		list.add(new Customer(1l,"Jonny"));
		list.add(new Customer(2l,"Tim"));
	}
	
	@RequestMapping(value="",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Customer> getAllCustomers(){
		return list;
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Customer getCustomer(@PathVariable("id") Long id){
		for(Customer c:list){
			if(c.getId().equals(id))
				return c;
		}
		return null;
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	@ResponseBody
	public void addCustomer(@RequestBody Customer customer){
		
		list.add(customer);
	}

}
