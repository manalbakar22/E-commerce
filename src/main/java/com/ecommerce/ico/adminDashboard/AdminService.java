package com.ecommerce.ico.adminDashboard;


import com.ecommerce.ico.user.User;
import com.ecommerce.ico.ordre.Ordre;
import com.ecommerce.ico.asset.Asset;
import com.ecommerce.ico.user.UserRepository;
import com.ecommerce.ico.ordre.OrdreRepository;
import com.ecommerce.ico.asset.AssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminService {

    private final UserRepository userRepository;
    private final OrdreRepository orderRepository;
    private final AssetRepository assetRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<Ordre> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    public void deleteOrder(Integer orderId) {
        orderRepository.deleteById(orderId);
    }
    
    public void deleteAsset(Integer assetId) {
        assetRepository.deleteById(assetId);
    }

    
}
