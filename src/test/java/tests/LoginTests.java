package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test
    public void loginSuccess() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("romaabc@maile.com", "Abcd1234$");
        app.getHelperUser().submitLogin();
        //Assert if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        //app.getHelperUser().clickOKButton();
    }

    @Test
    public void loginSuccess1() {
        User user = new User().setEmail("romaabc@maile.com").setPassword("Abcd1234$");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");

    }

    @Test
    public void loginSuccessModel() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("romaabc@maile.com", "Abcd1234$");
        app.getHelperUser().submitLogin();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");

    }

    @Test
    public void loginWrongEmail() {
        User user = new User().setEmail("romaabc@maile.com").setPassword("Abcd1234$");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submitLogin();
        //Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");

    }

    @AfterMethod
    public void postCondition() {
        app.getHelperUser().clickOKButton();
    }

}