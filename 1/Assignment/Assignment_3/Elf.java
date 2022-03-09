public class Elf extends Calliance{
    int rangedAp;

    public Elf(String id, int x, int y, int ap, int maxMove, int hp) {
        super(id, x, y, ap, maxMove, hp);
        this.rangedAp = Constants.elfRangedAP;
    }
}
