package org.iesabatos.dam.fabricacion;

import org.hibernate.Session;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Fabrica a = new Fabrica();
        Articulo c = new Articulo();
        List<Pedido> b = new ArrayList<Pedido>();
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();


        a.setNombre("Lacasa");

        c.setNombre("Camión");
        c.setPrecio(BigDecimal.valueOf(500.00));
        c.setNum(0);

        b.add(new Pedido());
        b.get(0).setFabrica(a);
        b.get(0).setFecha(new Date());
        b.get(0).setServido(true);
        b.get(0).setUnidades(50);
        b.get(0).setUrgente(false);
        b.get(0).setUrgente(false);
        b.get(0).setArticulo(c);

        a.setPedidos(b);

        c.setPedidos(b);

        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.save(b.get(0));
        sesion.getTransaction().commit();
        sesion.close();




    }
}
