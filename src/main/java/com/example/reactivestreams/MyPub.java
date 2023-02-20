package com.example.reactivestreams;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.Arrays;

public class MyPub implements Publisher<Integer> {

    Iterable<Integer> its = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

    @Override
    public void subscribe(Subscriber<? super Integer> s) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("subscriber: i will subscribe your news");

        System.out.println("publisher : please wait for creating subscription information");

        MySubscription subscription = new MySubscription(s, its);
        System.out.println("publisher : complete to create information of subscription.");
        s.onSubscribe(subscription);
    }
}
