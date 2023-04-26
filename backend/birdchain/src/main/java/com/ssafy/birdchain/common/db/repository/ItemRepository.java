package com.ssafy.birdchain.common.db.repository;

import com.ssafy.birdchain.common.db.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Long, Item> {
}
