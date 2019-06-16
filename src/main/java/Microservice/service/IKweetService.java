package Microservice.service;

import Microservice.model.Kweet;
import nl.tbc.rekeningrijden.services.base.IBaseService;

import java.util.Collection;

public interface IKweetService extends IBaseService<Kweet> {

    Collection<Kweet> searchKweet(String searchContent);
}
