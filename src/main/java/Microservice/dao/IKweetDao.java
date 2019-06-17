package Microservice.dao;

import Microservice.model.Kweet;
import nl.tbc.rekeningrijden.database.dao.IBaseDao;

import java.util.Collection;

public interface IKweetDao extends IBaseDao<Kweet> {

    Collection<Kweet> searchKweet(String searchContent);

    Collection<Kweet> getTimeline(int userId);

    Collection<Kweet> getLatestKweets(int userId);
}
