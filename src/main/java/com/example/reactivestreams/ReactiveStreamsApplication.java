package com.example.reactivestreams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//Web Flux = 단일 thread & async + stream을 통해 back pressure가 적용될 만큼 간헐적 응답이 가능함
//+데이터 소비가 끝나면 응답이 종료됨
//+SSE 적용(얘는 프로토콜이니까 꼭 WebFlux에서만 동작하는애는 아니다. servlet에서도 사용할 수 있음)
//= 데이터 소비가 끝나도 stream이 계속 유지됨
@SpringBootApplication
public class ReactiveStreamsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveStreamsApplication.class, args);
        MyPub pub = new MyPub();
        MySub sub = new MySub();

        pub.subscribe(sub);
    }
}