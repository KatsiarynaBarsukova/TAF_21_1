package tests;

import org.openqa.selenium.WebDriver;

public class xPathSelectors {
    private WebDriver driver;

    private static String absolutePath = "/html/body/div";

    // Все элементы на странице начиная с html - тэга
    private static String allElementsInHTMLPath = "//*";

    // Элемент по тэгу
    private static String bodyPath = "//body";

    // Дочерний элемент относительно родителя
    //private static String childPath = "//form/input";

    // Поиск элемента с аттрибутом и его значением
    //private static String tagWithAttrPath = "//span[@id='access--1']";

    // Поиск родителя у элемента с аттрибутом и его значением
    //private static String parentPath1 = "//span[@id='access--1']//..";

    // Поиск родителя у элемента с аттрибутом и его значением
    //private static String parentPath2 = "//*[@id='suite_mode_single']/parent::label;";

    // Поиск элемента по индексу
    //private static String elementByIndexPath = "(//form)[4]";

    // Поиск элемента по полному соответствию по тексту
    private static String searchByTextPath = "//*[text()='Sauce Labs Bike Light']";

    // Поиск элемента по полному соответствию по тексту
    //private static String searchByTextPath1 = "//*[.='New Widget']";

    // Поиск элемента по подстроке в тексте
    private static String searchBySubstringPath = "//*[contains(text(),'Open Menu')]";

    //Поиск элемента по аттрибуту значение которого начинается с
    private static String searchByStartsWithPath = "//input[starts-with(@type, 'bm')]";

    // Использование логического оператора
    //private static String searchByTwoAttrPath = "//*[@class='form-control ' and @type='text']";

    // Использование логического оператора
    //private static String searchBySpecificAttrPath = "//input[@type != 'hidden']";

    //Axes - Оси
    //Использование ancestor - все предки текущего узла
    private static String path1 = "//*[@id='cart_contents_container']/ancestor::div";

    //Использование child - все предки текущего узла зависят от уровня
    private static String path2_1 = "//ul/child::li";
    //private static String path2_2 = "//ul/li";  // аналог только проще

    //Использование descendant - Все предки текущего узла не зависимо от уровня
    private static String path3_1 = "//a/descendant::span";
    //private static String path3_2 = "//ul//span";  // аналог только проще

    //Использование following - Выбирает всё в документе после закрытия тэга текущего узла
    private static String path4_1 = "//label[@for='announcement']/following::logo";
    //private static String path4_2 = "(//label[@for='announcement']/following::div/*[@class='checkbox'])[1]";

    //Использование following-sibling - Выбирает все узлы одного уровня после текущего узла
    private static String path5_1 = "//label[@for='announcement']/following-sibling::div";

    //Использование preceding- Выбирает все узлы, которые появляются перед текущим узлом в документе
    private static String path6_1 = "////label[@for='announcement']/preceding::container";

    //Использование preceding-sibling - Выбирает все узлы одного уровня до текущего узла
    //private static String path7_1 = "//label[@for='announcement']/preceding-sibling::div";

   /* @BeforeMethod
    public void setup() {
        driver = new BrowsersService().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void basicXPathSelectors() {
        driver.get(ReadProperties.getUrl());

        // Абсолютный xpath
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div[1]/div/div[2]")).isDisplayed());

        // Все эелемнты на странице начина с HTML
        driver.findElements(By.xpath("//*"));

        // Аналог поиска по tagName
        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());

        // Аналог родительского div и на один уровень ниже р1
        Assert.assertTrue(driver.findElement(By.xpath("//div/h1")).isDisplayed());

        // Аналог родительского div и на любом уровене ниже div
        Assert.assertTrue(driver.findElement(By.xpath("//div//div")).isDisplayed());

        // Поиск элемента с тэгом div у которого есть аьттрибут id
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id]")).isDisplayed());

        // Поиск элемента у которого есть аттрибут id cо значением top-logo
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id = 'top-logo']")).isDisplayed());

        // Поиск элемента у которого есть аттрибут method cо значением и фттрибут target со значением
        Assert.assertTrue(driver.findElement(By.xpath("//*[@method='post' and @target='_blank']")).isDisplayed());

        // Поиск элемента у которого значение аттрибута начинается с
        Assert.assertTrue(driver.findElement(By.xpath("//*[starts-with(@id, 'new')]")).isDisplayed());

        // Поиск элемента у которого значение аттрибута содержит подстроку
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@id, 'Template')]")).isDisplayed());

        // Поиск элемента у которого текстовое значение содержит равно
        Assert.assertTrue(driver.findElement(By.xpath("//div[text() = 'All Projects']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[. = 'Todos']")).isDisplayed());

        // Поиск элемента у которого текстовое значение содержит подстроку
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'All Projects')]")).isDisplayed());

        // Поиск элемента по индексу
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'summary-links text-secondary']/a[2]")).isDisplayed());
    }

    @Test
    public void axesXPathTest() {
        driver.get(ReadProperties.getUrl());

        // Поиск родителя у элемента с тэгом h1
        Assert.assertTrue(driver.findElement(By.xpath("//h1/..")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//h1/parent::div")).isDisplayed());

        // Поиск всех предков с тэгом div у элемента с тэгом h1
        Assert.assertTrue(driver.findElement(By.xpath("//h1/ancestor::div")).isDisplayed());

        // Использование child - все дочерние элементы с тэго a от div
        Assert.assertTrue(driver.findElement(By.xpath("//div/child::a")).isDisplayed());

        //Использование following - Выбирает всё в документе после закрытия тэга текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/following::form")).isDisplayed());

        //Использование following-sibling - Выбирает все узлы одного уровня после текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/following-sibling::form")).isDisplayed());

        //Использование preceding- Выбирает все узлы, которые появляются перед текущим узлом в документе
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"dialog-title\"]/preceding::form")).isDisplayed());

        //Использование preceding-sibling - Выбирает все узлы одного уровня до текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/preceding-sibling::form")).isDisplayed());
    }*/
}
