package com.pluralsight.bookstore.model.util;

public class TextUtil{
    public String sanitize(String textToSanitize){
        return textToSanitize.replaceAll("\\s+", " ");
    }
}