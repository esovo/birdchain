package com.ssafy.birdchain.common.db.repository;

import com.ssafy.birdchain.common.db.entity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepository extends JpaRepository<Donation, Long> {
}
