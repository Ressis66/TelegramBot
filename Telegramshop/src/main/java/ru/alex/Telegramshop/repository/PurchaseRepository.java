package ru.alex.Telegramshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.alex.Telegramshop.model.Purchase;

public interface PurchaseRepository extends MongoRepository<Purchase, String> {
}
