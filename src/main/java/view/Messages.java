package view;

public class Messages {
        public static String choiceMessage = """
                1. Управление списком игрушек;
                2. Проведение розыгрыша;
                3. Результаты розыгрыша;
                4. Закрыть программу.
                """;
        public static String editInventory = """
                        1. Внесение игрушки в список;
                        2. Отобразить текущий список;
                        3. Удалить текущий список;
                        4. Редактировать список;
                        5. Возврат в меню.
                """;
        public static String resultsOperations = """
                        1. Отобразить текущие результаты;
                        2. Сохранить текущие результаты в файл;
                        3. Загрузить результаты из файла;
                        4. Удалить текущие результаты;
                        5. Очистить файл;
                        6. Возврат в меню.
                """;

        public static String goodByeMessage = "Завершение работы.";
        public static String inputToyString = "Введите данные игрушки в формате: <ID> <Шанс> <Название>";
        public static String successAddingToy = "Игрушка успешно добавлена в список для розыгрыша.";
        public static String successSavedResults = "Результаты розыгрыша успешно записаны в файл.";
        public static String successLoadedResults= "Результаты розыгрыша успешно загружены из файла.";
        public static String successDeletedResults = "Результаты розыгрыша успешно удалены.";
        public static String successClearedFile = "Файл с результатами успешно очищен.";
        public static String clearedInventory = "Список игрушек для розыгрыша был успешно очищен.";
        public static String emptyInventory = "Список игрушек для розыгрыша пуст.";
        public static String correctId = "Введите ID игрушки для редактирования: ";
        public static String correctName = "Введите новое имя игрушки: ";
        public static String correctChance = "Введите новый шанс выпадения игрушки: ";
        public static String correctedToy = "Информация об игрушке была успешно отредактирована.";
        public static String winnerMessage = "В розыгрыше есть победитель!\n";
}
