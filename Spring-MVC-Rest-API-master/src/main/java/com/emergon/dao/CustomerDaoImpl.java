package com.emergon.dao;

import com.emergon.entities.Customer;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository//Apply it in DAO implementations
public class CustomerDaoImpl  implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;
//    private Session s;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public Customer findById(int id) {
        return getSession().find(Customer.class, id);
        //return super.findById(Customer.class, id);
    }

    @Override
    public int save(Customer customer) {
        getSession().save(customer);
        System.out.println("CustomerDaoiMpl:"+customer.getCcode());
        return customer.getCcode();
        //closeSession();
        //super.persist(customer);
    }
    @Override
    public void remove(int id) {
        Query q = getSession().createQuery("DELETE from Customer c WHERE c.ccode = :code");
        //Customer book = getSession().byId(Customer.class).load(id);
      //getSession().delete(book);
        q.setParameter("code", id);
        int result = q.executeUpdate();
    }

    @Override
    public List<Customer> findAll() {
        Query q = getSession().createQuery("SELECT c FROM Customer c");
        List<Customer> list = q.getResultList();
        //closeSession();
        return list;
    }

    @Override
    public List<Customer> findLikeName(String searchName) {
        //String query = "SELECT c FROM Customer c WHERE c.cname LIKE :name";
        Query q;
        if (searchName != null && searchName.trim().length() > 0) {
            String query = "FROM Customer WHERE LOWER(cname) LIKE :name";
            q = getSession().createQuery(query, Customer.class);
            q.setParameter("name", "%" + searchName.toLowerCase() + "%");
        } else {
            q = getSession().createQuery("SELECT c FROM Customer c", Customer.class);
        }

        List<Customer> list = q.getResultList();
        return list;
    }

    @Override
    public void update(int id, Customer customer) {
        Session session = sessionFactory.getCurrentSession();
      Customer customer2 = session.byId(Customer.class).load(id);
      //customer2.setCcode(customer.getCcode());
      customer2.setName(customer.getName());
      session.flush();
    }

}
