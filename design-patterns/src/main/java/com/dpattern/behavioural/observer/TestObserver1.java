package com.dpattern.behavioural.observer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestObserver1 extends Observer {

    public TestObserver1(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
        log.info("Adding Observer {}", this.getClass().getSimpleName());
    }

    @Override
    public void update() {
        log.info("TestObserver1 is updated with..{}", this.subject.getState());
    }

}
