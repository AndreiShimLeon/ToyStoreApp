package presenter;

import model.Controller;
import model.Exceptions.DrawResultIsEmpty;
import model.Exceptions.NotEnoughToys;
import model.Exceptions.WrongIDException;
import model.Exporter;
import model.Toy;
import view.View;
import view.Messages;


public class Presenter {
    View view;
    Controller<Toy> controller;

    public Presenter(View view, Controller<Toy> controller) {
        this.view = view;
        this.controller = controller;
    }

    public void start() throws WrongIDException, DrawResultIsEmpty, NotEnoughToys {
        boolean flag = true;
        while (flag) {
            String choice = view.input(Messages.choiceMessage);
            switch (choice) {
                // TODO:          1. Управление списком игрушек;
                //                2. Проведение розыгрыша;
                //                3. Результаты розыгрыша;
                //                4. Выйти.
                case "1": // Управление списком игрушек
                    boolean inventoryFlag = true;
                    while (inventoryFlag) {
                        String inventoryChoice = view.input(Messages.editInventory);
                        switch (inventoryChoice) {
                            case "1": // Внесение игрушки в список
                                // todo:
                                String name = view.input(Messages.inputToyName);
                                int id = Integer.parseInt(view.input(Messages.inputId));
                                int chance = Integer.parseInt(view.input(Messages.inputChance));
                                controller.addToy(id, chance, name);
                                view.print(Messages.successAddingToy);
                                break;
                            case "2": // Отобразить текущий список
                                if (controller.showInventory() != null) {
                                    view.print(controller.showInventory());
                                } else {
                                    view.print(Messages.emptyInventory);
                                }
                                // todo:
                                break;
                            case "3": // Удалить текущий список
                                if (controller.clearInventory()) {
                                    view.print(Messages.clearedInventory);
                                } else {
                                    view.print(Messages.emptyInventory);
                                }
                                // todo:
                                break;
                            case "4": // Редактировать список
                                if (controller.showInventory() == null) {
                                    view.print(Messages.emptyInventory);
                                } else {
                                    int correctID = Integer.parseInt(view.input(Messages.correctId));
                                    if (controller.toyInInventory(correctID)) {
                                        String correctName = view.input(Messages.correctName);
                                        int correctChance = Integer.parseInt(view.input(Messages.correctChance));
                                        controller.correctToy(correctID, correctName, correctChance);
                                        view.print(Messages.correctedToy);
                                    } else throw new WrongIDException();
                                }
                                break;
                            case "5": // Возврат в меню
                                inventoryFlag = false;
                                break;
                        }

                    }
                    //TODO:
                    // Ошибки
                    break;
                case "2": // Проведение розыгрыша
                    controller.draw();
                    //TODO: Проведение розыгрыша,
                    // если список игрушек не пустой
                    // (или только одна игрушка в списке)
                    break;
                case "3": // Операции с результатами розыгрыша
                    boolean resultsFlag = true;
                    while (resultsFlag) {
                        String resultsChoice = view.input(Messages.resultsOperations);
                        switch (resultsChoice) {
                            case "1": // Отображение текущих результатов
                                view.print(controller.showResults());
                                break;
                            case "2": // Сохранение результатов в файл
                                controller.saveResults();
                                view.print(Messages.successSavedResults);
                                break;
                            case "3": // Удаление текущих результатов
                                //TODO: Удаление текущих результатов
                                controller.deleteResults();
                                view.print(Messages.successDeletedResults);
                                break;
                            case "4": // Очистка файла
                                controller.clearFile();
                                view.print(Messages.successClearedFile);
                                break;
                            case "5": // Возврат в меню
                                resultsFlag = false;
                                break;
                        }
                    }
                    break;
                case "4": // закрытие программы
                    flag = false;
                    view.print(Messages.goodByeMessage);
                    break;
            }
        }
    }
}
