package com.ecommerce.ico.adminDashboard;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class AdminUser {
	
	@Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String email;
    
    @Enumerated(EnumType.STRING)
    private AdminRole role;
}
