package org.work.springbootwork.service.concretes;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.work.springbootwork.core.results.*;
import org.work.springbootwork.dto.CategoryDTO;
import org.work.springbootwork.dto.CustomerDTO;
import org.work.springbootwork.model.Category;
import org.work.springbootwork.model.Customer;
import org.work.springbootwork.repository.CustomerRepository;
import org.work.springbootwork.service.abstracts.ICustomerService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    @Override
    public DataResult<List<CustomerDTO>> getAllCustomer() {
        List<Customer> customer = customerRepository.findAll();
        List<CustomerDTO> customerDTOS = customer.stream()
                .map(category1 -> modelMapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<>(customerDTOS, "Customer Listed");
    }

    @Override
    public DataResult<CustomerDTO> getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if(customer == null){
            return new ErrorDataResult<>(null, "Customer not found");
        }
        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
        return new SuccessDataResult<>(customerDTO, "Customer Listed");
    }

    @Override
    public Result addCustomer(CustomerDTO customerDTO) {
        if(customerDTO == null){
            return new ErrorResult("Customer not found");
        }
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customerRepository.save(customer);
        return new SuccessResult("Customer added");
    }

    @Override
    public Result updateCustomer(CustomerDTO customerDTO, Long id) {
        if(customerDTO == null){
            return new ErrorResult("Customer not found");
        }
        Customer existCustomer = customerRepository.findById(id).
                orElse(null);
        if(existCustomer == null){
            return new ErrorResult("Customer not found");
        }
        modelMapper.map(customerDTO, existCustomer);
        customerRepository.save(existCustomer);
        return new SuccessResult("Customer updated");
    }

    @Override
    public Result deleteCustomer(Long id) {
        if(!customerRepository.existsById(id)){
            return new ErrorResult("Customer not found");
        }
        customerRepository.deleteById(id);
        return new SuccessResult("Customer deleted");
    }

    @Override
    public DataResult<CustomerDTO> findByEmail(String email) {
        Customer customer = customerRepository.findByEmail(email);
        if(customer == null){
            return new ErrorDataResult<>(null, "Customer not found");
        }
        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
        return new SuccessDataResult<>(customerDTO, "Customer Listed");
    }
}
