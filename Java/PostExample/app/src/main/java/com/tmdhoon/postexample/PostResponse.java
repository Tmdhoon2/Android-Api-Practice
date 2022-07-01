package com.tmdhoon.postexample;

import android.text.Editable;

public class PostResponse {
    private Editable id;                                                                            // 접근제어수식어를 통해 같은 클래스에서만 접근이
    private String title;                                                                           // 가능한 필드 생성
    private String content;

    public Editable getId() {                                                                       // Id는 입력받기 때문에 Editable 로 선언
        return id;
    }

    public String getTitle() {                                                                      // title 문자열 형식으로 받아옴
        return title;
    }

    public String getContent() {                                                                    // 게시글의 내용을 불러옴
        return content;
    }
}
