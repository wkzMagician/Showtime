package Showtime.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpireInstrumentPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.audio.MusicMaster;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import javassist.CannotCompileException;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

@SpirePatch(
		clz = AbstractMonster.class,
		method = "onBossVictoryLogic"

)
public class AbstractMonsterDiePatch {
	@SpireInstrumentPatch
	public static ExprEditor Instrument() {
    return new ExprEditor() {
      @Override
      public void edit(MethodCall m) throws CannotCompileException {
        // 不播放背景音乐
        if (m.getMethodName().equals("silenceTempBgmInstantly")) {
          m.replace("{ }");
        }else if(m.getMethodName().equals("silenceBGMInstantly")) {
					m.replace("{ }");
				}
      }
    };
	}
}
