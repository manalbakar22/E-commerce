package com.ecommerce.ico.ordre;


import com.ecommerce.ico.asset.Asset;
import com.ecommerce.ico.asset.AssetRepository;
import com.ecommerce.ico.user.User;
import com.ecommerce.ico.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrdreRepository orderRepository;
    private final UserRepository userRepository;
    private final AssetRepository assetRepository;

    public Ordre createOrder(Integer userId, List<Integer> assetIds) {
        
        User buyer = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        
        List<Asset> assets = assetRepository.findAllById(assetIds);

        
        Ordre order = Ordre.builder()
                .orderDate(LocalDateTime.now())
                .buyer(buyer)
                .assets(assets)
                .status(OrderStatus.PENDING) // Status par défaut
                .build();
        
        return orderRepository.save(order);
    }

    public List<Ordre> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Ordre> getOrderById(Integer orderId) {
        return orderRepository.findById(orderId);
    }

    public boolean updateOrderStatus(Integer orderId, OrderStatus status) {
        Optional<Ordre> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            Ordre order = orderOptional.get();
            order.setStatus(status);
            orderRepository.save(order);
            return true;
        }
        return false;
    }

    public boolean cancelOrder(Integer orderId) {
        return updateOrderStatus(orderId, OrderStatus.CANCELED);
    }
}
