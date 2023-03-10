package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.loader.custom.sql.SQLQueryReturnProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    //   public User getUserFromTable(String model , int series){
//      Result = sessionFactory.getCurrentSession()
//              .createSQLQuery("select model= '"+model+"' and series = '"+series+"' from cars" );
//      return users.get(0);
//   }
    public User getUserFromTable(String model, int series) {
       try {
           ResultSet rs = (ResultSet) sessionFactory.getCurrentSession()
                   .createSQLQuery("select model= '" + model + "' and series = '" + series + "' from cars");

               while (rs.next()) {

                   if (!rs.next()) break;
                   String id = rs.getObject(1).toString();

                   return (User) sessionFactory.getCurrentSession().createSQLQuery("select * from users where car = '" + id + "'");
               }

       }catch (Exception e ){

           System.out.println("Pizdec"+e.getMessage());

       }
return  new User("Huila", "konchanniy", "gmail.hui");
}

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

}
