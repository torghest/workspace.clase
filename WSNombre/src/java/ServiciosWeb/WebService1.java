/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ServiciosWeb;

import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author alumno
 */
@WebService(serviceName = "WebService1")
public class WebService1 {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Nombre")
    public String Nombre() {
        //TODO write your implementation code here:
        return "Hola Benito Floro hoy es: "+(new Date()).toString();
    }
}
