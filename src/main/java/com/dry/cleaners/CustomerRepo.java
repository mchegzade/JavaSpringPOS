package com.dry.cleaners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
@Repository
public class CustomerRepo {
    @Autowired
    EntityManager em;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Customer findById(int id){
        return em.find(Customer.class, id);
    }

    public Customer findByName(String name){
        TypedQuery<Customer> c = em.createQuery("SELECT c FROM Customer c WHERE name='"+name+"'",Customer.class);
        return c.getSingleResult();
    }

    public void deleteById(int id){
        Customer customer = findById(id);
        em.remove(customer);
    }

    public Customer save(Customer customer){
        if(Integer.valueOf(customer.getId()).equals(null)){
            em.persist(customer);
        }else {
            em.merge(customer);
        }
        return customer;
    }

}

