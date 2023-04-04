package login;

import org.testng.annotations.Test;
import page.LoginPage;

public class LoginPageTestSSO {

    @Test
    public void loginSSO1(){
        new LoginPage()
                .clickLoginWithSSO();
    }
}
