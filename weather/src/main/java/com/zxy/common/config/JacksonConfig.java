//package com.zxy.common.config;
//
//import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
//import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
//import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
//import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
//        import org.springframework.context.annotation.Bean;
//        import org.springframework.context.annotation.Configuration;
//
//import java.time.format.DateTimeFormatter;
//
//@Configuration
//public class JacksonConfig {
//    @Bean
//    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
//        return builder -> {
//
//
//            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//            builder.serializers(new LocalDateSerializer(dateFormatter));
//            builder.serializers(new LocalDateTimeSerializer(dateTimeFormatter));
//
//            builder.serializerByType(Long.class, ToStringSerializer.instance); // 将Long包装类序列化为字符串
//            builder.serializerByType(Long.TYPE, ToStringSerializer.instance); // 将long基本类型序列化为字符串
//        };
//    }
//}