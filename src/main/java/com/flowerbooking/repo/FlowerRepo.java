package com.flowerbooking.repo;

import com.flowerbooking.model.Flower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface FlowerRepo extends JpaRepository<Flower,Integer> {
}
