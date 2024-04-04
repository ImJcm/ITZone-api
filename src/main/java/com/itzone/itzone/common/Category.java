package com.itzone.itzone.common;

import lombok.Getter;

@Getter
public enum Category {
    Bottom(Classtification.Bottom),
    Middle(Classtification.Middle),
    Top(Classtification.Top);
    private final String classtification;

    Category(String classtification) {
        this.classtification = classtification;
    }

    public static class Classtification {
        public static final String Bottom = "BOTTOM";
        public static final String Middle = "MIDDLE";

        public static final String Top = "TOP";
    }
}
