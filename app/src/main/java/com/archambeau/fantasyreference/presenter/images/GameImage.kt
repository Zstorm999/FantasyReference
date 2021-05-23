package com.archambeau.fantasyreference.presenter.images

import com.archambeau.fantasyreference.R

abstract class GameImage (val next: GameImage?){
    protected abstract val gameName : String
    protected abstract val imagePath : Int


    fun findImagePath(game : String) : Int{

        if(game.contains(Regex(gameName))) return imagePath

        return next?.findImagePath(game) ?: -1
    }

    class TLOZ(next: GameImage?) : GameImage(next){

        override val gameName: String = "^The Legend of Zelda$"
        override val imagePath: Int = R.drawable.tloz

    }

    class Zelda2(next: GameImage?) : GameImage(next){

        override val gameName: String = "The Adventure of Link"
        override val imagePath: Int = R.drawable.zelda2

    }

    class ALTTP(next: GameImage?) : GameImage(next){

        override val gameName: String = "A Link to the Past"
        override val imagePath: Int = R.drawable.alttp

    }

    class LsA(next: GameImage?) : GameImage(next){

        override val gameName: String = "Link's Awakening"
        override val imagePath: Int = R.drawable.lsa

    }

    class OOT(next: GameImage?) : GameImage(next){

        override val gameName: String = "Ocarina of Time"
        override val imagePath: Int = R.drawable.oot

    }

    class MsM(next: GameImage?) : GameImage(next){

        override val gameName: String = "Majora's Mask"
        override val imagePath: Int = R.drawable.msm

    }

    class OOA(next: GameImage?) : GameImage(next){

        override val gameName: String = "Oracle of Ages"
        override val imagePath: Int = R.drawable.ooa

    }

    class OOS(next: GameImage?) : GameImage(next){

        override val gameName: String = "Oracle of Seasons"
        override val imagePath: Int = R.drawable.oos

    }

    class TWW(next: GameImage?) : GameImage(next){

        override val gameName: String = "The Wind Waker"
        override val imagePath: Int = R.drawable.tww

    }

    class TMC(next: GameImage?) : GameImage(next){

        override val gameName: String = "The Minish Cap"
        override val imagePath: Int = R.drawable.tmc

    }

    class FSA(next: GameImage?) : GameImage(next){

        override val gameName: String = "Four Swords"
        override val imagePath: Int = R.drawable.fsa

    }

    class TP(next: GameImage?) : GameImage(next){

        override val gameName: String = "Twilight Princess"
        override val imagePath: Int = R.drawable.tp

    }

    class PH(next: GameImage?) : GameImage(next){

        override val gameName: String = "Phantom Hourglass"
        override val imagePath: Int = R.drawable.ph

    }

    class ST(next: GameImage?) : GameImage(next){

        override val gameName: String = "Spirit Tracks"
        override val imagePath: Int = R.drawable.st

    }

    class SS(next: GameImage?) : GameImage(next){

        override val gameName: String = "Skyward Sword"
        override val imagePath: Int = R.drawable.ss

    }

    class ALBW(next: GameImage?) : GameImage(next){

        override val gameName: String = "A Link Between Worlds"
        override val imagePath: Int = R.drawable.albw

    }

    class TFH(next: GameImage?) : GameImage(next){

        override val gameName: String = "Tri Force Heroes"
        override val imagePath: Int = R.drawable.tfh

    }

    class BOTW(next: GameImage?) : GameImage(next){

        override val gameName: String = "Breath of the Wild"
        override val imagePath: Int = R.drawable.botw

    }



}

