package ru.alex.Telegramshop;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import org.telegram.telegrambots.meta.api.methods.AnswerPreCheckoutQuery;
import org.telegram.telegrambots.meta.api.methods.invoices.CreateInvoiceLink;
import org.telegram.telegrambots.meta.api.methods.invoices.SendInvoice;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.ApiResponse;
import org.telegram.telegrambots.meta.api.objects.ChatInviteLink;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.ResponseParameters;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.payments.LabeledPrice;
import org.telegram.telegrambots.meta.api.objects.payments.PreCheckoutQuery;
import org.telegram.telegrambots.meta.api.objects.payments.SuccessfulPayment;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.alex.Telegramshop.service.OrderService;
import ru.alex.Telegramshop.service.ShaurmaService;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class TelegambotApp extends TelegramLongPollingBot{

  private ShaurmaService shaurmaService;

  private OrderService orderService;

  public TelegambotApp(ShaurmaService shaurmaService, OrderService orderService) {

    this.shaurmaService = shaurmaService;
    this.orderService=orderService;

  }

  @SneakyThrows
  @Override
  public void onUpdateReceived(Update update) {
    Message message = update.getMessage();
    if (message != null) {
      Optional.ofNullable(message.getText())
          .ifPresent(commandName -> {
            try {
              this.serveCommand(commandName, message.getChat().getId().toString());
            } catch (TelegramApiException e) {
              e.printStackTrace();
            }
          });
      Optional.ofNullable(message.getSuccessfulPayment())
          .ifPresent(payment -> servePayment(payment, message.getChat().getId().toString()));
    } else if (update.getPreCheckoutQuery() != null) {
      PreCheckoutQuery preCheckoutQuery = update.getPreCheckoutQuery();
      execute(new AnswerPreCheckoutQuery(preCheckoutQuery.getId(), true));
    }
  }


  private void servePayment(SuccessfulPayment payment, String id) {
    orderService.createPurchase(payment, id);
  }
  @SneakyThrows
  private void serveCommand(String commandName, String chatId) throws TelegramApiException {
    switch (commandName) {
      case "/start": {
        SendMessage response = new SendMessage(chatId,
            "Список команд:\n/menu - Главное меню\n/start - Начало работы");
        this.execute(response);
        break;
      }
      case "/menu": {
        SendMessage response = new SendMessage(chatId, "Меню");
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add("Товары");
        keyboard.add(row);
        replyKeyboardMarkup.setKeyboard(keyboard);
        response.setReplyMarkup(replyKeyboardMarkup);
        this.execute(response);
        break;
      }
      case "Товары": {
        shaurmaService.getShaurmas()
            .forEach(shaurma -> {
              List<LabeledPrice> prices = new ArrayList<>();
              prices.add(new LabeledPrice("Цена", shaurma.getPrice().multiply(BigDecimal.valueOf(100L)).intValue()));
              SendInvoice sendInvoice = new SendInvoice(chatId, shaurma.getName(), shaurma.getDescription(), shaurma.getId(),
                  "401643678:TEST:b0166c28-c034-4a0b-9066-e86bfaeba376", "", "RUB", prices);
              sendInvoice.setPhotoUrl(shaurma.getPhoto());
              try {
                this.execute(sendInvoice);
              } catch (TelegramApiException e) {
                e.printStackTrace();
              }
            });
        break;
      }

      default: {
        SendMessage response = new SendMessage(chatId, "Команда не распознана");
        this.execute(response);
        break;
      }
    }
  }

  @Override
  public String getBotUsername() {
    return "SuperShaurmabot";
  }

  @Override
  public String getBotToken() {
    return "5402013635:AAGgUzbxd739pG5Ic6TJth1Uwn2fFJfYIz4";
  }

}

