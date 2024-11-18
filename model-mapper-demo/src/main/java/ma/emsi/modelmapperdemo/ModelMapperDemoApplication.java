package ma.emsi.modelmapperdemo;

import ma.emsi.modelmapperdemo.dtos.CustomerDto;
import ma.emsi.modelmapperdemo.dtos.CustomerDtoNew;
import ma.emsi.modelmapperdemo.entities.Customer;
import ma.emsi.modelmapperdemo.mappers.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@SpringBootApplication
public class ModelMapperDemoApplication {
	@Autowired
	private CustomerMapper customerMapper;

	public static void main(String[] args) {
		SpringApplication.run(ModelMapperDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner start(){
		List<Customer> customers = new ArrayList<Customer>(
				Arrays.asList(
						new Customer(1L, "ahmed", "ahmed@exemple.com", "1234"),
						new Customer(2L, "achraf", "achraf@exemple.com", "5678"),
						new Customer(3L, "youssef", "youssef@exemple.com", "91011")
				)
		);
		return args ->{
			for (Customer customer : customers){
				Customer.builder().email(customer.getEmail()).name(customer.getName()).password(customer.getPassword()).build();
			}
			List<CustomerDto> customerDtoList = customers.stream().map(customerMapper::fromCustomer).toList();
			List<CustomerDtoNew> customerDtoNewList = customers.stream().map(customer ->
					customerMapper.fromCustomerToCustomerDtoNew(customer)).toList();
			System.out.println(customerDtoList);
			System.out.println(customerDtoNewList);
		};
	}

}
