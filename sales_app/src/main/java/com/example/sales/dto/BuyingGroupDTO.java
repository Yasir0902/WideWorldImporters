package com.example.sales.dto;

import com.example.sales.entities.BuyingGroup;
import lombok.Getter;

@Getter
public class BuyingGroupDTO {
    private Long buyingGroupId;
    private String buyingGroupName;

    public BuyingGroupDTO(BuyingGroup buyingGroup) {
        this.buyingGroupId = buyingGroup.getBuyingGroupId();
        this.buyingGroupName = buyingGroup.getBuyingGroupName();
    }
}
