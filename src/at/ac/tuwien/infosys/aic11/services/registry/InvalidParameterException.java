
package at.ac.tuwien.infosys.aic11.services.registry;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.5.0
 * 2011-11-13T05:04:17.356+01:00
 * Generated source version: 2.5.0
 */

@WebFault(name = "invalid_parameter", targetNamespace = "http://services.aic11.infosys.tuwien.ac.at/")
public class InvalidParameterException extends Exception {
    
    private at.ac.tuwien.infosys.aic11.services.registry.InvalidParameter invalidParameter;

    public InvalidParameterException() {
        super();
    }
    
    public InvalidParameterException(String message) {
        super(message);
    }
    
    public InvalidParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidParameterException(String message, at.ac.tuwien.infosys.aic11.services.registry.InvalidParameter invalidParameter) {
        super(message);
        this.invalidParameter = invalidParameter;
    }

    public InvalidParameterException(String message, at.ac.tuwien.infosys.aic11.services.registry.InvalidParameter invalidParameter, Throwable cause) {
        super(message, cause);
        this.invalidParameter = invalidParameter;
    }

    public at.ac.tuwien.infosys.aic11.services.registry.InvalidParameter getFaultInfo() {
        return this.invalidParameter;
    }
}
