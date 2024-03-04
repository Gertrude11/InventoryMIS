package com.Gerturde.InventoryMgtSystem.service;

import com.Gerturde.InventoryMgtSystem.models.ProfitAndLoss;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProfitAndLossService {

    List<ProfitAndLoss> getAllProfitAndLoss();
    ProfitAndLoss saveProfitAndLoss(ProfitAndLoss profitAndLoss);
    ProfitAndLoss updateProfitAndLoss(ProfitAndLoss profitAndLoss);
    Optional<ProfitAndLoss> findByID(UUID id);
    boolean deleteById(UUID id);
}
