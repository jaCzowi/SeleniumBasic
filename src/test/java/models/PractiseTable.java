package models;

import java.util.LinkedList;
import java.util.List;

/**
 * Class model that presents tables used in tests {@link selenium_tests.PractiseFormTest }
 */
public class PractiseTable {

    private List<String> structureList = new LinkedList<>();
    private List<String> countryList = new LinkedList<>();
    private List<String> cityList = new LinkedList<>();
    private List<Integer> builtYearList = new LinkedList<>();
    private List<Integer> rankList = new LinkedList<>();
    private List<String> heightList = new LinkedList<>();

    public List<String> getHeightList() {
        return heightList;
    }

    public PractiseTable() {
    }

    public List<String> getStructureList() {
        return structureList;
    }

    public List<String> getCountryList() {
        return countryList;
    }

    public List<String> getCityList() {
        return cityList;
    }

    public List<Integer> getYearList() {
        return builtYearList;
    }

    public List<Integer> getRankList() {
        return rankList;
    }

    public void setToCityList(String eachCellText) {
        this.cityList.add(eachCellText);
    }

    public void setCountryToList(String eachCountry) {
        this.countryList.add(eachCountry);
    }

    public void setHeightToList(String eachHeight) {
        this.heightList.add(eachHeight);
    }

    public void setDateBuilt(String eachHeight) {
        this.builtYearList.add(Integer.valueOf(eachHeight));
    }

    public void setRank(String eachRank) {
        this.rankList.add(Integer.valueOf(eachRank));
    }

    public void setStructureToList(String eachStructure) {
        this.structureList.add(eachStructure);
    }

    public void printTable() {
        System.out.println("Structure    " + "|  Country   " + "|  City   " + "|  Height " + "|  Built  " + "| Rank ");
        for (int i = 0; i < 4; i++) {
            System.out.print(structureList.get(i) + " | ");
            System.out.print(countryList.get(i) + " | ");
            System.out.print(cityList.get(i) + " | ");
            System.out.print(heightList.get(i) + " | ");
            System.out.print(builtYearList.get(i) + " | ");
            System.out.print(rankList.get(i) + " | ");
            System.out.println();
        }
    }
}
