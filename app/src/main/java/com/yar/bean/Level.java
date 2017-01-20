package com.yar.bean;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.yar.main.MainActivity;
import com.yar.util.LoadUtil;
import com.yar.util.MarioUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yar on 16-1-11.
 */
public class Level {

    public int level;

    private Mario mario;

    public MarioMap[] map;


    public List<Tile> b_tile = new ArrayList<Tile>();


    public List <Tile>q_tile = new ArrayList<Tile>();

    ArrayList <Ladder>ladder = new ArrayList <Ladder>();

    public ArrayList <Blast>blast = new ArrayList <Blast>();

    private ArrayList <Coin>  coins = new ArrayList <Coin>();


    public ArrayList <Enemy>enemy = new ArrayList<Enemy>();


    public Level(int level,Mario mario) {
        this.level = level;
        this.mario=mario;
        this.map =new MarioMap[2];
        switch (level){
            case 1:

                b_tile.addAll(MarioUtil.creatTile(MarioUtil.ReadMap(mario.context, "mapdat/map_b_1.dat"), 0, mario));
                q_tile.addAll(MarioUtil.creatTile(MarioUtil.ReadMap(mario.context, "mapdat/map_q_1.dat"), 1, mario));

                this.map[0]=new MarioMap(0,0,LoadUtil.map.get(0),mario);
                this.map[1]=new MarioMap(MainActivity.ScreenWidth,0,LoadUtil.map.get(0),mario);

                this.coins.add(new Coin(29*16, 9*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(30*16, 9*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(31*16, 9*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(32*16, 9*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(62*16, 8*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(63*16, 8*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(64*16, 8*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(65*16, 8*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(101*16, 3*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(113*16, 7*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(114*16, 7*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(115*16, 7*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(116*16, 7*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(158*16, 8*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(159*16, 8*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(160*16, 8*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(249*16, 9*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(250*16, 9*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(251*16, 9*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(252*16, 9*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(253*16, 9*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(261*16, 9*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(262*16, 9*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(263*16, 9*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(264*16, 9*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(265*16, 9*16, LoadUtil.coins.get(0),2,mario));


                this.enemy.add(new Triangle(29*16 ,  13*16, LoadUtil.enemy.get(0),this.mario));
                this.enemy.add(new Tortoise(46*16 ,  13*16-8, LoadUtil.enemy.get(7),this.mario));
                this.enemy.add(new Piranha (59*16+8, 13*16, LoadUtil.enemy.get(10),this.mario));
                this.enemy.add(new Piranha (104*16+8,11*16, LoadUtil.enemy.get(10),this.mario));
                this.enemy.add(new Thorn   (96*16 ,  8*16,  LoadUtil.enemy.get(3),this.mario));
                this.enemy.add(new Triangle(115*16 , 11*16, LoadUtil.enemy.get(0),this.mario));
                this.enemy.add(new Triangle(147*16 , 13*16, LoadUtil.enemy.get(0),this.mario));
                this.enemy.add(new Tortoise(158*16 , 13*16-8, LoadUtil.enemy.get(7),this.mario));
                this.enemy.add(new Thorn   (167*16 ,  8*16, LoadUtil.enemy.get(3),this.mario));
                this.enemy.add(new Tortoise(221*16 , 13*16-8, LoadUtil.enemy.get(7),this.mario));
                this.enemy.add(new Piranha (240*16+8,12*16, LoadUtil.enemy.get(10),this.mario));
                this.enemy.add(new Piranha (272*16+8,13*16, LoadUtil.enemy.get(10),this.mario));


                break;

            case 2:

                b_tile.addAll(MarioUtil.creatTile(MarioUtil.ReadMap(mario.context, "mapdat/map_b_2.dat"), 0, mario));
                q_tile.addAll(MarioUtil.creatTile(MarioUtil.ReadMap(mario.context, "mapdat/map_q_2.dat"), 1, mario));

                this.map[0]=new MarioMap(0,0,LoadUtil.map.get(1),mario);
                this.map[1]=new MarioMap(MainActivity.ScreenWidth,0,LoadUtil.map.get(1),mario);

                this.ladder.add(new Ladder(84*16,0, LoadUtil.ladder,2,this.mario));
                this.ladder.add(new Ladder(84*16,MainActivity.ScreenHeight/2 + 5, LoadUtil.ladder,2,this.mario));
                this.ladder.add(new Ladder(84*16,MainActivity.ScreenHeight-10,  LoadUtil.ladder,2,this.mario));

                this.ladder.add(new Ladder(93*16,0,  LoadUtil.ladder,1,this.mario));
                this.ladder.add(new Ladder(93*16,MainActivity.ScreenHeight/2 + 5,  LoadUtil.ladder,1,this.mario));
                this.ladder.add(new Ladder(93 * 16, MainActivity.ScreenHeight - 10, LoadUtil.ladder, 1,this.mario));

                this.ladder.add(new Ladder(242 * 16, 0, LoadUtil.ladder, 2,this.mario));
                this.ladder.add(new Ladder(242*16,MainActivity.ScreenHeight/2 + 5,  LoadUtil.ladder,2,this.mario));
                this.ladder.add(new Ladder(242*16,MainActivity.ScreenHeight-10, LoadUtil.ladder,2,this.mario));


                this.coins.add(new Coin(53*16, 9*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(54*16, 9*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(55*16, 9*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(56*16, 9*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(57*16, 9*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(58*16, 9*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(59*16, 9*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(60*16, 9*16, LoadUtil.coins.get(0),2,mario));

                this.coins.add(new Coin(102*16, 2*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(103*16, 2*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(104*16, 2*16, LoadUtil.coins.get(0),2,mario));

                this.coins.add(new Coin(114*16, 7*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(115*16, 7*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(116*16, 7*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(117*16, 7*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(118*16, 7*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(119*16, 7*16, LoadUtil.coins.get(0),2,mario));

                this.coins.add(new Coin(123*16, 2*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(124*16, 2*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(125*16, 2*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(126*16, 2*16, LoadUtil.coins.get(0),2,mario));

                this.coins.add(new Coin(214*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(215*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(216*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(217*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(218*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(219*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(220*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(221*16, 10*16, LoadUtil.coins.get(0),2,mario));

                this.coins.add(new Coin(257*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(258*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(259*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(260*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(261*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(262*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(263*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(264*16, 10*16, LoadUtil.coins.get(0),2,mario));


                this.enemy.add(new Triangle(25*16 ,  13*16, LoadUtil.enemy.get(0),this.mario));
                this.enemy.add(new Tortoise(60*16 ,  13*16-8, LoadUtil.enemy.get(7),this.mario));
                this.enemy.add(new Piranha (70*16+8, 13*16, LoadUtil.enemy.get(10),this.mario));
                this.enemy.add(new Piranha (116*16+8,12*16, LoadUtil.enemy.get(10),this.mario));
                this.enemy.add(new Thorn   (130*16 , 13*16,  LoadUtil.enemy.get(3),this.mario));
                this.enemy.add(new Triangle(146*16 , 13*16, LoadUtil.enemy.get(0),this.mario));
                this.enemy.add(new Triangle(146*16 , 10*16, LoadUtil.enemy.get(7),this.mario));
                this.enemy.add(new Thorn   (160*16 ,  13*16, LoadUtil.enemy.get(3),this.mario));
                this.enemy.add(new Tortoise(170*16 , 13*16-8, LoadUtil.enemy.get(7),this.mario));
                this.enemy.add(new Piranha (175*16+8, 12*16, LoadUtil.enemy.get(10),this.mario));
                this.enemy.add(new Piranha (185*16+8, 12*16, LoadUtil.enemy.get(10),this.mario));
                this.enemy.add(new Piranha (195*16+8, 12*16, LoadUtil.enemy.get(10),this.mario));


                break;


            case 3:

                b_tile.addAll(MarioUtil.creatTile(MarioUtil.ReadMap(mario.context, "mapdat/map_b_3.dat"), 0, mario));
                q_tile.addAll(MarioUtil.creatTile(MarioUtil.ReadMap(mario.context, "mapdat/map_q_3.dat"), 1, mario));

                this.map[0]=new MarioMap(0,0,LoadUtil.map.get(2),mario);
                this.map[1]=new MarioMap(MainActivity.ScreenWidth,0,LoadUtil.map.get(2),mario);


                this.coins.add(new Coin(26*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(27 * 16, 10 * 16, LoadUtil.coins.get(0), 2, mario));
                this.coins.add(new Coin(28 * 16, 10 * 16, LoadUtil.coins.get(0), 2, mario));
                this.coins.add(new Coin(88*16, 8*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(89*16, 8*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(90*16, 8*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(139*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(140*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(141*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(142*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(143*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(144*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(145*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(146*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(147*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(163*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(164*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(165*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(166*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(167*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(168*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(169*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(170*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(171*16, 10*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(206*16, 8*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(207*16, 8*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(208*16, 8*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(209*16, 8*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(210*16, 8*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(211*16, 8*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(212*16, 8*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(213*16, 8*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(235*16, 8*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(236*16, 8*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(237*16, 8*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(238*16, 8*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(239*16, 8*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(240*16, 8*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(286*16, 7*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(288*16, 7*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(292*16, 5*16, LoadUtil.coins.get(0),2,mario));
                this.coins.add(new Coin(293*16, 5*16, LoadUtil.coins.get(0),2,mario));



                this.enemy.add(new SmokeMonster(MainActivity.ScreenWidth ,  4*16, LoadUtil.enemy.get(13),this.mario));
                this.enemy.add(new Piranha (85*16+8, 13*16, LoadUtil.enemy.get(10),this.mario));
                this.enemy.add(new Piranha (174*16+8,12*16, LoadUtil.enemy.get(10),this.mario));
                this.enemy.add(new Piranha (203*16+8,13*16, LoadUtil.enemy.get(10),this.mario));
                this.enemy.add(new Piranha (286*16+8,12*16, LoadUtil.enemy.get(10),this.mario));
                this.enemy.add(new Piranha (292*16+8, 10*16,LoadUtil.enemy.get(10),this.mario));

                break;

            default:
                break;
        }



    }





    public void draw(Canvas canvas){


        String status=this.mario.status;

        if(mario.x<0){
            mario.onhitRight=true;
        }

        float xSpeed=this.mario.xSpeed;


        for(int i=0; i<this.map.length; i++)
        {
            MarioMap m =this.map[i];
            if(m.x<-MainActivity.ScreenWidth+1){
                m.x+=2*MainActivity.ScreenWidth;
            }
            m.draw(canvas);
        }


        for(int i=0; i<this.enemy.size(); i++)
        {
            Enemy e = this.enemy.get(i);
            if(e.hp > 0)
            {
                e.Move();
                e.Logic(this);
                e.draw(canvas);
                e.ChangeImage();
            }
            else
            {
                this.enemy.remove(i);
            }
        }



        for(int i=0; i<this.b_tile.size(); i++)
        {
            Tile tile = this.b_tile.get(i);

            if(tile.x >= -16 && tile.x <= MainActivity.ScreenWidth)
            {
                tile.draw(canvas);
                tile.ChangeImage();

                if(tile.getType()==77||tile.getType()==93) {
                    if (tile.isCollsionWithRect(mario, mario.getRect())) {
                        this.mario.isWin = true;
                    }
                }else if(tile.getType() == 133 || tile.getType() == 134 || tile.getType() == 135 ){
                    Rect rect=  mario.getRect();
                    float w1 = (float)(rect.right - rect.left);
                    float h1 = (float)(rect.bottom - rect.top);
                    int flag=tile.MoreRectangle_CollisionWithSpriteXY(mario,rect);

                    switch (flag){
                        case 1:
                            mario.x=tile.x-w1- rect.left;
                            mario.onhitLeft=true;
                            break;
                        case 2:
                            mario.y=tile.y-h1-rect.top;
                            mario.onland=true;
                            mario.onLadderland=false;
                            break;
                        case 3:
                            mario.onhitRight=true;
                            mario.x=tile.x+tile.image.getWidth();
                            break;
                        case 4:

                            break;
                        default:
                    }
                }
            }


        }





       for(int i=0; i<this.q_tile.size(); i++)
        {
            Tile tile = this.q_tile.get(i);

            if(tile.x >= -16 && tile.x <= MainActivity.ScreenWidth)
            {
                    tile.draw(canvas);
                   if(tile.getType()!=15){
                       tile.ChangeImage();
                       tile.Jump();
                   }else{
                       tile.Fril();
                   }


            }


            Rect rect=  mario.getRect();
            float w1 = (float)(rect.right - rect.left);
            float h1 = (float)(rect.bottom - rect.top);
            int flag=tile.MoreRectangle_CollisionWithSpriteXY(mario,rect);

            switch (flag){
                case 1:
                    mario.x=tile.x-w1- rect.left;
                    mario.onhitLeft=true;
                    break;
                case 2:
                    mario.y=tile.y-h1-rect.top;
                    mario.onland=true;
                    mario.onLadderland=false;
                    break;
                case 3:
                     mario.onhitRight=true;
                     mario.x=tile.x+tile.image.getWidth();
                    break;
                case 4:
                    mario.onhitTop=true;
                    mario.y=tile.y+mario.image.getHeight();
                    tile.setJumpTime(3);

                    switch(tile.getType())
                    {
                        case 21:
                            if(tile.value > 0)
                            {
                                if(mario.lev == 1)
                                {
                                    Tile.food.add(new MushRoom(tile.x,tile.y,LoadUtil.food.get(0),tile,mario));
                                }
                                else
                                {
                                    Tile.food.add(new Flower(tile.x,tile.y,LoadUtil.food.get(1),tile,mario));
                                }
                                tile.value --;
                                tile.setJumpTime(0);
                            }
                            break;

                        case 37:
                            if(tile.value > 0)
                            {
                                coins.add(new Coin(tile.x, tile.y, LoadUtil.coins.get(0), 1,mario,true));
                                tile.value --;
                                tile.setJumpTime(0);
                                mario.coin++;
                            }
                            break;

                    }





                    break;
                default:
            }


        }


        for(int i=0; i<this.ladder.size(); i++)
        {
            Ladder l = this.ladder.get(i);
            l.draw(canvas);
            Rect rect=  mario.getRect();
            float w1 = (float)(rect.right - rect.left);
            float h1 = (float)(rect.bottom - rect.top);
            int flag=l.MoreRectangle_CollisionWithSpriteXY(mario,rect);
            switch (flag){
                case 1:
                    mario.x=l.x-w1- rect.left;
                    mario.onhitLeft=true;
                    break;
                case 2:
                    float temp=l.y-h1-rect.top;
                    mario.onland=true;
                    mario.onLadderland=true;
                    mario.y=l.movedir==2?temp-2:temp+2;
                    mario.ySpeed=1;
                    break;
                case 3:
                    mario.onhitRight=true;
                    mario.x=l.x+l.image.getWidth();
                    break;
                case 4:

                    break;
                default:
            }

            l.move();

        }


        for(int i=0; i<Tile.food.size(); i++)
        {
            Sprite s = Tile.food.get(i);
            if(s.hp > 0&&s.x >= -16 && s.x <= MainActivity.ScreenWidth)
            {
                if(s instanceof Flower)
                {
                    Flower f = (Flower) s;
                    f.UpMove();
                    f.draw(canvas);
                    f.ChangeImage();
                }
                else if(s instanceof MushRoom)
                {
                    MushRoom mr = (MushRoom) s;
                    mr.Move();
                    mr.draw(canvas);
                    mr.Logic(this);
                }

                if(s.isCollsionWithRect(mario, mario.getRect()))
                {
                    mario.upLev();
                    s.hp = 0;
                }

            }
            else
            {
                Tile.food.remove(i);
            }

        }


        for(int i=0; i<this.coins.size(); i++)
        {
            Coin c = this.coins.get(i);
            if(c.hp > 0)
            {
                c.draw(canvas);
                c.Jump();
                c.ChangeImage();
                Rect rect=  mario.getRect();
                if(c.isCollsionWithRect(mario,rect)){
                    c.hp--;
                    this.mario.coin++;
                }
            }
            else
            {
                this.coins.remove(i);
            }



        }






        for(int i=0; i<this.mario.bullet.size(); i++)
        {
            Bullet b = this.mario.bullet.get(i);
            if(b.hp > 0)
            {
                b.Logic(this);
                b.DegreesPlus();
                b.draw(canvas);

            }
            else
            {
                this.mario.bullet.remove(i);
            }
        }


        for(int i=0; i<this.blast.size(); i++)
        {
            Blast b = this.blast.get(i);
            if(b.hp > 0)
            {
                b.draw(canvas);
                b.ChangeImage();
            }
            else
            {
                this.blast.remove(i);
            }
        }


        for(int i=0; i<Tile.shell.size(); i++)
        {
            Shell shell = Tile.shell.get(i);
            if(shell.hp > 0 )
            {
                shell.Draw(canvas);
                Rect rect=  mario.getRect();
                float w1 = (float)(rect.right - rect.left);
                float h1 = (float)(rect.bottom - rect.top);
                int flag=shell.MoreRectangle_CollisionWithSpriteXY(mario,rect);
                switch (flag){
                    case 1:
                        mario.goDie();
                        break;
                    case 2:
                        mario.onland=true;
                        shell.hp--;
                        mario.score+=1;
                        break;
                    case 3:
                        mario.goDie();
                        break;
                    case 4:
                        mario.onhitTop=true;
                        shell.hp--;
                        mario.score+=1;
                        break;
                    case  5:
                        mario.goDie();
                        break;
                    default:
                }
            }
            else
            {
                Tile.shell.remove(i);
            }
            shell.Move();
        }



        //地图移动

        if(status.equals("center")) {
            if((!mario.onhitLeft&&mario.xSpeed>0)|| (!mario.onhitRight&&mario.xSpeed<0) ){
                for(int i=0; i<this.map.length; i++)
                {
                    MarioMap m =this.map[i];
                    m.x-=xSpeed;
                }
                for(int i=0; i<this.b_tile.size(); i++) {
                    Tile tile = this.b_tile.get(i);
                    tile.x-=xSpeed;
                }


                for(int i=0; i<this.q_tile.size(); i++) {
                    Tile tile = this.q_tile.get(i);
                    tile.x-=xSpeed;
                }

                for(int i=0; i<this.ladder.size(); i++)
                {
                    Ladder l = this.ladder.get(i);
                    l.x-=xSpeed;
                }


                for(int i=0; i<Tile.shell.size(); i++)
                {
                    Shell shell = Tile.shell.get(i);
                    shell.x-=  xSpeed;
                }

                for(int i=0; i<this.coins.size(); i++)
                {
                    Coin c = this.coins.get(i);
                    c.x-=xSpeed;
                }


                for(int i=0; i<Tile.food.size(); i++)
                {
                    Sprite c = Tile.food.get(i);
                    c.x-=xSpeed;
                }



                for(int i=0; i<this.mario.bullet.size(); i++)
                {
                    Bullet b = this.mario.bullet.get(i);
                    b.x-=xSpeed;
                }


                for(int i=0; i<this.blast.size(); i++)
                {
                    Blast b = this.blast.get(i);
                    b.x-=xSpeed;
                }

                for(int i=0; i<this.enemy.size(); i++)
                {
                    Enemy e = this.enemy.get(i);
                    e.x-=xSpeed;

                }

            }





        }






       }




}
