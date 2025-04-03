package Showtime.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpireInstrumentPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.rooms.RestRoom;
import javassist.CannotCompileException;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

@SpirePatch(
		clz = AbstractMonster.class,
		method = "playBossStinger"

)
public class AbstractMonsterPatch {
	@SpireInstrumentPatch
	public static ExprEditor Instrument() {
    return new ExprEditor() {
      @Override
      public void edit(MethodCall m) throws CannotCompileException {
        //				public static void playBossStinger() {
        //					CardCrawlGame.sound.play("BOSS_VICTORY_STINGER");
        //					if (AbstractDungeon.id.equals("TheEnding")) {
        //						CardCrawlGame.music.playTempBgmInstantly("STS_EndingStinger_v1.ogg", false);
        //					} else {
        //						switch (MathUtils.random(0, 3)) {
        //							case 0:
        //								CardCrawlGame.music.playTempBgmInstantly("STS_BossVictoryStinger_1_v3_MUSIC.ogg",
        // false);
        //								return;
        //							case 1:
        //								CardCrawlGame.music.playTempBgmInstantly("STS_BossVictoryStinger_2_v3_MUSIC.ogg",
        // false);
        //								return;
        //							case 2:
        //								CardCrawlGame.music.playTempBgmInstantly("STS_BossVictoryStinger_3_v3_MUSIC.ogg",
        // false);
        //								return;
        //							case 3:
        //								CardCrawlGame.music.playTempBgmInstantly("STS_BossVictoryStinger_4_v3_MUSIC.ogg",
        // false);
        //								return;
        //						}
        //						logger.info("[ERROR] Attempted to play boss stinger but failed.");
        //					}
        //				}
        // 不播放背景音乐
        if (m.getMethodName().equals("playTempBgmInstantly")) {
          m.replace("{ }");
        }
      }
    };
	}
}
