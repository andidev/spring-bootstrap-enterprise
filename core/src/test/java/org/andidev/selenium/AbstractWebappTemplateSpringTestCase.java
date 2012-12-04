package org.andidev.selenium;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;
import org.andidev.login.page.LoginPage;
import org.junit.Before;

public class AbstractWebappTemplateSpringTestCase extends AbstractBaseTestCase {

    //public WebappTemplateSpringSite ecoAdminSite;
    public LoginPage loginPage;
    //public SearchPage searchPage;
    //public SettingsPage settingsPage;

    @Before
//    @Override
    public void beforeTest() throws IOException {
//        super.beforeTest();

//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();

        //Field[] fields = 
        
        // Instantiate Page Objects
//        loginPage = new LoginPage(driver);
        //searchPage = new SearchPage(driver);
        //settingsPage = new SettingsPage(driver);

        // Instantiate Utils
//        ecoAdminSite = new EcoAdminSite(driver, loginPage, searchPage, 
//                personPage, placePage, worklistPage, bulkUpdatePage, mergePage, transactionsPage, 
//                newPersonPage, newPlacePage, opdbLookupPage, settingsPage);

    }
}
