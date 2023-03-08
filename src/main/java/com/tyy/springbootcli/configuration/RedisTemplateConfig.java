package com.tyy.springbootcli.configuration;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisTemplateConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        // 创建实例对象
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        // key序列化方式: 创建string序列化方式
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        // value序列化方式: 创建Jackson序列化方式
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(mapper);
        // 设置key序列化方式
        template.setKeySerializer(stringRedisSerializer); // string数据类型的key序列化
        template.setHashKeySerializer(stringRedisSerializer); // hash数据类型的key序列化
        // 设置value序列化方式
        template.setValueSerializer(jackson2JsonRedisSerializer); // string数据类型的value序列化
        template.setHashValueSerializer(jackson2JsonRedisSerializer); // hash数据类型的value序列化
        template.afterPropertiesSet();
        return template;
    }
}
