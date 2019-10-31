//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package game;

import java.util.List;

public interface Player {
    String getName();

    String getStuNum();

    default String getInformation() {
        return this.getName() + this.getStuNum();
    }

    void onGameStart(Manager var1, int var2);

    int bet(int var1, int var2, int var3, int var4, int var5, List<Poker> var6);

    void onResult(int var1, boolean var2, List<Poker> var3);
}
