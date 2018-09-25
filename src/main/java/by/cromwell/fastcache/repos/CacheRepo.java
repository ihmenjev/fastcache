package by.cromwell.fastcache.repos;

import by.cromwell.fastcache.model.CacheItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CacheRepo extends CrudRepository<CacheItem, String> {


    CacheItem findByKey(String key);
}
