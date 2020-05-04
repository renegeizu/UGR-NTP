package classes;

public enum Type {
    FUNCTIONAL(true),
    IMPERATIVE(false);

    private boolean state;

    Type(boolean state) {
        this.state = state;
    }

    public boolean getState() {
        return this.state;
    }

}
