package by.cromwell.fastcache.service;

import by.cromwell.fastcache.model.CacheItem;
import by.cromwell.fastcache.repos.CacheRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;



@Service
public class CacheItemServiceImpl implements CacheItemService {

    @Autowired
    CacheRepo cacheRepo;

    @Override
    @CachePut(value = "cacheItems", key="#item.key")
    public CacheItem save(CacheItem item) {
        return cacheRepo.save(item);
    }

    @Override
    @Cacheable(value = "cacheItems", key="#key")
    public CacheItem getCacheItemByKey(String key) {
        //simulateSlowService();
        return cacheRepo.findByKey(key);
    }

    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}
