package singleton;

import singleton.util.PropertiesUtil;

import java.util.Properties;

public class ConfigurationSingleton {
    private static ConfigurationSingleton singleton;
    private static final String CONFIGURATION_PROP = "META-INF/Configuration.properties";
    private static final String APP_NAME_PROP="appName";
    private static final String APP_VERSION_PROP="appVersion";

    private String appName;
    private String appVersion;

    private ConfigurationSingleton(){
        Properties prop = PropertiesUtil.loadProperty(CONFIGURATION_PROP);
        this.appName = prop.getProperty(APP_NAME_PROP);
        this.appName = prop.getProperty(APP_VERSION_PROP);
    }

    private static synchronized void createInstance(){
        if(singleton == null){
            singleton = new ConfigurationSingleton();
        }
    }

    public static ConfigurationSingleton getInstance(){
        if(singleton==null){
            createInstance();
        }
        return singleton;
    }

    public static ConfigurationSingleton getSingleton() {
        return singleton;
    }

    public static void setSingleton(ConfigurationSingleton singleton) {
        ConfigurationSingleton.singleton = singleton;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }
}
