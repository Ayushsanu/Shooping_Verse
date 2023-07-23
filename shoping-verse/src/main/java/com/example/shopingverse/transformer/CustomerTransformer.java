package com.example.shopingverse.transformer;

import com.example.shopingverse.dto.RequestDto.CustomerRequestDto;
import com.example.shopingverse.dto.ResponseDto.CustomerResponseDto;
import com.example.shopingverse.model.Customer;

public class CustomerTransformer {
    public static Customer customerRequestDtoTocustomer(CustomerRequestDto customerRequestDto){
        return Customer.builder().name(customerRequestDto.getName())
                .gender(customerRequestDto.getGender())
                .mobNo(customerRequestDto.getMobNo())
                .emailId(customerRequestDto.getEmailId()).build();
    }
    public static CustomerResponseDto customerToCustomerResponseDto(Customer customer){
        return CustomerResponseDto.builder()
                .name(customer.getName())
                .emailId(customer.getEmailId())
                .mobNo(customer.getMobNo())
                .gender(customer.getGender())
                .build();
    }
}
