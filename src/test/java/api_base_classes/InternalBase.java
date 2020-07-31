package api_base_classes;

public class InternalBase  extends TestBase {

    public String serviceURL;
    String apiURL;
    public String url;

    public InternalBase(){
        url = setup();
    }

    public String setup() {
        serviceURL = prop.getProperty("QA_DEMO_URL");
        apiURL = prop.getProperty("DEMO_serviceURL");
        return serviceURL + apiURL;
    }
}
