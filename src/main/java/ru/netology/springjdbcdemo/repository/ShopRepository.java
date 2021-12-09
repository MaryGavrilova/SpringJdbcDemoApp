package ru.netology.springjdbcdemo.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ShopRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<String> getProductName(String name) {
        TypedQuery<String> query = entityManager.createQuery
                ("select o.productName from Order o join o.customer c where c.name like :name", String.class);
        query.setParameter("name", name);
        return query.getResultList();
    }
}
