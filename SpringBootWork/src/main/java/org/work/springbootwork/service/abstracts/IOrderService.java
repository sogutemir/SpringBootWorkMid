package org.work.springbootwork.service.abstracts;

import org.work.springbootwork.core.results.DataResult;
import org.work.springbootwork.core.results.Result;
import org.work.springbootwork.dto.CustomerDTO;
import org.work.springbootwork.dto.OrderDTO;

import java.util.List;

public interface IOrderService {
    DataResult<List<OrderDTO>> gettAllOrder();
    DataResult<OrderDTO> getOrderById(Long id);
    Result addOrder(OrderDTO orderDTO);
    Result updateOrder(OrderDTO orderDTO, Long id);
    Result deleteOrder(Long id);
    DataResult<List<OrderDTO>> findByCustomerId(Long customerId);

}
