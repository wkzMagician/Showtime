package Showtime.patches;

import Showtime.Showtime;
import com.badlogic.gdx.audio.Music;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.audio.MainMusic;

@SpirePatch(clz = MainMusic.class, method = "getSong")
public class MainMusicPatch {
	//Load custom music for an act if it exists.
	@SpirePostfixPatch
	public static Music Postfix(Music __result, MainMusic __instance, String key) {
		// 返回随机一首音乐
		return MainMusic.newMusic(Showtime.PickRandomMusic());
	}

}