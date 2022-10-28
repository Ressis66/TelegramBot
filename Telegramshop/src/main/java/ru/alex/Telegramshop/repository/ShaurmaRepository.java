package ru.alex.Telegramshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.alex.Telegramshop.model.Shaurma;

public interface ShaurmaRepository extends MongoRepository<Shaurma, String> {
}
