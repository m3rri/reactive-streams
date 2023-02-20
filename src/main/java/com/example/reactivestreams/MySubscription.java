package com.example.reactivestreams;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Iterator;

//구독 정보 = {구독자, 구독 데이터 정보}
public class MySubscription implements Subscription {

    private Subscriber s;
    private Iterator<Integer> it;

    public MySubscription(Subscriber s, Iterable<Integer> it){
        this.s = s;
        this.it = it.iterator();
    }

    @Override
    public void request(long n) {
        while(n>0){
            if(it.hasNext()){
                s.onNext(it.next());
            }else{
                s.onComplete();
                break;
            }
            n--;
        }
    }

    @Override
    public void cancel() {

    }
}
