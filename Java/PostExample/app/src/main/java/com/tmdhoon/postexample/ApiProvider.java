package com.tmdhoon.postexample;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiProvider {                                                      // ApiProvider 클래스 생성
    private static Retrofit retrofit;                                           // Retrofit 필드를 선언한다
    private static String BASE_URL = "http://13.125.227.67:8080";               // baseurl 필드 선언

    public static Retrofit getRetrofit() {                                      // 모든 클래스나 패키지에서 getRetrofit 함수에 접근 가능하게 만든다
        if(retrofit==null){                                                     // Retrofit 이 null 일때,
            retrofit = new Retrofit.Builder()                                   // Retrofit Builder 를 통해 레트로핏을 생성한다
                    .baseUrl(BASE_URL)                                          // baseurl은 위에서 가져오고
                    .addConverterFactory(GsonConverterFactory.create())         // addConverterFactory를 통해 json 형식의 파일 내용을 받아옴
                    .build();                                                   // 위에서 선언한 것들을 이용하여 레트로핏 생성
        }
        return retrofit;                                                        // 레트로핏 반환
    }
}
