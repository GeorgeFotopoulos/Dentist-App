public class Services {
    private String date, service, comments;

    public Services(String date, String service, String comments) {
        this.date = date;
        this.service = service;
        this.comments = comments;
    }

    public String toString() {
        if (!comments.equals("")) {
            return "Date: " + date + ", Service: " + service + ", Comments: " + comments;
        } else {
            return "Date: " + date + ", Service: " + service;
        }
    }
}
