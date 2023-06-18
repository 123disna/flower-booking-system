package com.flowerbooking.service;

import com.flowerbooking.model.Flower;
import com.flowerbooking.repo.FlowerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlowerService {
    @Autowired
    private FlowerRepo flowerRepo;

    public void saveFlower(Flower flower) {
        flowerRepo.save(flower);
    }

    public List<Flower> getAllFlowers() {
        List<Flower> flowers=flowerRepo.findAll();
        return flowers;
    }

    public Flower getFlowerById(int id) {
        Flower flower=flowerRepo.findById(id).get();
        return flower;
    }

    public void updateFlower(Flower existFlower) {
        flowerRepo.save(existFlower);
    }

    public void deleteFlower(int id) {
        flowerRepo.deleteById(id);
    }
}
