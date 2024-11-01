package com.ecommerce.ico.ordre;

	import lombok.RequiredArgsConstructor;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;

	import java.util.List;
	import java.util.Optional;

	@RestController
	@RequestMapping("/api/orders")
	@RequiredArgsConstructor
	public class OrderController {
		
	    private final OrderService orderService;

	  
	    @PostMapping("/create")
	    public ResponseEntity<Ordre> createOrder(
	            @RequestParam Integer userId,
	            @RequestBody List<Integer> assetIds) {
	        Ordre order = orderService.createOrder(userId, assetIds);
	        return ResponseEntity.ok(order);
	    }

	    
	    @GetMapping
	    public ResponseEntity<List<Ordre>> getAllOrders() {
	        return ResponseEntity.ok(orderService.getAllOrders());
	    }

	   
	    @GetMapping("/{orderId}")
	    public ResponseEntity<Ordre> getOrderById(@PathVariable Integer orderId) {
	        Optional<Ordre> order = orderService.getOrderById(orderId);
	        return order.map(ResponseEntity::ok)
	                .orElseGet(() -> ResponseEntity.notFound().build());
	    }

	   
	    @PutMapping("/{orderId}/status")
	    public ResponseEntity<Void> updateOrderStatus(
	            @PathVariable Integer orderId,
	            @RequestParam OrderStatus status) {
	        boolean updated = orderService.updateOrderStatus(orderId, status);
	        return updated ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
	    }

	   
	    @PutMapping("/{orderId}/cancel")
	    public ResponseEntity<Void> cancelOrder(@PathVariable Integer orderId) {
	        boolean canceled = orderService.cancelOrder(orderId);
	        return canceled ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
	    }
	}
