package com.example.reactivestreams;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class MySub implements Subscriber<Integer> {

    private Subscription s;
    private int bufferSize = 2;

    @Override
    public void onSubscribe(Subscription s) {
        System.out.println("subscriber: i got a information of subscription");
        this.s = s;
        System.out.println("subscriber: i want one news everyday.");
        s.request(bufferSize);//구독정보 1개 받겠다
        //back pressure ?
    }

    @Override
    public void onNext(Integer integer) {
        System.out.println("transport subscribing data "+integer);
        bufferSize--;
        if(bufferSize==0){
            System.out.println("the day after");
            bufferSize = 2;
            s.request(bufferSize);
        }
    }

    @Override
    public void onError(Throwable t) {
        System.out.println("error on subscribing");
    }

    @Override
    public void onComplete() {
        System.out.println("complete subscribing");
    }
}
