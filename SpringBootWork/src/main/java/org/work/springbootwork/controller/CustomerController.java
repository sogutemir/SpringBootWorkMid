package org.work.springbootwork.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.work.springbootwork.core.results.DataResult;
import org.work.springbootwork.core.results.Result;
import org.work.springbootwork.dto.CustomerDTO;
import org.work.springbootwork.dto.OrderDTO;
import org.work.springbootwork.service.concretes.CustomerService;
import org.work.springbootwork.utils.ResponseUtil;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<CustomerDTO>>> getAllCustomer(){
        return ResponseUtil.buildDataResultResponse(customerService.getAllCustomer());
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<DataResult<CustomerDTO>> getCustomerById(@PathVariable Long id){
        return ResponseUtil.buildDataResultResponse(customerService.getCustomerById(id));
    }

    @GetMapping("/getbymail/{mail}")
    public ResponseEntity<DataResult<CustomerDTO>> getCustomerByMail(@PathVariable String mail){
        return ResponseUtil.buildDataResultResponse(customerService.findByEmail(mail));
    }

    @PostMapping("/add")
    public ResponseEntity<Result> addCustomer(@RequestBody CustomerDTO customerDTO){
        return ResponseUtil.buildResultResponse(customerService.addCustomer(customerDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Result> updateCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable Long id){
        return ResponseUtil.buildResultResponse(customerService.updateCustomer(customerDTO, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Result> deleteCustomer(@PathVariable Long id){
        return ResponseUtil.buildResultResponse(customerService.deleteCustomer(id));
    }
}
