package org.work.springbootwork.service.concretes;

import org.work.springbootwork.core.results.DataResult;
import org.work.springbootwork.core.results.Result;
import org.work.springbootwork.dto.CustomerDTO;
import org.work.springbootwork.service.abstracts.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    @Override
    public DataResult<List<CustomerDTO>> gettAllCustomer() {
        return null;
    }

    @Override
    public DataResult<CustomerDTO> getCustomerById(Long id) {
        return null;
    }

    @Override
    public Result addCustomer(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public Result updateCustomer(CustomerDTO customerDTO, Long id) {
        return null;
    }

    @Override
    public Result deleteCustomer(Long id) {
        return null;
    }

    @Override
    public DataResult<CustomerDTO> findByEmail(String email) {
        return null;
    }
}
