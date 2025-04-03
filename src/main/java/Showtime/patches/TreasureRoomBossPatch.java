package Showtime.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpireInstrumentPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.audio.MusicMaster;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.rooms.TreasureRoomBoss;
import javassist.CannotCompileException;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

@SpirePatch(
		clz = TreasureRoomBoss.class,
		method = "onPlayerEntry"
)
public class TreasureRoomBossPatch {
	@SpireInstrumentPatch
	public static ExprEditor Instrument() {
    return new ExprEditor() {
      @Override
      public void edit(MethodCall m) throws CannotCompileException {
        if (m.getMethodName().equals("silenceBGM")) {
          m.replace("{ }");
        } else if (m.getMethodName().equals("playBGM")) {
					m.replace("{ }");
				}
      }
    };
	}

}

