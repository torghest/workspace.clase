/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ServiciosWeb;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author alumno
 */
@WebService(serviceName = "WSOptica")
public class WSOptica {

    /**
     * Web service operation
     * @param product
     * @return 
     */
    @WebMethod(operationName = "descriptionProduct")
    public String descProduct(@WebParam(name = "product") String product) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     * @param product
     * @return 
     */
    @WebMethod(operationName = "priceProduct")
    public int priceProduct(@WebParam(name = "product") String product) {
        //TODO write your implementation code here:
        return 0;
    }
}
