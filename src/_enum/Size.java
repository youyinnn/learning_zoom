package _enum;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/2
 */
public enum Size {
    SMALL("S"),MEDIUM("M"),LARGE("L"),EXTRA_LARGE("XL");

    private String abbreviation;

    private Size(String abbreviation){ this.abbreviation = abbreviation; }

    public String getAbbreviation(){ return abbreviation; }
}
