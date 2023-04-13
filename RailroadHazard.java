public class RailroadHazard extends RuntimeException {
    public RailroadHazard(Trainset t) {
        super("\n\tThis trainset exceeded speed of 200km\\h \n" + t);
    }
}
