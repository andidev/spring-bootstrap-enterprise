package org.andidev.login.page;

import org.andidev.selenium.WebPage;
import static org.andidev.selenium.WebDriverBot.*;
import static org.junit.Assert.fail;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author  Automation
 */
public class LoginPage extends WebPage<LoginPage>  {
    
    @FindBy(css = "#j_username")
    private WebElement username;
    @FindBy(css = "#j_password")
    private WebElement password;
    private WebElement rememberMe;
    private WebElement loginButton;
    private WebElement message;
    
    public LoginPage(WebDriver driver) {
        super(driver);        
    }

    @Override
    public void load() {
        getDriver().get("http://localhost:8080/login");
    }
    
    @Override
    public void isLoaded() throws Error {
        try {
            getDriver().findElement(By.cssSelector("body#loginPage"));
        } catch (NoSuchElementException e) {
            fail("Cannot load login page");
        }
    }
    
    public void login(String username, String password, boolean rememberMe) {
        clearAndType(username, this.username);
        clearAndType(password, this.password);
        check(this.rememberMe);
        click(this.loginButton);
    }
       
}
