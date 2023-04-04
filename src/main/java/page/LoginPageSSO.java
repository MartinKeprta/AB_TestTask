package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class LoginPageSSO extends PageModel{
    private SelenideElement loginPageSSOUsername=$("input[type=email]");
    private SelenideElement loginPageUserNameErrorMessage=$("div[data-testid=email] [class*=errorMessage]");
    private SelenideElement loginPageSSOSignInButton=$("button");

    @Step("Set SSO username to {userName}")
    public LoginPageSSO setUserName(String userName){
        loginPageSSOUsername.click();
        loginPageSSOUsername.sendKeys(userName);
        return this;
    }

    @Step("Get sign in button status")
    public LoginPageSSO assertSignInButtonStatus(Boolean requiredDisabledStatus){
        sleep(1000);
        if(requiredDisabledStatus){
            loginPageSSOSignInButton.shouldHave(Condition.attribute("disabled"));
        }else {
            loginPageSSOSignInButton.shouldNotHave(Condition.attribute("disabled"));
        }
        return this;
    }

    /**
     * Assert that user name has required or none validation error
     * @param requiredMessage
     * @return
     */
    @Step("Assert username error message")
    public LoginPageSSO assertUserNameErrorMessage(String requiredMessage){
        if(requiredMessage.equals("")){
            loginPageUserNameErrorMessage.shouldNot(Condition.exist);
        }
        Assert.assertEquals(loginPageUserNameErrorMessage.text(),requiredMessage);
        return this;
    }


}
