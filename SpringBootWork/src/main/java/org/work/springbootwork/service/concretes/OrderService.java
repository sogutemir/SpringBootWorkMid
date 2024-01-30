package org.work.springbootwork.service.concretes;

import org.work.springbootwork.core.results.DataResult;
import org.work.springbootwork.core.results.Result;
import org.work.springbootwork.dto.OrderDTO;
import org.work.springbootwork.service.abstracts.IOrderService;

import java.util.List;

public class OrderService implements IOrderService {
    @Override
    public DataResult<List<OrderDTO>> gettAllOrder() {
        return null;
    }

    @Override
    public DataResult<OrderDTO> getOrderById(Long id) {
        return null;
    }

    @Override
    public Result addOrder(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public Result updateOrder(OrderDTO orderDTO, Long id) {
        return null;
    }

    @Override
    public Result deleteOrder(Long id) {
        return null;
    }

    @Override
    public DataResult<List<OrderDTO>> findByCustomerId(Long customerId) {
        return null;
    }
}
