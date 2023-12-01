package br.com.lacoos.utils;

import org.springframework.beans.factory.annotation.Value;

public class ApplicationUtils {

    @Value("${site.url}")
    public static String siteUrl;

}