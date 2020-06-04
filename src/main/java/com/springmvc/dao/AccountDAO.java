package com.springmvc.dao;

import com.springmvc.entities.Account;
import lombok.Data;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.List;

@Data
@Repository(value = "accountDAO")
@Transactional(rollbackFor = PersistenceException.class)
public class AccountDAO {
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    public AccountDAO(LocalSessionFactoryBean sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(final Account account) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        session.persist(account);
    }

    public void update(final Account account) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        session.update(account);
    }

    public Account findByUsername(String username) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.createQuery("from Account where username =:username", Account.class)
                .setParameter("username", username)
                .uniqueResult();
    }

    public Account checkCorrectPassword(Account account) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.createQuery("from Account where username=:username and password =:password", Account.class)
                .setParameter("username", account.getUsername())
                .setParameter("password", account.getPassword())
                .uniqueResult();
    }

    public void delete(final Account account) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        session.remove(account);
    }

    public List<Account> findAll() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.createQuery("from Account", Account.class).getResultList();
    }
}
