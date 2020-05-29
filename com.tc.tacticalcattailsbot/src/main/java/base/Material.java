package base;

import com.sun.javafx.binding.StringFormatter;

public class Material {

    private String name;
    private String wikiUrl;

    public Material(String name, String wikiUrl) {
        this.name = name;
        this.wikiUrl = wikiUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWikiUrl() {
        return wikiUrl;
    }

    public void setWikiUrl(String wikiUrl) {
        this.wikiUrl = wikiUrl;
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, wikiUrl);
    }
}
