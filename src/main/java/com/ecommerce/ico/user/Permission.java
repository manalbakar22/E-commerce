package com.ecommerce.ico.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    // Seller permissions
    SELLER_READ("seller:read"),
    SELLER_UPDATE("seller:update"),
    SELLER_CREATE("seller:create"),
    SELLER_DELETE("seller:delete"),

    // Buyer permissions
    BUYER_READ("buyer:read"),
    BUYER_UPDATE("buyer:update"),
    BUYER_CREATE("buyer:create"),
    BUYER_DELETE("buyer:delete");


    ;

    @Getter
    private final String permission;
}
