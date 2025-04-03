package Showtime.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpireInstrumentPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.scenes.TheBottomScene;
import com.megacrit.cardcrawl.scenes.TheCityScene;
import javassist.CannotCompileException;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

@SpirePatch(
		clz = TheCityScene.class,
		method = "nextRoom"
)
public class TheCityScenePatch {
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
