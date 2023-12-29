package yc.ahmed.myrh.Enums;

public enum OffresStatus {
    PENDING("PENDING"),
    ACCEPTED("ACCEPTED"),
    REFUSED("REFUSED");

    private String status;

    OffresStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
