Feature: Параметризированые тесты

  Scenario: Простая параметризация
    Given открыт браузер
    * страница логина открыта
    When user "asda" with password "asda" loggen in
    