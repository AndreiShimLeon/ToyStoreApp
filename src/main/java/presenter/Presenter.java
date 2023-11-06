package presenter;

import model.Controller;
import model.Exceptions.*;
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

    public void start() {
        boolean flag = true;
        while (flag) {
            try {
                String choice = view.input(Messages.choiceMessage);
                try {
                    int choiceInt = Integer.parseInt(choice);
                    if (choiceInt < 1 || choiceInt > 4) throw new IncorrectInput();
                } catch (NumberFormatException e) {
                    throw new IncorrectInput();
                }
                switch (choice) {
                    case "1": // Управление списком игрушек
                        boolean inventoryFlag = true;
                        while (inventoryFlag) {
                            String inventoryChoice = view.input(Messages.editInventory);
                            try {
                                int inventoryChoiceInt = Integer.parseInt(inventoryChoice);
                                if (inventoryChoiceInt < 1 || inventoryChoiceInt > 5) throw new WrongChoiceException();
                            } catch (NumberFormatException e) {
                                throw new WrongChoiceException();
                            }
                            switch (inventoryChoice) {
                                case "1": // Внесение игрушки в список
                                    String toyInfo = view.input(Messages.inputToyString);
                                    controller.addToy(toyInfo);
                                    view.print(Messages.successAddingToy);
                                    break;
                                case "2": // Отобразить текущий список
                                    if (controller.showInventory() != null) {
                                        view.print(controller.showInventory());
                                    } else {
                                        view.print(Messages.emptyInventory);
                                    }
                                    break;
                                case "3": // Удалить текущий список
                                    if (controller.clearInventory()) {
                                        view.print(Messages.clearedInventory);
                                    } else {
                                        view.print(Messages.emptyInventory);
                                    }
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
                        break;
                    case "2": // Проведение розыгрыша
                        view.print(Messages.winnerMessage + controller.showWinner(controller.draw()));
                        break;
                    case "3": // Операции с результатами розыгрыша
                        boolean resultsFlag = true;
                        while (resultsFlag) {
                            String resultsChoice = view.input(Messages.resultsOperations);
                            try {
                                int resultsChoiceInt = Integer.parseInt(resultsChoice);
                                if (resultsChoiceInt < 1 || resultsChoiceInt > 6) throw new WrongChoiceException();
                                switch (resultsChoice) {
                                    case "1": // Отображение текущих результатов
                                        view.print(controller.showResults());
                                        break;
                                    case "2": // Сохранение результатов в файл
                                        controller.saveResults();
                                        view.print(Messages.successSavedResults);
                                        break;
                                    case "3": // Загрузка результатов из файла
                                        controller.loadResults();
                                        view.print(Messages.successLoadedResults);
                                        break;
                                    case "4": // Удаление текущих результатов
                                        controller.deleteResults();
                                        view.print(Messages.successDeletedResults);
                                        break;
                                    case "5": // Очистка файла
                                        controller.clearFile();
                                        view.print(Messages.successClearedFile);
                                        break;
                                    case "6": // Возврат в меню
                                        resultsFlag = false;
                                        break;
                                }
                            } catch (NumberFormatException e) {
                                throw new WrongChoiceException();
                            } catch (DrawResultIsEmpty e){
                                view.print(e.getMessage());
                            } catch (EmptyResultFileException e){
                                view.print(e.getMessage());
                            }
                        }
                        break;
                    case "4": // закрытие программы
                        flag = false;
                        view.print(Messages.goodByeMessage);
                        break;
                }
            } catch (IncorrectInput e) {
                view.print(e.getMessage());
            } catch (NotEnoughToys e) {
                view.print(e.getMessage());
            } catch (ToyAlreadyInTheList e) {
                view.print(e.getMessage());
            } catch (WrongChoiceException e) {
                view.print(e.getMessage());
            } catch (WrongIDException e) {
                view.print(e.getMessage());
            }
        }
    }
}
