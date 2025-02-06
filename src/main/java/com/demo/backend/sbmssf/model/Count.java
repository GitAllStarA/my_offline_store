package com.demo.backend.sbmssf.model;

import lombok.Data;

@Data
public class Count {

    public Count(Long storeId, Long total){
        this.storeId = storeId;
        this.total = total;
    }

    private Long storeId;
    private Long total;
}
