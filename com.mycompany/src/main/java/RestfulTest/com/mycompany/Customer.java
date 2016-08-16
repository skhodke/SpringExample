package RestfulTest.com.mycompany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String name;
public Customer(){	}
public Customer(Long id,String name){
	this.id = id;
	this.name = name;
}
public Long getId(){
	return id;
}

public void setId(Long id){
	this.id = id;
}

public String getName(){
	return name;
}

public void setNAme(String name){
	this.name = name;
}

}
