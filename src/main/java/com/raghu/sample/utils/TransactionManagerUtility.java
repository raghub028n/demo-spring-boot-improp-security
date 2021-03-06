package com.raghu.sample.utils;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Supplier;

@Component
public class TransactionManagerUtility {

    @Transactional(propagation = Propagation.REQUIRED)
    public <T> T runInCurrentTransaction(Supplier<T> supplier){
        return supplier.get();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public <T> T runInNewTransaction(Supplier<T> supplier){
        return supplier.get();
    }
}
