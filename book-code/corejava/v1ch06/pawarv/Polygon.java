package pawarv;

class Polygon {

    private int sides;

    Polygon(int sides) {
        this.sides = sides;
    }

    public int getSides() {
        return sides;
    }

    public int compareToPolygon(Polygon p) {
        return this.sides - p.getSides();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Polygon with " + sides + " sides";
    }

    public void draw(Enhancer e) {
        e.enhance(toString());
    }

    public void check(Checker c) {

    }

}
