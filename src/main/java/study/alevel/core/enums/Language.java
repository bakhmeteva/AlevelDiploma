package study.alevel.core.enums;

public enum Language {
    UA("Українська"),
    RU("Русский");

    private final String displayName;

    Language(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}