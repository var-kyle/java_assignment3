/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferobjects.factory;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * makes creating factories a lot easier
 * 
 * @author not me
 */
public final class DTOFactoryCreator {
    private static final String PACKAGE = "transferobjects.factory.";
    private static final String FACTORY = "Factory";

    private DTOFactoryCreator() {
    }
    
    /**
     * gets the corresponding factory of the type provided, using magic
     * @param <T>
     * @param factoryName
     * @return 
     */
    @SuppressWarnings("unchecked")
    public static <T> Factory<T> getFactory(String factoryName) {
        Factory<T> factory = null;
        try {
            factory = (Factory< T>) Class.forName(PACKAGE + factoryName + FACTORY).newInstance();
        } catch (Exception ex) {
            Logger.getLogger(DTOFactoryCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return factory;
    }

    /**
     * gets the corresponding builder of the type provided.
     * @param <T>
     * @param type
     * @return 
     */
    public static <T> Factory<T> createBuilder(Class<T> type) {
        return getFactory(type.getSimpleName());
    }
}
