package org.example.model.mapper;

import org.example.model.entity.Customer;
import org.example.model.vo.CustomerVO;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer fromCustomerVoToEntity(CustomerVO customerVO) {
        return Customer.builder()
                .name(customerVO.name())
                .birthday(customerVO.birthday())
                .build();
    }

    public CustomerVO fromCustomerEntityToVo(Customer customer) {
        return CustomerVO.builder()
                .name(customer.getName())
                .birthday(customer.getBirthday())
                .build();
    }
}
