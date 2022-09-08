package co.develhope.filter2.entities;

public class Month {

    private int monthNumber;
    private  String englishName;
    private String italianName;
    private String germanName;

    public Month() {
    }

    public Month(String englishName, String italianName, String germanName) {
        this.englishName = englishName;
        this.italianName = italianName;
        this.germanName = germanName;
    }

    public Month(int monthNumber, String englishName, String italianName, String germanName) {
        this.monthNumber = monthNumber;
        this.englishName = englishName;
        this.italianName = italianName;
        this.germanName = germanName;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public String getEnglishName() {
        return englishName;
    }

    public String getItalianName() {
        return italianName;
    }

    public String getGermanName() {
        return germanName;
    }

    @Override
    public String toString() {
        return "Month{" +
                "englishName='" + englishName + '\'' +
                ", italianName='" + italianName + '\'' +
                ", germanName='" + germanName + '\'' +
                '}';
    }
}
