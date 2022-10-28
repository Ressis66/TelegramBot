package ru.alex.Telegramshop.service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.alex.Telegramshop.model.Shaurma;
import ru.alex.Telegramshop.repository.ShaurmaRepository;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ShaurmaService {

  @Autowired
  private ShaurmaRepository shaurmaRepository;

  public List<Shaurma> getShaurmas() {
    return shaurmaRepository.findAll();
  }


}
