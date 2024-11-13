package com.ecommerce.ico.ordre;

import com.ecommerce.ico.asset.Asset;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import com.ecommerce.ico.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Ordre {

	@Id
    @GeneratedValue
    private Integer orderId;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User buyer; 
    
    @ManyToMany
    @JoinTable(
            name = "order_assets",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "asset_id")
    )
    private List<Asset> assets; 

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status = OrderStatus.PENDING;
}
