package com.itzone.itzone.oauth;

import lombok.Getter;

@Getter
public enum OAuthProvider {
    KAKAO(OAuth.KAKAO),
    NAVER(OAuth.NAVER),
    GOOGLE(OAuth.GOOGLE),
    GITHUB(OAuth.GITHUB);

    private final String provider;

    OAuthProvider(String provider) {
        this.provider = provider;
    }

    public static class OAuth {
        public static final String KAKAO = "KAKAO";
        public static final String NAVER = "NAVER";
        public static final String GOOGLE = "GOOGLE";
        public static final String GITHUB = "GITHUB";
    }
}
