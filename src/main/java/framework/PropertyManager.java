package framework;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertyManager {

    private LoggerWrap logger = LoggerWrap.getLogger();
    private Properties properties = new Properties();

    public PropertyManager(String resourceName) {
        properties = appendResource(properties, resourceName);
    }

    public String getProperty(String keyValue) {
        return properties.getProperty(keyValue);
    }

    private Properties appendResource(Properties props, String propsResource) {
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream(propsResource);
        if (stream != null) {
            try {
                props.load(stream);
                stream.close();
            } catch (IOException ioExc) {
                ioExc.printStackTrace();
            }
        } else {
            logger.logInfo(String.format("Resource \"%1$s\" could not be found", propsResource));
        }
        return props;
    }
}
