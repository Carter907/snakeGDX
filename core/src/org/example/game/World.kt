package org.example.game

import com.badlogic.gdx.Gdx


object World{

    const val WIDTH = 50f;
    const val HEIGHT = 50f;

    fun aspectRatio(): Float = Gdx.graphics.width*1f / Gdx.graphics.height;
}
