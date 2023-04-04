package page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;

public class PageModel {

    protected static Logger LOGGER = LoggerFactory.getLogger(PageModel.class);

    /**
     * Test Id operations
     * These methods are prepared to provide testId to make code look cleaner
     */
    /**
     * Return selenide element based on dataTestId using standard format
     * @param dataTestId
     * @return
     */
    protected SelenideElement dataTestId(String dataTestId){
        if(dataTestId==null||dataTestId.length()<1){
            throw new IllegalArgumentException("Incorrect data test id!");
        }
        return $("[data-testid="+dataTestId+"]");
    }

    /**
     * Return selenide element based on dataTestId using css path
     * @param dataTestId
     * @param path
     * @return
     */
    protected SelenideElement dataTestId(String dataTestId,String path){
        if(dataTestId==null||dataTestId.length()<1){
            throw new IllegalArgumentException("Incorrect data test id!");
        }
        return $("[data-testid="+dataTestId+"]").find(By.cssSelector(path));
    }

    /**
     * Return selenide element based on dataTestId using global selector querry
     * @param dataTestId
     * @param by
     * @return
     */
    protected SelenideElement dataTestId(String dataTestId,By by){
        if(dataTestId==null||dataTestId.length()<1){
            throw new IllegalArgumentException("Incorrect data test id!");
        }
        return $("[data-testid="+dataTestId+"]").find(by);
    }

}
