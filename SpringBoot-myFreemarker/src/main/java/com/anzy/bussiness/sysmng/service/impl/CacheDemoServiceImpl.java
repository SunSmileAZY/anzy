package com.anzy.bussiness.sysmng.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.anzy.bussiness.sysmng.entity.Thing;
import com.google.common.collect.Lists;

@Service
public class CacheDemoServiceImpl {

    private static Map<Long, Thing> data = new HashMap<>();//用与缓存模拟数据

    /**
     * 缓存的key
     */
    public static final String THING_ALL_KEY = "\"thing_all\"";
    /**
     * value属性表示使用哪个缓存策略，缓存策略在ehcache.xml
     */
    public static final String DEMO_CACHE_NAME = "demo";

    @CacheEvict(value = DEMO_CACHE_NAME, key = THING_ALL_KEY)
    public void create(Thing thing) {
        thing.setId(thing.getId());
        data.put(thing.getId(), thing);
    }

    @Cacheable(value = DEMO_CACHE_NAME, key = "#thing.id")
    public Thing findById(Thing thing) {
        Long id=thing.getId();
        System.err.println("没有走缓存！" + id);
        return data.get(id);
    }

    @Cacheable(value = DEMO_CACHE_NAME, key = THING_ALL_KEY)
    public List<Thing> findAll() {
        return Lists.newArrayList(data.values());
    }

    @CachePut(value = DEMO_CACHE_NAME, key = "#thing.id")
    @CacheEvict(value = DEMO_CACHE_NAME, key = THING_ALL_KEY)
    public Thing update(Thing thing) {
        System.out.println(thing);
        data.put(thing.getId(), thing);
        return thing;
    }

    @CacheEvict(value = DEMO_CACHE_NAME)
    public void delete(Long id) {
        data.remove(id);
    }

}