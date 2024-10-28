package com.ecommerce.ico.asset;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AssetRequest {
    private String title;
    private String description;
    private float price;
    private String file_url;
    private String asset_metadata;
    private Status status;
    private Integer sellerId;
}
