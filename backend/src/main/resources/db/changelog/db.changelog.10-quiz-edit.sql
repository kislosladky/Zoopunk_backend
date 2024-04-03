DROP TABLE IF EXISTS quizzes;
CREATE TABLE quizzes (
    id                  UUID PRIMARY KEY NOT NULL,
    achievementsid      UUID,
    name                TEXT,
    img                 TEXT,
    description         TEXT,
    quizcontent         JSON
);

INSERT INTO quizzes (id, achievementsid, name, img, description, quizcontent) VALUES
     ('9ff4d17f-d885-44dc-8b00-1ed57b611386', '85557a87-6908-41af-ad16-e8f959c71c66', 'Тестовый квиз', '../../assets/blueBulp.png', 'Очень интересный квиз для детей',  '{ "count-questions": 5, "results":[{"question":"Как называют детёныша курицы?", "correct_answer":"Цыплёнок","incorrect_answers":["Курёнок","Курица-грилль","KFC"]},{"question":"Сколько ног у осьминога","correct_answer":"8","incorrect_answers":["Ни одной","Урааа, суши","25"]}, {"question":"Кто самое медлительное животное?","correct_answer":"Ленивец","incorrect_answers":["Программист с почасовой оплатой","Подкованная блоха","Птица говорун"]}, {"question":"Кто из животных носит сумку?", "correct_answer":"Кенгуру",   "incorrect_answers":["Крокодилиха","Светская львица"]},{"question":"Самое большое хищное животное", "correct_answer":"Белый медведь","incorrect_answers":["Волк с Уолл-Стрит","Иртегов","Колибри"]}]}'),
     ('3c01352d-32aa-4bb0-8693-ca18fd32fb8e', '85557a87-6908-41af-ad16-e8f95a871c69', 'Тестовый квиз 2', '../../assets/yellowBulp.png', 'Очень интересный квиз для взрослых',  '{ "name": "Тестовый квиз 2", "count-questions":3,"results":[ {"question":"Одна технологическая компания провела рекламную акцию в нескольких барах. Всем желающим предлагалось поучаствовать в состязании, при этом побеждённый автоматически оплачивал счёт победителя. Ответьте, что это было за состязание.","correct_answer":"Армрестлинг","incorrect_answers":["Приседания","Подтягивания","Челночный бег"]},{"question":"Назовите технологию, которая рекламировалась таким образом","correct_answer":"NFC","incorrect_answers":["СБП","СПБ","RFID"]},{"question":"В одном из эпизодов комедийного сериала единорог убегает незадолго до отправления... Чего?","correct_answer":"Ноева ковчега","incorrect_answers":["Лодки деда Мазая","Лимузина","Кареты"]}]}');