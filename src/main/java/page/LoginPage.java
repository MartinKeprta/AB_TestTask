package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends PageModel {
    //Main elements
    private SelenideElement loginPageUserName=$("#email");
    private SelenideElement loginPageUserPass=$("#password");
    private SelenideElement loginPageUserPassShowIcon=dataTestId("showIcon");
    private SelenideElement loginPageSignInButton=$("[class*=FormButtonRow__buttonRow] button");
    //Error messages
    private SelenideElement loginPageUserNameErrorMessage=$("div[data-testid=email] [class*=errorMessage]");
    private SelenideElement loginPageUserPassErrorMessage=$("div[data-testid=password] [class*=Input-module__error]");
    //Text
    private SelenideElement loginPageSignInTitle=$("h1");
    //SSO Login
    private SelenideElement loginPageSignInSSO=$("div[class*=LoginForm__ssoSection] button");
    public LoginPage(){
        open("https://app2.abtasty.com/login");
    }

    @Step("Set user name")
    public LoginPage setUserName(String username){
        loginPageUserName.click();
        loginPageUserName.sendKeys(username);
        return this;
    }

    @Step("Set user password")
    public LoginPage setUserPass(String userPass){
        loginPageUserPass.click();
        loginPageUserPass.sendKeys(userPass);
        //To update frontend event.
        loginPageUserName.click();
        return this;
    }

    public LoginPage clickSignIn(){
        return this;
    }

    /**
     * Returns true if button is disabled , return false if it is enabled
     * @return
     */
    @Step("Get sign in button status")
    public LoginPage assertSignInButtonStatus(Boolean requiredDisabledStatus){
        sleep(1000);
        if(requiredDisabledStatus){
            loginPageSignInButton.shouldHave(Condition.attribute("disabled"));
        }else {
            loginPageSignInButton.shouldNotHave(Condition.attribute("disabled"));
        }
        return this;
    }

    /**
     * Method for seamless login for more complex testcases
     * @param userName
     * @param userPass
     */
    public void login(String userName,String userPass){
        setUserName(userName);
        setUserPass(userPass);
    }

    /**
     * Assert that user name has required or none validation error
     * @param requiredMessage
     * @return
     */
    @Step("Assert username error message")
    public LoginPage assertUserNameErrorMessage(String requiredMessage){
        if(requiredMessage.equals("")){
            loginPageUserNameErrorMessage.shouldNot(Condition.exist);
        }
        Assert.assertEquals(loginPageUserNameErrorMessage.text(),requiredMessage);
        return this;
    }

    /**
     * Assert that user pass has required or none validation error
     * @param requiredMessage
     * @return
     */
    @Step("Assert userpass error message")
    public LoginPage assertUserPassErrorMessage(String requiredMessage){
        if(requiredMessage.equals("")){
            loginPageUserNameErrorMessage.shouldNot(Condition.exist);
        }
        Assert.assertEquals(loginPageUserNameErrorMessage.text(),requiredMessage);
        return this;
    }

    @Step("Click on login with SSO")
    public LoginPageSSO clickLoginWithSSO(){
        loginPageSignInSSO.click();
        return new LoginPageSSO();
    }






}
