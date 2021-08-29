import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SetupPage {
    public static WebDriver driver;
    public static Properties properties;
    public static WebDriver initiateDriver() throws IOException
    {
        properties = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\config.properties");
        properties.load(fis);
        String browser = properties.getProperty("browser");


        if(browser.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
        }
        else
        {
            System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
            driver = new FirefoxDriver();
        }
        return driver;

    }
    public static void holdExcution(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean isDisplayed1(String xpath)
    {
        boolean flag = false;
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            if (element.isDisplayed()) {
                flag = true;
            }
        }

        catch(NoSuchElementException e)
        {
            flag=false;

        }
        return flag;
    }

    public List<WebElement> getElements(WebElement locator) {
        List<WebElement> elementsList = driver.findElements((By) locator);
        return elementsList;
    }
}



