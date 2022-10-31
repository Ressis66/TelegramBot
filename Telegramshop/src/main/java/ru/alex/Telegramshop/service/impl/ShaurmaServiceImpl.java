package ru.alex.Telegramshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.alex.Telegramshop.model.Shaurma;
import ru.alex.Telegramshop.repository.ShaurmaRepository;
import ru.alex.Telegramshop.service.ShaurmaService;

import java.util.List;


@Component
public class ShaurmaServiceImpl implements ShaurmaService {

  private ShaurmaRepository shaurmaRepository;

  public ShaurmaServiceImpl(ShaurmaRepository shaurmaRepository) {
    this.shaurmaRepository = shaurmaRepository;
  }

  public List<Shaurma> getShaurmas() {
    return shaurmaRepository.findAll();
  }


}
