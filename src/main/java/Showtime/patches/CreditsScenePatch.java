package Showtime.patches;

import Showtime.Showtime;
import com.badlogic.gdx.audio.Music;
import com.evacipated.cardcrawl.modthespire.lib.SpireInstrumentPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.audio.TempMusic;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.credits.CreditsScreen;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import javassist.CannotCompileException;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

@SpirePatch(
		clz = CreditsScreen.class,
		method = "open"

)
public class CreditsScenePatch {
	@SpireInstrumentPatch
	public static ExprEditor Instrument() {
    return new ExprEditor() {
      @Override
      public void edit(MethodCall m) throws CannotCompileException {
        // 背景音乐
        if (m.getMethodName().equals("playTempBgmInstantly")) {
          m.replace("{ }");
        }
      }
    };
	}

  @SpirePostfixPatch
  public static void Postfix(CreditsScreen __instance) {
		// 播放随机音乐
		String key = Showtime.PickRandomMusic();
		CardCrawlGame.music.playTempBgmInstantly(key, true);
	}
}
