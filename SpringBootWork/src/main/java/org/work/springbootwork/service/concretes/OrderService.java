package org.work.springbootwork.service.concretes;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.work.springbootwork.core.results.*;
import org.work.springbootwork.dto.OrderDTO;
import org.work.springbootwork.model.Order;
import org.work.springbootwork.repository.OrderRepository;
import org.work.springbootwork.service.abstracts.IOrderService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    @Override
    public DataResult<List<OrderDTO>> getAllOrder() {
        List<Order> order = orderRepository.findAll();
        List<OrderDTO> orderDTOS = order.stream()
                .map(order1 -> modelMapper.map(order, OrderDTO.class))
                .collect(java.util.stream.Collectors.toList());
        return new SuccessDataResult<>(orderDTOS, "Order Listed");
    }

    @Override
    public DataResult<OrderDTO> getOrderById(Long id) {

        Order order = orderRepository.findById(id).orElse(null);
        if(order == null){
            return new ErrorDataResult<>(null, "Order not found");
        }
        OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);
        return new SuccessDataResult<>(orderDTO, "Order Listed");
    }

    @Override
    public Result addOrder(OrderDTO orderDTO) {
        if(orderDTO == null){
            return new ErrorDataResult<>("Order not found");
        }
        Order order = modelMapper.map(orderDTO, Order.class);
        orderRepository.save(order);
        return new SuccessDataResult<>("Order added");
    }

    @Override
    public Result updateOrder(OrderDTO orderDTO, Long id) {
        if(orderDTO == null)
        {
            return new ErrorDataResult<>("Order not found");
        }
        if(orderRepository.findById(id).orElse(null) == null){
            return new ErrorDataResult<>("Order not found");
        }
        Order order = modelMapper.map(orderDTO, Order.class);
        orderRepository.save(order);
        return new SuccessDataResult<>("Order updated");
    }

    @Override
    public Result deleteOrder(Long id) {
        if(orderRepository.findById(id).orElse(null) == null){
            return new ErrorDataResult<>("Order not found");
        }
        orderRepository.deleteById(id);
        return  new SuccessResult("Order deleted");
    }

    @Override
    public DataResult<List<OrderDTO>> findByCustomerId(Long customerId) {
        List<Order> order = orderRepository.findByCustomerId(customerId);
        if(order == null){
            return new ErrorDataResult<>(null, "Order not found");
        }
        List<OrderDTO> orderDTOS = order.stream()
                .map(order1 -> modelMapper.map(order, OrderDTO.class))
                .collect(java.util.stream.Collectors.toList());
        return new SuccessDataResult<>(orderDTOS, "Order Listed");
    }
}
