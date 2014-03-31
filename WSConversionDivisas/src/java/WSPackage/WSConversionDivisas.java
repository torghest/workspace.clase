/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WSPackage;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author alumno
 */
@WebService(serviceName = "WSConversionDivisas")
public class WSConversionDivisas {

    public double[] valores = {1.26201, 14.4762, 75.6061, 135.861, 166.386};
    
    /**
     * Web service operation
     * @param valor
     * @param indice
     * @return 
     */
    @WebMethod(operationName = "convertirAdivisa")
    public Double convertirAdivisa(@WebParam(name = "valor") double valor, @WebParam(name = "indice") int indice) {
        //TODO write your implementation code here:
        return valor*valores[indice];
    }

    /**
     * Web service operation
     * @param valor
     * @param indice
     * @return 
     */
    @WebMethod(operationName = "convertirAeuro")
    public Double convertirAeuro(@WebParam(name = "valor") double valor, @WebParam(name = "indice") int indice) {
        //TODO write your implementation code here:
        return valor/valores[indice];
    }
}
