package ITSanes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Dio on 22.04.2017.
 */
public class MainPagePO {
    private WebDriver driver;

    private By name = By.id("name");
    private By email = By.id("email");
    private By theme = By.id("theme");
    private By message = By.id("message");
    private By captcha = By.className("recaptcha-checkbox-checkmark");
    private By send = By.cssSelector("button[type=\"submit\"]");
    private By nameErr = By.id("name_error");
    private By emailErr = By.id("email_error");
    private By themeErr = By.id("theme_error");
    private By messErr = By.id("message_error");



    private String js = "$(\".col-md-7.col-xs-12.col-sm-12 form\").append(\"<ul class='errorMessages'></ul>\");\n" +
            "var createAllErrors = function () {\n" +
            "    var form = $(this),\n" +
            "        errorList = $(\"ul.errorMessages\", form);\n" +
            "    var showAllErrorMessages = function () {\n" +
            "        errorList.empty();\n" +
            "        // Find all invalid fields within the form.\n" +
            "        var invalidFields = form.find(\":invalid\").each(function (index, node) {\n" +
            "            // Opera incorrectly does not fill the validationMessage property.\n" +
            "            message = node.validationMessage || 'Invalid value.';\n" +
            "            errorList\n" +
            "                .show()\n" +
            "                .append(\"<li>\" + node.id + \"</li>\")\n" +
            "                .append(\"<li id=\" + node.id.concat(\"_error\") + \">\" + message + \"</li>\");\n" +
            "        });\n" +
            "    };\n" +
            "    // Support Safari\n" +
            "    form.on(\"submit\", function (event) {\n" +
            "        if (this.checkValidity && !this.checkValidity()) {\n" +
            "            $(this).find(\":invalid\").first().focus();\n" +
            "            event.preventDefault();\n" +
            "        }\n" +
            "    });\n" +
            "    $(\"button[type=submit]\", form)\n" +
            "        .on(\"click\", showAllErrorMessages);\n" +
            "    $(\"input\", form).on(\"keypress\", function (event) {\n" +
            "        var type = $(this).attr(\"type\");\n" +
            "        if (/date|email|month|number|search|tel|text|time|url|week/.test(type)\n" +
            "            && event.keyCode == 13) {\n" +
            "            showAllErrorMessages();\n" +
            "        }\n" +
            "    });\n" +
            "};\n" +
            "$(\".col-md-7.col-xs-12.col-sm-12 form\").each(createAllErrors);";

    public MainPagePO(WebDriver driver){
        this.driver = driver;
    }

    public void open(){
        driver.get("http://itsanes.com/");
    }

    public MainPagePO enterName(String text){
    driver.findElement(name).sendKeys(text);
    return this;
    }

    public MainPagePO enterEmail(String text){
        driver.findElement(email).sendKeys(text);
        return this;
    }

    public MainPagePO enterTheme(String text){
        driver.findElement(theme).sendKeys(text);
        return this;
    }

    public MainPagePO enterMessage(String text){
        driver.findElement(message).sendKeys(text);
        return this;
    }

    public MainPagePO clickCaptcha(){
        driver.findElement(captcha).click();
        return this;
    }

    public void clickSendButton(){
        driver.findElement(send).click();
    }

    public String getNameErrMess(){
        return driver.findElement(nameErr).getText();
    }

    public String getEmailErrMess(){
        return driver.findElement(emailErr).getText();
    }

    public String getThemeErrMess(){
        return driver.findElement(themeErr).getText();
    }

    public String gettextErrMess(){
        return driver.findElement(messErr).getText();
    }

    public MainPagePO clear(){
        driver.findElement(name).clear();
        driver.findElement(email).clear();
        driver.findElement(theme).clear();
        driver.findElement(message).clear();
        return this;
    }

    public String firstErrMess(){
        return "Заполните это поле.";
    }

    public String secondErrMess(String text){
        return "Адрес электронной почты должен содержать символ \"@\". В адресе \"" + text + "\" отсутствует символ \"@\".";
    }

    public String thirdErrMess(String text){
        return "Введите часть адреса после символа \"@\". Адрес \""+ text + "\" неполный.";
    }

    public String fourthErrMess(String text){
        return "Введите часть адреса до символа \"@\". Адрес \"" + text + "\" неполный.";
    }


    public String getJs() {
        return js;
    }

}
