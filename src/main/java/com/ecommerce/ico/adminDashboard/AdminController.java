package com.ecommerce.ico.adminDashboard;


import com.ecommerce.ico.user.User;
import com.ecommerce.ico.ordre.Ordre;
import com.ecommerce.ico.asset.Asset;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return adminService.getAllUsers();
    }

    @GetMapping("/orders")
    public List<Ordre> getAllOrders() {
        return adminService.getAllOrders();
    }

    @GetMapping("/assets")
    public List<Asset> getAllAssets() {
        return adminService.getAllAssets();
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        adminService.deleteUser(userId);
    }

    @DeleteMapping("/orders/{orderId}")
    public void deleteOrder(@PathVariable Integer orderId) {
        adminService.deleteOrder(orderId);
    }

    @DeleteMapping("/assets/{assetId}")
    public void deleteAsset(@PathVariable Integer assetId) {
        adminService.deleteAsset(assetId);
    }

   
}

