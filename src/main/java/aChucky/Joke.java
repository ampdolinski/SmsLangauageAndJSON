package aChucky;

public class Joke {

    String category = null;
    String icon_url;
    String id;
    String url;
    String value;


    public Joke(String category, String icon_url, String id, String url, String value) {
        this.category = category;
        this.icon_url = icon_url;
        this.id = id;
        this.url = url;
        this.value = value;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

//    {"category":null,
//    "icon_url":"https:\/\/assets.chucknorris.host\/img\/avatar\/chuck-norris.png",
//    "id":"jpAgMNVtSDCLxR-tWSxxGA",
//    "url":"https:\/\/api.chucknorris.io\/jokes\/jpAgMNVtSDCLxR-tWSxxGA",
//    "value":"Chuck Norris isn\u0027t actually invincible. HE DOESN\u0027T NEED TO BE."}

}
