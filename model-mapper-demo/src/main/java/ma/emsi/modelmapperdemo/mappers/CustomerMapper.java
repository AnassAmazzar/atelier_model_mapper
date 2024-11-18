package ma.emsi.modelmapperdemo.mappers;

import ma.emsi.modelmapperdemo.dtos.CustomerDto;
import ma.emsi.modelmapperdemo.dtos.CustomerDtoNew;
import ma.emsi.modelmapperdemo.entities.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    private ModelMapper mapper = new ModelMapper();

    public CustomerDto fromCustomer(Customer customer){
        return this.mapper.map(customer, CustomerDto.class);
    }
    public CustomerDtoNew fromCustomerToCustomerDtoNew(Customer customer){
        return this.mapper.map(customer, CustomerDtoNew.class);
    }
}
