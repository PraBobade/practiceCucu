package _Section11_Deserialization.POJO;


import java.util.List;

public class ChildCourse {
    private List<BwebAutomation> webAutomation;
    private List<BApi> api;
    private List<BMobile> mobile;

    public List<BwebAutomation> getWebAutomation() {
        return webAutomation;}
    public void setWebAutomation(List<BwebAutomation> webAutomation) {
        this.webAutomation = webAutomation;
    }

    public List<BApi> getApi() {
        return api;}
    public void setApi(List<BApi> api) {
        this.api = api;
    }

    public List<BMobile> getMobile() {
        return mobile;}
    public void setMobile(List<BMobile> mobile) {
        this.mobile = mobile;
    }

}
