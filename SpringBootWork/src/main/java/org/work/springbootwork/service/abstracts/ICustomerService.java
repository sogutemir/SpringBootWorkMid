package org.work.springbootwork.service.abstracts;

import org.work.springbootwork.core.results.DataResult;
import org.work.springbootwork.core.results.Result;
import org.work.springbootwork.dto.CategoryDTO;
import org.work.springbootwork.dto.CustomerDTO;

import java.util.List;

public interface ICustomerService {
    DataResult<List<CustomerDTO>> getAllCustomer();
    DataResult<CustomerDTO> getCustomerById(Long id);
    Result addCustomer(CustomerDTO customerDTO);
    Result updateCustomer(CustomerDTO customerDTO, Long id);
    Result deleteCustomer(Long id);
    DataResult<CustomerDTO> findByEmail(String email);

}
