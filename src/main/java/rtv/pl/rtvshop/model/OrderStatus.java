package rtv.pl.rtvshop.model;

public enum OrderStatus {
    NEW("Nowe"),
    IN_PROGRESS("W trakcie realizacji"),
    DELIVERED("Dostarczone"),;

    private final String status;

    OrderStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}
