package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPageSSO extends PageModel{
    SelenideElement loginPageSSOUsername=$("input[type=email]");
}
