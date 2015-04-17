package framework;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    private PropertyManager props = new PropertyManager("application.properties");
    protected RemoteWebDriver driver = null;
    protected LoggerWrap logger = null;

    @BeforeClass
    public void initialize() {
        logger = LoggerWrap.getLogger();
        driver = DriverFactory.getDriver();
        driver.get(props.getProperty("startPage"));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void shutDown() {
        driver.quit();
    }

}
