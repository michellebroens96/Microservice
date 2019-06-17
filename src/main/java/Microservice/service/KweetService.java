package Microservice.service;

import Microservice.dao.IKweetDao;
import Microservice.model.Kweet;
import nl.tbc.rekeningrijden.services.base.BaseService;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;

@RequestScoped
@Named("KweetService")
@Default
public class KweetService extends BaseService<Kweet, IKweetDao> implements IKweetService {

    @Inject
    IKweetDao kweetDao;

    @Override
    public Collection<Kweet> searchKweet(String searchContent) {
        return kweetDao.searchKweet(searchContent);
    }

    @Override
    public Collection<Kweet> getTimeline(int userId) {
        return kweetDao.getTimeline(userId);
    }

    @Override
    public Collection<Kweet> getLatestKweets(int userId) {
        return kweetDao.getLatestKweets(userId);
    }
}
