import java.util.Comparator;

public class CoordinateComparator implements Comparator<Coordinate> {
    @Override
    public int compare(Coordinate o1, Coordinate o2) {
        return o1.getCoordinate().compareTo(o2.getCoordinate());
    }

}
