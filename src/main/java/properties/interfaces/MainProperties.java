package properties.interfaces;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"file:src/main/resources/properties/main.properties",
        "system:properties",
        "system:env"})
public interface MainProperties extends Config {
    @Key("timeout.default")
    int defaultTimeout();

    @Key("fatsecret.user.name")
    String userName();

    @Key("fatsecret.user.password")
    String userPassword();

    @Key("fatsecret.user.email")
    String userEmail();

    @Key("remote.url")
    String remoteUrl();

    @Key("device.emulator.pixel")
    String deviceEmulatorPixel();

    @Key("fatsecret.package")
    String fatsecretPackage();

    @Key("fatsecret.startup.activity")
    String fatsecretStartupActivity();

}