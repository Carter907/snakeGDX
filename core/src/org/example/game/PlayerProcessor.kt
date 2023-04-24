package org.example.game

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.InputAdapter

class PlayerProcessor : InputAdapter() {

    private val keysDown: HashSet<Int> = HashSet()

    private fun checkKeys() {
        keysDown.forEach {keyCode ->
            when (keyCode) {
                Input.Keys.W -> {
                    if (Player.y < World.WIDTH-Player.SIZE)
                        Player.y += Player.SPEED * Gdx.graphics.deltaTime;
                }
                Input.Keys.S -> {
                    if (Player.y > 0)
                    Player.y -= Player.SPEED * Gdx.graphics.deltaTime;
                }
                Input.Keys.D -> {
                    if (Player.x < World.WIDTH-Player.SIZE)
                    Player.x += Player.SPEED * Gdx.graphics.deltaTime;
                }
                Input.Keys.A -> {
                    if (Player.x > 0)
                    Player.x -= Player.SPEED * Gdx.graphics.deltaTime;
                }
            }

        };
    }
    fun update() {
        checkKeys()
    }

    override fun keyDown(keyCode: Int): Boolean {
        keysDown.clear();
        keysDown.add(keyCode)

        return true;
    }



}