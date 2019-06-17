package Microservice.dao;

import Microservice.model.Kweet;
import nl.tbc.rekeningrijden.database.dao.BaseDao;
import org.hibernate.Session;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RequestScoped
@Default
public class KweetDao extends BaseDao<Kweet> implements IKweetDao {

    public KweetDao() {
        this.persistentClass = Kweet.class;
    }

    @Override
    public Collection<Kweet> searchKweet(String searchContent) {
        Session session = getSession();
        Collection<Kweet> kweets = new ArrayList<>();
        Query query = session.createQuery("from Kweet k where k.content like '%'||k.content||'%'");

        for(Kweet kweet : (List<Kweet>) query.getResultList()) {
            kweets.add(kweet);
        }
        return kweets;
    }

    @Override
    public Collection<Kweet> getTimeline(int userId) {
        return null;
    }

    @Override
    public Collection<Kweet> getLatestKweets(int userId) {
        return null;
    }

}
