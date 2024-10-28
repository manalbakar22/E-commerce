package com.ecommerce.ico.demo;

import com.ecommerce.ico.asset.AssetService;
import com.ecommerce.ico.asset.ChangeAssetStatusRequest;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    private final AssetService assetService;

    @Autowired
    public AdminController(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('admin:read')")
    public String get() {
        return "GET:: admin controller";
    }
    @PostMapping
    @PreAuthorize("hasAuthority('admin:create')")
    @Hidden
    public String post() {
        return "POST:: admin controller";
    }
    @PutMapping
    @PreAuthorize("hasAuthority('admin:update')")
    @Hidden
    public String put() {
        return "PUT:: admin controller";
    }
    @DeleteMapping
    @PreAuthorize("hasAuthority('admin:delete')")
    @Hidden
    public String delete() {
        return "DELETE:: admin controller";
    }

    // New method to change asset status
    @PutMapping("/assets/status")
    @PreAuthorize("hasAuthority('admin:updateStatus')") // Define a specific authority if necessary
    public ResponseEntity<String> changeAssetStatus(@RequestBody ChangeAssetStatusRequest request) {
        boolean updated = assetService.updateAssetStatus(request.getAsset_id(), request.getStatus());

        if (updated) {
            return ResponseEntity.ok("Asset status updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Asset not found.");
        }
    }
}
