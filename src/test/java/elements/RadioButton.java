package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class RadioButton {
    private List<UIEelment> uiElement;
    private List<String> valueList;

    public RadioButton(WebDriver driver, By by){
        uiElement = new ArrayList<>();
        valueList = new ArrayList<>();

        for (WebDriver webDriver : driver.findElement(by)) {
            UIElement tmpElement = new UIElement(driver, webElement);
            uiElements.add(tmpElement);
            valueList.add(tmpElement.getText());

        }
        }

        public void selectByValue(String value){
        uiElement.get(valueList.indexOf(value)).click();
    }
}
