package framework;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public final class DriverFactory {

    private static PropertyManager props = new PropertyManager("selenium.properties");
    private static boolean isRemote = Boolean.parseBoolean(props.getProperty("remoteDriver"));

    public static RemoteWebDriver getDriver() {
        RemoteWebDriver driver = null;

        if (isRemote) {
            driver = new RemoteWebDriver(getRemoteURL(), DesiredCapabilities.firefox());
        } else {
            FirefoxProfile firefoxProfile = new FirefoxProfile();
            firefoxProfile.setEnableNativeEvents(false);
            driver = new FirefoxDriver(firefoxProfile);
        }
        return driver;
    }

    private static URL getRemoteURL() {
        // constructing HUB URL
        String remoteAddress = "http://" + props.getProperty("hubHost") + ":" + props.getProperty("hubPort") + "/wd/hub";

        URL remoteURL = null;
        try {
            remoteURL = new URL(remoteAddress);
        } catch (MalformedURLException malExc) {
            malExc.printStackTrace();
        }
        return remoteURL;
    }
}
