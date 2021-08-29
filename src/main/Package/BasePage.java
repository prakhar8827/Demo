import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BasePage extends SetupPage {
    public  WebDriver driver;

    public BasePage(WebDriver driver1)
    {
        this.driver = driver1;
        PageFactory.initElements(driver,this);
    }

@FindBy(xpath = "//div[@class='logo']")
    WebElement logo;
@FindBy(xpath = "//button[@id='currency']")
    WebElement currencydropdown;
@FindBy(xpath="/ul[@class='dropdown-menu show']")
WebElement currencylist;
@FindBy(xpath = "//a[@class='theme-btn theme-btn-small waves-effect']")
WebElement SignupButton;
@FindBy(xpath="//a[@class='theme-btn theme-btn-small theme-btn-transparent ml-1 waves-effect']")
WebElement SignInButton;
@FindBy(xpath = "//div[@class='main-menu-content']//a[contains(@class,'waves-effect')][normalize-space()='Company']")
WebElement Company;
@FindBy(xpath="//div[@class='main-menu-content']//nav//ul//li[@class='footm']//ul[@class='dropdown-menu-item']//li//a[contains(@class,'waves-effect')][normalize-space()='About Us']")
WebElement AboutUsbutton;
@FindBy(xpath = "//div[@class='main-menu-content']//nav//ul//li[@class='footm']//ul[@class='dropdown-menu-item']//li//a[@class=' waves-effect'][normalize-space()='Terms of Use']")
WebElement Terms;
@FindBy(xpath="//div[@class='main-menu-content']//nav//ul//li[@class='footm']//ul[@class='dropdown-menu-item']//li//a[@class=' waves-effect'][normalize-space()='FAQ']")
WebElement FAQ;

public void faqButton()
{
    WebElement cmp = Company;
    Actions act = new Actions(driver);
    act.moveToElement(cmp).perform();
    SetupPage.holdExcution(3);
    FAQ.click();
    String faq = driver.getCurrentUrl();
    Assert.assertEquals("https://www.phptravels.net/faq",faq);

}

public void termsOfUsebutton()
{
    WebElement cmp = Company;
    Actions a = new Actions(driver);
    a.moveToElement(cmp).perform();
    SetupPage.holdExcution(3);
    Terms.click();
    String tm = driver.getCurrentUrl();
    Assert.assertEquals("https://www.phptravels.net/terms-of-use",tm);
}


public void aboutbutton()
{
    WebElement cmp = Company;
    Actions a = new Actions(driver);
    a.moveToElement(cmp).perform();
    SetupPage.holdExcution(3);
    AboutUsbutton.click();
    String ab = driver.getCurrentUrl();
    Assert.assertEquals("https://www.phptravels.net/about-us",ab);
}


public void clickCompnay()
{
    //Company.click();
    List<String> exptecedcompany = new ArrayList<String>();
    exptecedcompany.add("About Us");
    exptecedcompany.add("Terms Of Use");
    exptecedcompany.add("FAQ");
    System.out.println(exptecedcompany);

    WebElement cmp = Company;
    Actions a = new Actions(driver);
    a.moveToElement(cmp).perform();
    SetupPage.holdExcution(3);
    List<WebElement> companyDropDown = driver.findElements(By.xpath("//div[@class='main-menu-content']//ul[@class='dropdown-menu-item']"));
    List dropdowncompany = new ArrayList();
    for(WebElement e1:companyDropDown)
    {
        dropdowncompany.add(e1.getText().replace("\n",", "));
        System.out.print(dropdowncompany);
    }
    Assert.assertEquals(exptecedcompany.toString(),dropdowncompany.toString());

}

    public void logoenabled()
    {
        //logo.isDisplayed();
        Assert.assertTrue(logo.isDisplayed());
    }
    public void setCurrencydropdown()
    {
        List laguages = new ArrayList();
        laguages.add("USD");
        laguages.add("GBP");
        laguages.add("SAR");
        laguages.add("EUR");
        laguages.add("PKR");
        laguages.add("JPY");
        laguages.add("INR");
        laguages.add("CNY");
        laguages.add("TRY");
        laguages.add("RUB");
        System.out.println(laguages);
        currencydropdown.click();
        SetupPage.holdExcution(3);
        List<WebElement> options = driver.findElements(By.xpath("//ul[@class='dropdown-menu show']"));
        List dropdownlanguage = new ArrayList();
        for (WebElement e2 : options) {
            dropdownlanguage.add(e2.getText().replace("\n",", "));
            System.out.println(dropdownlanguage);
        }
        Assert.assertEquals(dropdownlanguage.toString(), laguages.toString());
        currencydropdown.click();
        SetupPage.holdExcution(3);
    }

   public void clickSignup()
   {
       SignupButton.click();
       String ul =driver.getCurrentUrl();
       Assert.assertEquals("https://www.phptravels.net/signup",ul);
   }

   public void clickSignIn()
   {
       SignInButton.click();
       String ul =driver.getCurrentUrl();
       Assert.assertEquals("https://www.phptravels.net/login",ul);


   }

}
