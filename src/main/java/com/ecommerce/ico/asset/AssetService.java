package com.ecommerce.ico.asset;

import com.ecommerce.ico.user.User;
import com.ecommerce.ico.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssetService {

    private final AssetRepository assetRepository;
    private final UserRepository userRepository;


    public Asset save(AssetRequest request) {
        // Retrieve the seller from the UserRepository by ID
        User seller = userRepository.findById(request.getSellerId())
                .orElseThrow(() -> new RuntimeException("Seller not found"));

        // Create an Asset instance using the data from AssetRequest
        Asset asset = Asset.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .price(request.getPrice())
                .file_url(request.getFile_url())
                .asset_metadata(request.getAsset_metadata())
                .status(Status.PENDING)  // Default to PENDING if no status provided
                .seller(seller)
                .build();
        return assetRepository.save(asset);
    }

    public List<Asset> findAll() {
        return assetRepository.findAll();
    }

    public boolean updateAssetStatus(Integer asset_id, Status status) {
        Optional<Asset> assetOptional = assetRepository.findById(asset_id); // Adjust the method if needed

        if (assetOptional.isPresent()) {
            Asset asset = assetOptional.get();
            asset.setStatus(status); // Assuming setStatus updates the status
            assetRepository.save(asset); // Save the updated asset
            return true;
        }
        return false;
    }

}
