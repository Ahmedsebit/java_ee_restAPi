package com.pluralsight.bookstore.model.util;

import java.util.Random;

public class IsbnGenerator implements NumberGenerator {
    @Override
    public String generateNumber(){
        return "13-4567"+Math.abs(new Random().nextInt());
    }
}