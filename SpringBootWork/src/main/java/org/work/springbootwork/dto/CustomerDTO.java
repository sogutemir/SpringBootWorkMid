package org.work.springbootwork.dto;

import lombok.Data;

import java.util.List;

@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
    private List<Long> orderIds;
}
