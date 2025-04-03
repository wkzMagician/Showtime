package Showtime.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpireInstrumentPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.rooms.RestRoom;
import com.megacrit.cardcrawl.rooms.ShopRoom;
import javassist.CannotCompileException;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

@SpirePatch(
		clz = RestRoom.class,
		method = "onPlayerEntry"

)
public class RestRoomPatch {
	@SpireInstrumentPatch
	public static ExprEditor Instrument() {
		return new ExprEditor() {
			@Override
			public void edit(MethodCall m) throws CannotCompileException {
//				if (!AbstractDungeon.id.equals("TheEnding"))
//					CardCrawlGame.music.silenceBGM();
//				this.fireSoundId = CardCrawlGame.sound.playAndLoop("REST_FIRE_WET");
//				lastFireSoundId = this.fireSoundId;
//				this.campfireUI = new CampfireUI();
//				for (AbstractRelic r : AbstractDungeon.player.relics)
//					r.onEnterRestRoom();
				// 不暂停背景音乐
				// 删除CardCrawlGame.music.silenceBGM();
				if (m.getMethodName().equals("silenceBGM")) {
					m.replace("{ }");
				}
			}
		};
	}
}