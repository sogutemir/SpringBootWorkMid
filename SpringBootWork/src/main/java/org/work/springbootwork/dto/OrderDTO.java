package org.work.springbootwork.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {
    private Long id;
    private Date orderDate;
    private Long customerId;
    private List<Long> productIds;
}
