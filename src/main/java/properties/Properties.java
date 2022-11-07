package properties;

import org.aeonbits.owner.ConfigFactory;
import properties.interfaces.MainProperties;

public class Properties {
    public final static MainProperties mainProperties = ConfigFactory.create(MainProperties.class);

}
