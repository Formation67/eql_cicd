package com.formation;

import com.formation.data.entity.CustomerEntity;
import com.formation.data.repository.CustomerRepository;
import com.formation.service.CustomerService;
import com.formation.web.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Incubating;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @InjectMocks
    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    @Test
    void getAllCustomers(){

        // Given
        Mockito.doReturn(getMockCustomers(2)).when(customerRepository).findAll();

        // when
        List<Customer> customers = customerService.getAllCustomers();

        // then
        Assertions.assertEquals(2,customers.size());
    }

    private Iterable<CustomerEntity> getMockCustomers(int size){
        List<CustomerEntity> customers = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            customers.add(new CustomerEntity(UUID.randomUUID(), "firsname"+i,"lastname"+i, "email"+i,"phone"+i,"adresse"+i));
        }
        return customers;
    }
}
