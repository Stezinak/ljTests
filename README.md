# ljTests

1. Тесты можно запускать по разному. Наиболее верный способ запустить всё и сразу:
в idea: view - Tool windows - Maven project.
Там раскрываем lifecycle, жмем на test. Первый раз будет подгрузка, потом будет запускаться быстрее.
В результате будет типа такого:

*много текста*
Results :

Tests run: 6, Failures: 0, Errors: 0, Skipped: 0


Тесты могут упасть, если livejournal временно заблокирует аккаунт (у меня такое уже несколько раз было).
Если у вас другая IDE - точный алгоритм сказать не могу.

Другие способы запуска из IDE: Правой кнопкой на тесте - Run - "test name".
Можно создать свой конфиг для запуска каких-то определенных тестов. Думаю, что всё это сейчас не нужно.
