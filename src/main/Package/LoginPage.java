import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver1) {
        super(driver1);
    }
 @FindBy(xpath="//input[@placeholder='Email']")
         WebElement Email;
 @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;
 @FindBy(xpath="//button[@class='btn btn-default btn-lg btn-block effect ladda-button waves-effect']")
    WebElement SignIn;

     public void enterusername(String username)
     {
         Email.clear();
         Email.sendKeys(username);
     }
     public void enterpassword(String pwd)
     {
         password.clear();
         password.sendKeys(pwd);
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollBy(0,300)");
     }
     public void signIn()
     {
         SignIn.click();
         SetupPage.holdExcution(3);
         String sl = driver.getCurrentUrl();
         Assert.assertEquals("https://www.phptravels.net/account/dashboard",sl );
     }
 }

