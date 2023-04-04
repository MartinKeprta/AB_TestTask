package login;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.LoginPage;

public class LoginPageTestStandard {

    @DataProvider(name = "invalidEmailDataProvider")
    public Object[] emailValidationValue(){
        return new Object[]{"#@%^%#$@#$@#.com","plain address","Joe Smith <email@domain.com>","email.domain.com","email@domain@domain.com"};
    }

    /**
     * Sign in button should be disabled when no credentials are set
     */
    @Test
    @Story("Login")
    @Severity(SeverityLevel.CRITICAL)
    @Description("As user I want to login with empty credentials and check that sign in button is disabled")
    public void login1() {
        new LoginPage()
                .assertSignInButtonStatus(true)
                .setUserPass("")
                .setUserName("")
                .assertSignInButtonStatus(true);


    }

    @Test
    @Story("Login")
    @Severity(SeverityLevel.CRITICAL)
    @Description("As user I want to login with correct username and correct password and check that sign in button is enabled")
    @Parameters({"validUserName","validUserPass"})
    public void login2(String validUserName,String validUserPass){
        new LoginPage()
                .assertSignInButtonStatus(true)
                .setUserPass(validUserName)
                .setUserName(validUserPass)
                .assertSignInButtonStatus(false)
                .clickSignIn();
    }

    @Test (dataProvider = "invalidEmailDataProvider")
    @Story("Login")
    @Severity(SeverityLevel.CRITICAL)
    @Description("As user I want to enter inccorect email and check that sign in button is disabled and check valid error message")
    public void login3(String email){
        new LoginPage()
                .assertSignInButtonStatus(true)
                .setUserName(email)
                .setUserPass("")
                .assertSignInButtonStatus(true)
                .assertUserNameErrorMessage("Please enter a valid email");

    }






}
