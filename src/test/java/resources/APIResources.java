package resources;

public enum APIResources {

    AddBook("/Library/Addbook.php");

    private String resource;

    APIResources(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
