package com.ssafy.birdchain.common.db.repository;

import com.ssafy.birdchain.common.db.entity.AvailableProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvailableProductRepository extends JpaRepository<AvailableProduct, Integer> {
    List<AvailableProduct> findByIsAvailable(boolean isAvailable);
}
