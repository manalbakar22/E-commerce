package com.ecommerce.ico.asset;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeAssetStatusRequest {
    private Integer asset_id;
    private Status status;
}
