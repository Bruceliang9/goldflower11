//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package game.player;

import game.Manager;
import game.Player;
import game.Poker;
import java.util.List;

public class FoldPlayer implements Player {
    public FoldPlayer() {
    }

    public String getName() {
        return "弃牌狗";
    }

    public String getStuNum() {
        return "2015211876";
    }

    public void onGameStart(Manager manager, int totalPlayer) {
    }

    public int bet(int time, int round, int lastPerson, int moneyOnDesk, int moneyYouNeedToPayLeast, List<Poker> pokers) {
        return 0;
    }

    public void onResult(int time, boolean isWin, List<Poker> pokers) {
    }
}
