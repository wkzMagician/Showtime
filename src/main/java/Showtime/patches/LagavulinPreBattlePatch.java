package Showtime.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpireInstrumentPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.monsters.exordium.Lagavulin;
import com.megacrit.cardcrawl.rooms.RestRoom;
import javassist.CannotCompileException;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

@SpirePatch(
		clz = Lagavulin.class,
		method = "usePreBattleAction"

)
public class LagavulinPreBattlePatch {
	@SpireInstrumentPatch
	public static ExprEditor Instrument() {
		return new ExprEditor() {
			@Override
			public void edit(MethodCall m) throws CannotCompileException {
//				if (this.asleep) {
//					CardCrawlGame.music.precacheTempBgm("ELITE");
//					AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new GainBlockAction((AbstractCreature)this, (AbstractCreature)this, 8));
//					AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)this, (AbstractCreature)this, (AbstractPower)new MetallicizePower((AbstractCreature)this, 8), 8));
//				} else {
//					CardCrawlGame.music.unsilenceBGM();
//					AbstractDungeon.scene.fadeOutAmbiance();
//					CardCrawlGame.music.playTempBgmInstantly("ELITE");
//					setMove(DEBUFF_NAME, (byte)1, AbstractMonster.Intent.STRONG_DEBUFF);
//				}
				if (m.getMethodName().equals("playTempBgmInstantly")) {
					m.replace("{ }");
				}
			}
		};
	}
}
