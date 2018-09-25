package by.cromwell.fastcache.service;


import by.cromwell.fastcache.model.CacheItem;

import javax.persistence.Cacheable;

public interface CacheItemService {

    CacheItem save(CacheItem item);


    CacheItem getCacheItemByKey(String key);
}
