package spring.fi.springbootingweb.models;

public enum Position {
    MANAGER, HOUSEKEEPING, FRONT_DESK, EXECUTIVE;

    public String toString() {
        switch (this) {
            case HOUSEKEEPING:
                return "Housekeeping";
            case FRONT_DESK:
                return "Front Desk";
            case EXECUTIVE:
                return "Executive";
            case MANAGER:
                return "Manager";
        }
        return "";
    }
}