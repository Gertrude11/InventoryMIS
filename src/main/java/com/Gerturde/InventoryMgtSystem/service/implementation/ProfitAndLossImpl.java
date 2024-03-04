package com.Gerturde.InventoryMgtSystem.service.implementation;

import com.Gerturde.InventoryMgtSystem.models.ProfitAndLoss;
import com.Gerturde.InventoryMgtSystem.models.ProfitAndLoss;
import com.Gerturde.InventoryMgtSystem.repository.ProfitAndLossRepo;
import com.Gerturde.InventoryMgtSystem.service.ProfitAndLossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProfitAndLossImpl implements ProfitAndLossService {
    
    @Autowired
    ProfitAndLossRepo repo;
    @Override
    public List<ProfitAndLoss> getAllProfitAndLoss() {
        return repo.findAll();
    }

    @Override
    public ProfitAndLoss saveProfitAndLoss(ProfitAndLoss profitAndLoss) {
        return repo.save(profitAndLoss);
    }

    @Override
    public ProfitAndLoss updateProfitAndLoss(ProfitAndLoss profitAndLoss) {
        return repo.save(profitAndLoss);
    }

    @Override
    public Optional<ProfitAndLoss> findByID(UUID id) {
        return repo.findById(id);
    }

    @Override
    public boolean deleteById(UUID id) {
        ProfitAndLoss ProfitAndLoss = repo.findById(id).orElse(null);
        if(ProfitAndLoss!=null){
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
