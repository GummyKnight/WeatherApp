package com.example.weatherapp.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ConditionID {
        THUNDERSTORM_LIGHT_RAIN(200, "Thunderstorm", "thunderstorm with light rain", "11d"),
        THUNDERSTORM_RAIN(201, "Thunderstorm", "thunderstorm with rain", "11d"),
        THUNDERSTORM_HEAVY_RAIN(202, "Thunderstorm", "thunderstorm with heavy rain", "11d"),
        LIGHT_THUNDERSTORM(210, "Thunderstorm", "light thunderstorm", "11d"),
        THUNDERSTORM(211, "Thunderstorm", "thunderstorm", "11d"),
        HEAVY_THUNDERSTORM(212, "Thunderstorm", "heavy thunderstorm", "11d"),
        RAGGED_THUNDERSTORM(221, "Thunderstorm", "ragged thunderstorm", "11d"),
        THUNDERSTORM_LIGHT_DRIZZLE(230, "Thunderstorm", "thunderstorm with light drizzle", "11d"),
        THUNDERSTORM_DRIZZLE(231, "Thunderstorm", "thunderstorm with drizzle", "11d"),
        THUNDERSTORM_HEAVY_DRIZZLE(232, "Thunderstorm", "thunderstorm with heavy drizzle", "11d"),

        DRIZZLE_LIGHT(300, "Drizzle", "light intensity drizzle", "09d"),
        DRIZZLE(301, "Drizzle", "drizzle", "09d"),
        DRIZZLE_HEAVY(302, "Drizzle", "heavy intensity drizzle", "09d"),
        DRIZZLE_LIGHT_RAIN(310, "Drizzle", "light intensity drizzle rain", "09d"),
        DRIZZLE_RAIN(311, "Drizzle", "drizzle rain", "09d"),
        DRIZZLE_HEAVY_RAIN(312, "Drizzle", "heavy intensity drizzle rain", "09d"),
        SHOWER_RAIN_DRIZZLE(313, "Drizzle", "shower rain and drizzle", "09d"),
        HEAVY_SHOWER_RAIN_DRIZZLE(314, "Drizzle", "heavy shower rain and drizzle", "09d"),
        SHOWER_DRIZZLE(321, "Drizzle", "shower drizzle", "09d"),

        RAIN_LIGHT(500, "Rain", "light rain", "10d"),
        RAIN_MODERATE(501, "Rain", "moderate rain", "10d"),
        RAIN_HEAVY(502, "Rain", "heavy intensity rain", "10d"),
        RAIN_VERY_HEAVY(503, "Rain", "very heavy rain", "10d"),
        RAIN_EXTREME(504, "Rain", "extreme rain", "10d"),
        FREEZING_RAIN(511, "Rain", "freezing rain", "13d"),
        LIGHT_SHOWER_RAIN(520, "Rain", "light intensity shower rain", "09d"),
        SHOWER_RAIN(521, "Rain", "shower rain", "09d"),
        SHOWER_RAIN_HEAVY(522, "Rain", "heavy intensity shower rain", "09d"),
        RAGGED_SHOWER_RAIN(531, "Rain", "ragged shower rain", "09d"),

        LIGHT_SNOW(600, "Snow", "light snow", "13d"),
        SNOW(601, "Snow", "snow", "13d"),
        HEAVY_SNOW(602, "Snow", "heavy snow", "13d"),
        SLEET(611, "Snow", "sleet", "13d"),
        LIGHT_SHOWER_SLEET(612, "Snow", "light shower sleet", "13d"),
        SHOWER_SLEET(613, "Snow", "shower sleet", "13d"),
        LIGHT_RAIN_AND_SNOW(615, "Snow", "light rain and snow", "13d"),
        RAIN_AND_SNOW(616, "Snow", "rain and snow", "13d"),
        LIGHT_SHOWER_SNOW(620, "Snow", "light shower snow", "13d"),
        SHOWER_SNOW(621, "Snow", "shower snow", "13d"),
        HEAVY_SHOWER_SNOW(622, "Snow", "heavy shower snow", "13d"),

        MIST(701, "Mist", "mist", "50d"),
        SMOKE(711, "Smoke", "smoke", "50d"),
        HAZE(721, "Haze", "haze", "50d"),
        SAND_DUST_WHIRLS(731, "Dust", "sand/dust whirls", "50d"),
        FOG(741, "Fog", "fog", "50d"),
        SAND(751, "Sand", "sand", "50d"),
        DUST(761, "Dust", "dust", "50d"),
        VOLCANIC_ASH(762, "Ash", "volcanic ash", "50d"),
        SQUALLS(771, "Squall", "squalls", "50d"),
        TORNADO(781, "Tornado", "tornado", "50d"),

        CLEAR_SKY(800, "Clear", "clear sky", "01d"),

        FEW_CLOUDS(801, "Clouds", "few clouds: 11-25%", "02d"),
        SCATTERED_CLOUDS(802, "Clouds", "scattered clouds: 25-50%", "03d"),
        BROKEN_CLOUDS(803, "Clouds", "broken clouds: 51-84%", "04d"),
        OVERCAST_CLOUDS(804, "Clouds", "overcast clouds: 85-100%", "04d");

        private final int code;
        private final String main;
        private final String description;
        private final String icon;

    ConditionID(int code, String main, String description, String icon) {
            this.code = code;
            this.main = main;
            this.description = description;
            this.icon = icon;
        }

        public int getCode() { return code; }
        public String getMain() { return main; }
        public String getDescription() { return description; }
        public String getIcon() { return icon; }

    private static final Map<Integer, ConditionID> CODE_MAP = new HashMap<>();

    static {
        for (ConditionID wc : values()) {
            CODE_MAP.put(wc.getCode(), wc);
        }
    }
    public static boolean isValidCode(int code) {
        return CODE_MAP.containsKey(code);
    }
    public static ConditionID fromCode(int code) {
        ConditionID result = CODE_MAP.get(code);
        if (result == null) {
            throw new IllegalArgumentException("Invalid weather code: " + code);
        }
        return result;
    }
}
