package org.work.springbootwork.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.work.springbootwork.core.results.DataResult;
import org.work.springbootwork.core.results.Result;
import org.work.springbootwork.dto.OrderDTO;
import org.work.springbootwork.service.concretes.OrderService;
import org.work.springbootwork.utils.ResponseUtil;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<OrderDTO>>> getAllOrder(){
        return ResponseUtil.buildDataResultResponse(orderService.getAllOrder());
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<DataResult<OrderDTO>> getOrderById(@PathVariable Long id){
        return ResponseUtil.buildDataResultResponse(orderService.getOrderById(id));
    }

    @GetMapping("/getbycustomerid/{id}")
    public ResponseEntity<DataResult<List<OrderDTO>>>getOrderByCustomerId(@PathVariable Long id){
        return ResponseUtil.buildDataResultResponse(orderService.findByCustomerId(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Result> addOrder(@RequestBody OrderDTO orderDTO){
        return ResponseUtil.buildResultResponse(orderService.addOrder(orderDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Result> updateOrder(@RequestBody OrderDTO orderDTO, @PathVariable Long id){
        return ResponseUtil.buildResultResponse(orderService.updateOrder(orderDTO, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Result> deleteOrder(@PathVariable Long id){
        return ResponseUtil.buildResultResponse(orderService.deleteOrder(id));
    }
}
