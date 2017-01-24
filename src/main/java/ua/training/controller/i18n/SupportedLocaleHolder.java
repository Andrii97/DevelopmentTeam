package ua.training.controller.i18n;

import java.util.Arrays;
import java.util.Locale;

/**
 * Created by andrii on 23.01.17.
 */
public enum SupportedLocaleHolder {
    RU(new Locale("ru", "RU"), "ru", "ru_flag.jpg"),
    UA(new Locale("uk", "UA"), "ua", "ua_flag.jpg"),
    EN(new Locale("en", "EN"), "en", "en_flag.jpg");

    private static final SupportedLocaleHolder DEFAULT_LOCALE = EN;
    private final Locale locale;
    private final String param;
    private final String image;

    SupportedLocaleHolder(Locale locale, String param, String image) {
        this.locale = locale;
        this.param = param;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public Locale getLocale() {
        return locale;
    }

    public String getParam() {
        return param;
    }

    public static Locale getDefault() {
        return DEFAULT_LOCALE.getLocale();
    }

    public static SupportedLocaleHolder[] getLocales() {
        return values();
    }

    public static Locale getSupportedOrDefault(Locale locale) {
        return Arrays.stream(values())
                .map(SupportedLocaleHolder::getLocale)
                .filter(loc -> loc.equals(locale))
                .findAny()
                .orElse(getDefault());
    }

    public static Locale getSupportedOrDefault(String param) {
        return Arrays.stream(values())
                .filter(holder -> holder.param.equals(param))
                .map(SupportedLocaleHolder::getLocale)
                .findAny()
                .orElse(getDefault());
    }
}
