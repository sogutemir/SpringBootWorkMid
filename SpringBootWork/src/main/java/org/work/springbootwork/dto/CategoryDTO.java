package org.work.springbootwork.dto;

import lombok.Data;

import java.util.List;

@Data
public class CategoryDTO {

    private Long id;
    private String name;
    private List<Long> productIds;
}
