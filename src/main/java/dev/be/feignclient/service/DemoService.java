package dev.be.feignclient.service;

import dev.be.feignclient.feign.client.DemoFeignClient;
import dev.be.feignclient.feign.common.dto.BaseResponseInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DemoService {

    private final DemoFeignClient demoFeignClient;
    public String get() {
        ResponseEntity<BaseResponseInfo> response = demoFeignClient.callGet("CustomHeader", "CustomName", 1L);
        log.info("Name : {}",response.getBody().getName());
        log.info("Age : {}",response.getBody().getAge());
        log.info("Header : {}",response.getBody().getHeader());
        return "get";
    }
}
