package Showtime.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpireInstrumentPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.scenes.TheBeyondScene;
import com.megacrit.cardcrawl.scenes.TheBottomScene;
import javassist.CannotCompileException;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

@SpirePatch(
		clz = TheBottomScene.class,
		method = "nextRoom"
)
public class TheBottomScenePatch {
	@SpireInstrumentPatch
	public static ExprEditor Instrument() {
		return new ExprEditor() {
			@Override
			public void edit(MethodCall m) throws CannotCompileException {
				if(m.getMethodName().equals("silenceBGM")) {
					m.replace("{ }");
				}
			}
		};
	}

}
