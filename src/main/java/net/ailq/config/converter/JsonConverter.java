package net.ailq.config.converter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.google.common.collect.Lists;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by LiLongLong on 2017/7/19
 * 重写spring boot默认json转换，更改为fastJson
 * @author lllsmiling
 */
@Component
public class JsonConverter {
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
            SerializerFeature.PrettyFormat,
            SerializerFeature.WriteNullStringAsEmpty,
//            SerializerFeature.WriteNullListAsEmpty,
            SerializerFeature.WriteNullBooleanAsFalse,
            SerializerFeature.WriteNullNumberAsZero,
            SerializerFeature.WriteMapNullValue
        );
        fastConverter.setFastJsonConfig(fastJsonConfig);
        List<MediaType> mediaTypeList = Lists.newArrayList();
        mediaTypeList.add(MediaType.APPLICATION_JSON_UTF8);
        fastConverter.setSupportedMediaTypes(mediaTypeList);
        return new HttpMessageConverters(fastConverter);
    }
}
