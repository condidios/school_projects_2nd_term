import java.util.ArrayList;

public class Characters implements Comparable<Characters> {
    int ap, maxMove, hp, xcoord, ycoord;
    String id;

    public Characters(String id, int x, int y, int ap, int maxMove, int hp) {
        this.ap = ap;
        this.hp = hp;
        this.maxMove = maxMove;
        this.xcoord = x;
        this.ycoord = y;
        this.id = id;
    }

    public void setBoard(ArrayList<ArrayList<String>> list1) {
        list1.get(this.ycoord).set(this.xcoord, this.id);
    }

    public void attack(ArrayList<Characters> list1, int range) {
        ArrayList<Characters> temp = new ArrayList<>();
        for (Characters i : list1) {
            double distance = Math.sqrt(Math.pow(this.xcoord - i.xcoord, 2) + Math.pow(this.ycoord - i.ycoord, 2));
            if (distance <= Math.sqrt(range * range * 2)) {
                if ((this instanceof Calliance && i instanceof Zorde) || (this instanceof Zorde && i instanceof Calliance)) {
                    i.hp -= this.ap;
                    if (i.hp <= 0) {
                        temp.add(i);
                    }
                }
            }
        }
        for (Characters i : temp) {
            list1.remove(i);
        }
    }

    public void fightToDeath(ArrayList<Characters> list1, String id) {
        ArrayList<Characters> temp = new ArrayList<>();
        for (Characters i : list1) {
            if (i.id.equals(id)) {
                i.hp -= this.ap;
                if (i.hp < 0) {
                    i.hp = 0;
                }
                int damage = Math.min(i.hp, this.hp);
                this.hp -= damage;
                i.hp -= damage;
                if (this.hp == 0 && i.hp == 0) {
                    temp.add(this);
                    temp.add(i);
                } else if (this.hp > 0) {
                    temp.add(i);
                } else {
                    temp.add(this);
                }
                break;
            }
        }
        for (Characters i : temp){
            list1.remove(i);
        }
    }

    @Override
    public int compareTo(Characters o) {
        return this.id.compareTo(o.id);
    }
}
