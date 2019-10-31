//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package game.player;

import game.Manager;
import game.Player;
import game.Poker;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NimaPlayer implements Player {
    public NimaPlayer() {
    }

    public void onGameStart(Manager manager, int totalPlayer) {
    }

    public int bet(int time, int round, int lastPerson, int moneyOnDesk, int moneyYouNeedToPayLeast, List<Poker> pokers) {
        Collections.sort(pokers);
        if (this.isSameColor(pokers)) {
            return (int)((2.0F + (float)round / 10.0F) * (float)moneyYouNeedToPayLeast) < 3 * moneyOnDesk ? (int)((2.0F + (float)round / 10.0F) * (float)moneyYouNeedToPayLeast) : 3 * moneyOnDesk - 1;
        } else if (!this.isSameColorStraight(pokers) && !this.isSamePoint(pokers)) {
            if (this.isPair(pokers)) {
                return (int)(1.3D * (double)moneyYouNeedToPayLeast) < 3 * moneyOnDesk ? (int)(1.3D * (double)moneyYouNeedToPayLeast) : moneyYouNeedToPayLeast;
            } else if (this.isStraight(pokers)) {
                return (int)(1.7D * (double)moneyYouNeedToPayLeast) < 3 * moneyOnDesk ? (int)(1.7D * (double)moneyYouNeedToPayLeast) : moneyYouNeedToPayLeast;
            } else {
                Iterator var7 = pokers.iterator();

                Poker p;
                do {
                    if (!var7.hasNext()) {
                        return 0;
                    }

                    p = (Poker)var7.next();
                } while(p.getPoint().getNum() < 12);

                return moneyYouNeedToPayLeast;
            }
        } else {
            return (int)((2.0F + (float)round / 10.0F) * (float)moneyYouNeedToPayLeast) < 3 * moneyOnDesk ? (int)((2.0F + (float)round / 10.0F) * (float)moneyYouNeedToPayLeast) : 3 * moneyOnDesk - 1;
        }
    }

    public void onResult(int time, boolean isWin, List<Poker> pokers) {
    }

    public String getName() {
        return "王尼玛";
    }

    public String getStuNum() {
        return "2015211876";
    }

    private boolean isSameColor(List<Poker> pokers) {
        return pokers.get(0).getSuit() == pokers.get(1).getSuit() &&
                pokers.get(1).getSuit() == pokers.get(2).getSuit();
    }

    private boolean isPair(List<Poker> pokers) {
        return pokers.get(0).getPoint().getNum() == pokers.get(1).getPoint().getNum()
                || pokers.get(1).getPoint().getNum() == pokers.get(2).getPoint().getNum()
                || pokers.get(0).getPoint().getNum() == pokers.get(2).getPoint().getNum();
    }

    private boolean isStraight(List<Poker> pokers) {
        Collections.sort(pokers);
        return Math.abs(pokers.get(0).getPoint().getNum() - pokers.get(1).getPoint().getNum()) == 1
                && Math.abs(pokers.get(1).getPoint().getNum() - pokers.get(2).getPoint().getNum()) == 1;

    }

    private boolean isSameColorStraight(List<Poker> handCards) {
        return isSameColor(handCards) && isStraight(handCards);
    }

    private boolean isSamePoint(List<Poker> handCards) {
        return handCards.get(0).getPoint() == handCards.get(1).getPoint()
                && handCards.get(2).getPoint() == handCards.get(1).getPoint();

    }
}
