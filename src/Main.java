
public class Main {

    public static void main(String[] args) {
        Ring<Integer> ring = new CircularArrayRing<Integer>();

        for(int i=0; i<20; ++i) {
            ring.add(i);
        }


        System.out.println(ring.get(11));
    }
}
