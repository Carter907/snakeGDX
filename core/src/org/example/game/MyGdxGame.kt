package org.example.game

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.utils.viewport.ExtendViewport
import com.badlogic.gdx.utils.viewport.FillViewport
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.ScreenViewport
import com.badlogic.gdx.utils.viewport.StretchViewport

class MyGdxGame: ApplicationAdapter() {

    private lateinit var renderer: ShapeRenderer;
    private lateinit var viewport: ExtendViewport;
    private val playerProcessor: PlayerProcessor = PlayerProcessor();

    override fun create() {
        Gdx.input.inputProcessor = playerProcessor
        renderer = ShapeRenderer();

        val camera = OrthographicCamera();
        viewport = ExtendViewport(World.WIDTH, World.HEIGHT, camera);
        camera.position.set(25f, 25f, 0f)

    }


    override fun render() {
        Gdx.gl.glClearColor(.1f,.1f,.1f,0f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT.or(
            GL20.GL_DEPTH_BUFFER_BIT
        ));
        println("player x ${Player.x}")
        println("player y ${Player.y}")
        playerProcessor.update();

        viewport.apply();

        renderer.projectionMatrix = viewport.camera.combined
        renderer.begin(ShapeRenderer.ShapeType.Filled)
        renderer.rect(Player.x,Player.y, Player.SIZE, Player.SIZE)
        renderer.end();

    }
    override fun resize(width: Int, height: Int) {
//        val ASPECT_RATIO = (width/height*1f).toInt();
//        viewport.worldWidth = World.HEIGHT * ASPECT_RATIO;
//        viewport.worldHeight = World.WIDTH / ASPECT_RATIO;

        viewport.update(width, height)

    }
    override fun dispose() {
        renderer.dispose();
    }
}