package ITSanes;

import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Dio on 23.04.2017.
 */
public class MainPageFBTest {
    private static ChromeDriver driver;
    private static MainPagePO mainPagePO;

    @BeforeClass
    public static void precondition(){
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        mainPagePO = new MainPagePO(driver);
        mainPagePO.open();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript(mainPagePO.getJs());

    }


    @Test
    public void mainPageTestEmptyFields(){
        mainPagePO.clear()
                .clickSendButton();
        Assert.assertEquals(mainPagePO.getNameErrMess(), mainPagePO.firstErrMess());
        Assert.assertEquals(mainPagePO.getEmailErrMess(), mainPagePO.firstErrMess());
        Assert.assertEquals(mainPagePO.getThemeErrMess(), mainPagePO.firstErrMess());
        Assert.assertEquals(mainPagePO.gettextErrMess(), mainPagePO.firstErrMess());
    }

    @Test
    public void mainPageTestWrongEmailF(){
        mainPagePO.clear()
                .enterName("TestName")
                .enterEmail("@test")
                .clickSendButton();

        Assert.assertEquals(mainPagePO.getEmailErrMess(), mainPagePO.fourthErrMess("@test"));
    }

    @Test
    public void mainPageTestWrongEmailS(){
        mainPagePO.clear()
               .enterName("TestName")
               .enterEmail("testtest")
               .clickSendButton();

        Assert.assertEquals(mainPagePO.getEmailErrMess(), mainPagePO.secondErrMess("testtest"));
    }

    @Test
    public void mainPageTestWrongEmailT(){
        mainPagePO.clear()
                .enterName("TestName")
                .enterEmail("test@")
                .clickSendButton();
        Assert.assertEquals(mainPagePO.getEmailErrMess(), mainPagePO.thirdErrMess("test@"));
    }

    @AfterClass
    public static void postcondition() {
        driver.quit();
    }
}
