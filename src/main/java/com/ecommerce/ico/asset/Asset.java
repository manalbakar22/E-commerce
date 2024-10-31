package com.ecommerce.ico.asset;

import com.ecommerce.ico.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Asset {

    @Id
    @GeneratedValue
    private Integer asset_id;
    private String title;
    private String description;
    private float price;
    private String file_url;
    private String asset_metadata;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.PENDING;

    @CreatedDate
    @Column(
            nullable = false,
            updatable = false
    )
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModified;


    @CreatedBy
    @Column(
            nullable = false,
            updatable = false
    )
    private Integer createdBy;

    @LastModifiedBy
    @Column(insertable = false)
    private Integer lastModifiedBy;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User seller;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AssetType assetType;
}
