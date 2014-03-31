/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package consumirwsnombre;

/**
 *
 * @author alumno
 */
public class ConsumirWSNombre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(nombre());
    }

    private static String nombre() {
        consumirWSNombre.WebService1_Service service = new consumirWSNombre.WebService1_Service();
        consumirWSNombre.WebService1 port = service.getWebService1Port();
        return port.nombre();
    }
    
}
