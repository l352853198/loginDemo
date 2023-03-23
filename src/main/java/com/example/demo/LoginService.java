package com.example.demo;

import feign.codec.Decoder;
import java.util.Collections;
import java.util.List;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(url = "http://10.211.4.104:8101",name="login",configuration = LoginService.FeignConfig.class)
public interface LoginService {


    @GetMapping(value = "/svcManager/UserSingleLoginServlet")
    String login(@RequestParam("xml") String req);

    class FeignConfig{
        @Bean
        public Decoder octerDecoder(){
            return new SpringDecoder(()->new HttpMessageConverters(new CustomJackson2HttpMessageConverter()));
        }
    }

    class CustomJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter{

        @Override
        public void setSupportedMediaTypes(List<MediaType> supportedMediaType){
            super.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_OCTET_STREAM));
        }
    }

}
