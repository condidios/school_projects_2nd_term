import java.util.ArrayList;

public class Ork extends Zorde{
    int healPoint;
    public Ork(String id, int x, int y, int ap, int maxMove, int hp) {
        super(id, x, y, ap, maxMove, hp);
        this.healPoint = Constants.orkHealPoints;
    }
    public void heal(ArrayList<Characters> list1, int range){
        for (Characters i : list1) {
            double distance = Math.sqrt(Math.pow(this.xcoord - i.xcoord, 2) + Math.pow(this.ycoord - i.ycoord, 2));
            if (distance <= Math.sqrt(range * range * 2)) {
                if (i instanceof Zorde){
                    i.hp += this.healPoint;
                    if (i instanceof Goblin && i.hp > 80){
                        i.hp = 80;
                    }
                    else if (i instanceof Troll && i.hp > 150){
                        i.hp = 150;
                    }
                    else if (i instanceof Ork && i.hp > 200){
                        i.hp = 200;
                    }
                }
            }
        }

    }
}
