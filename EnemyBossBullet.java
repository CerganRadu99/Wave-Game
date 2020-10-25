package com.myGame.main;

import java.awt.*;
import java.util.Random;

public class EnemyBossBullet extends GameObject {

    private Handler handler;
    Random r = new Random();
    public EnemyBossBullet(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        velX = (r.nextInt(5 -  -5) + -5);
        velY = 5;
        this.handler = handler;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
       // if (y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
       // if (x <= 0 || x >= Game.WIDTH - 32) velX *= -1;
        if(y >= Game.HEIGHT) handler.removeObject(this);

        handler.addObject(new Trail(x, y, ID.Trail, Color.white, 16, 16,0.02f, handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect((int)x, (int)y, 16, 16);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);
    }

}