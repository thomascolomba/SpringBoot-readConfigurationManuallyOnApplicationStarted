package readConfigurationManuallyOnApplicationStarted.util;

import java.lang.reflect.InvocationTargetException;
import org.apache.commons.beanutils.BeanUtilsBean;

/**
 * Allows the copy of non null members from an object in another (so we can have several use to populate 1 object) 
 */
public class MyNullAwareBeanUtilBean extends BeanUtilsBean{
    @Override
    public void copyProperty(Object dest, String name, Object value)
            throws IllegalAccessException, InvocationTargetException {
        if(value==null)return;
        super.copyProperty(dest, name, value);
    }
}