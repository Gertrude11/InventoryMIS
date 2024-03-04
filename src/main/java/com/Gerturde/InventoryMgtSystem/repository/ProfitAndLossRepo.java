package com.Gerturde.InventoryMgtSystem.repository;

import com.Gerturde.InventoryMgtSystem.models.ProfitAndLoss;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfitAndLossRepo extends JpaRepository<ProfitAndLoss, UUID> {
}
