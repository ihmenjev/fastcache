package by.cromwell.fastcache.controller;

import by.cromwell.fastcache.model.CacheItem;
import by.cromwell.fastcache.service.CacheItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class CacheController {

    @Autowired
    private CacheItemService cacheItemService;


    @GetMapping("{key}")
    public ResponseEntity getItemCashe(@PathVariable String key) {
        CacheItem item = cacheItemService.getCacheItemByKey(key);
        if (item == null) {
            Map<String, String> response = new HashMap<>();
            response.put("key", key);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity insertItemCashe(@RequestBody CacheItem cacheItem) {
        cacheItemService.save(cacheItem);
        Map<String, String> response = new HashMap<>();
        response.put("key", cacheItem.getKey());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
