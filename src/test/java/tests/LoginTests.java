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

    @Test
    public void loginWrongPassword() {
        User user = new User().setEmail("romaabc@maile.com").setPassword("Abcd1234");
        logger.info("Test start with test data --->" + " email : 'marga@gmail.com' & password : 'Mmar123'");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
    }

    @Test
    public void loginUnregisteredUser() {
        User user = new User().setEmail("romaaaa@maile.com").setPassword("Abc1234$");
        logger.info("Test start with test data --->" + " email : 'maaa@gmail.com' & password : 'Maa123456$'");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");

    }

    @Test
    public void loginEmptyEmail() {
        User user = new User().setEmail("").setPassword("");
        logger.info("Test start with test data --->" + " email : ' ' & password : 'Abcd1234$'");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Email is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }

    @Test
    public void loginEmptyPassword() {
        User user = new User().setEmail("romaabc@maile.com").setPassword("");
        logger.info("Test start with test data --->" + " email : 'romaabc@maile.com' & password : ''");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Password is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }


    @AfterMethod
    public void postCondition() {
        app.getHelperUser().clickOKButton();
    }

}