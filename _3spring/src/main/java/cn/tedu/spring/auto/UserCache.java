package cn.tedu.spring.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UserCache {
    private Cache cache;

    public Cache getCache() {
        return cache;
    }

    @Autowired
    @Qualifier("cacheImpl3")
    public void setCache(Cache cache) {
        this.cache = cache;
    }

    @Override
    public String toString() {
        return "UserCache{" + "cache=" + cache + '}';
    }
}
