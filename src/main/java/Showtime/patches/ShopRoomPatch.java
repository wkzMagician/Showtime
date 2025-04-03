package Showtime.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpireInstrumentPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.shop.Merchant;
import com.megacrit.cardcrawl.rooms.ShopRoom;
import javassist.CannotCompileException;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

@SpirePatch(
				clz = ShopRoom.class,
				method = "onPlayerEntry"

)
public class ShopRoomPatch {
	@SpireInstrumentPatch
	public static ExprEditor Instrument() {
		return new ExprEditor() {
			@Override
			public void edit(MethodCall m) throws CannotCompileException {
//				public void onPlayerEntry() {
//					if (!AbstractDungeon.id.equals("TheEnding"))
//						playBGM("SHOP");
//					AbstractDungeon.overlayMenu.proceedButton.setLabel(TEXT[0]);
//					setMerchant(new Merchant());
//				}
				// 删除playBGM("SHOP");
				if (m.getMethodName().equals("playBGM")) {
					m.replace("{ }");
				}
			}
		};
	}
}