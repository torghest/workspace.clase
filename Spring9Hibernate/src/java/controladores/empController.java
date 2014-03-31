/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controladores;

import Model.HibernateUtil;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author alumno
 */
public class empController implements Controller{

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv =new ModelAndView("empleados");
        String out= "Datos de los empleados:";
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List Result=session.createQuery("from Emp as emp").list();
        mv.addObject("empleados",Result);
        session.getTransaction().commit();
        mv.addObject("message", out);
        return mv;
    }

}
