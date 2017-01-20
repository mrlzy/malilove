package com.yar.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.widget.Toast;

import com.yar.bean.Level;
import com.yar.bean.Mario;
import com.yar.bean.MarioMap;
import com.yar.main.MainActivity;
import com.yar.main.SettingActivity;
import com.yar.util.AplactionUtil;
import com.yar.util.LoadUtil;
import com.yar.widget.GameButton;

/**
 * Created by yar on 16-1-11.
 */
public class MarioView extends GameView implements Runnable {

    public static final int GAME_PANNEL = 0;
    public static final int GAME_ING = 1;
    public static final int GAME_WIN = 2;


    private boolean gg = false;
    private boolean gg2 = true;

    private GameButton left, right, A, B;


    private Mario mario = null;

    private int state = GAME_PANNEL;

    public MarioView(Context context) {
        super(context);
        paint.setTypeface(LoadUtil.getTypeface(context));

        mario = new Mario(context);
        //state=GAME_WIN;
        // mario.upLev();
        //mario.upLev();

        this.left = new GameButton(0, MainActivity.ScreenHeight - LoadUtil.button.get(0).getHeight() * 1.5f, LoadUtil.button.get(0));
        this.right = new GameButton(left.image.getWidth() * 2, MainActivity.ScreenHeight - LoadUtil.button.get(0).getHeight() * 1.5f, LoadUtil.button.get(1));
        this.A = new GameButton(MainActivity.ScreenWidth - LoadUtil.button.get(3).getWidth() * 2, MainActivity.ScreenHeight - LoadUtil.button.get(3).getHeight(), LoadUtil.button.get(3));
        this.B = new GameButton(MainActivity.ScreenWidth - LoadUtil.button.get(4).getWidth(), MainActivity.ScreenHeight - LoadUtil.button.get(4).getHeight() * 2, LoadUtil.button.get(4));

    }


    public void JudgmentButtonState(float x, float y, String dir) {
        if (A.OnTouch(x, y)) {
            if (dir.equals("down")) {
                this.mario.fril();
            }
        } else if (B.OnTouch(x, y)) {
            if (dir.equals("down")
                    && (this.mario.lastOnland||this.mario.onland)
                    ) {
                this.mario.ySpeed = -12;
                this.mario.onland = false;
            }
        } else if (left.OnTouch(x, y)) {
            if (dir.equals("down")) {
                this.mario.isleaf = true;
                this.mario.xSpeed = -4;
            } else {
                this.mario.xSpeed = 0;
            }
        } else if (right.OnTouch(x, y)) {
            if (dir.equals("down")) {
                this.mario.isleaf = false;
                this.mario.xSpeed = 4;
            } else {
                this.mario.xSpeed = 0;
            }
        }

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (state) {
            case GAME_PANNEL:
                this.state = GAME_ING;
                break;
            case GAME_ING:
                switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        this.JudgmentButtonState(event.getX(), event.getY(), "down");
                        break;

                    case MotionEvent.ACTION_UP:
                        this.JudgmentButtonState(event.getX(), event.getY(), "up");
                        break;

                    case MotionEvent.ACTION_POINTER_DOWN:
                        this.JudgmentButtonState(event.getX(1), event.getY(1), "down");
                        break;


                }
                break;

            case GAME_WIN:

                if (gg && gg2) {
                    gg2 = false;
                    int v = mario.coin;


                    if (!AplactionUtil.addValue(this.getContext(), v)) {
                        Toast.makeText(this.getContext(), "本月零钱存入已超过三次,此次积分无效", Toast.LENGTH_SHORT).show();
                    }

                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            new AlertDialog.Builder(getContext())
                                    .setTitle("提示")
                                    .setMessage("游戏积分兑换?")
                                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int whichButton) {
                                            Intent i = new Intent(getContext(), SettingActivity.class);
                                            getContext().startActivity(i);
                                            Activity a = (Activity) getContext();
                                            a.finish();

                                        }
                                    })
                                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int whichButton) {
                                            Activity a = (Activity) getContext();
                                            a.finish();
                                        }
                                    })
                                    .show();

                        }
                    }, 3000);

                }


                break;

            default:
                break;
        }

        return true;
    }

    public void DrawTilte() {
        paint.setColor(Color.YELLOW);
        paint.setTextSize(13);
        canvas.drawText("life : " + mario.life, 0, 20, paint);
        canvas.drawText("level : " + mario.level.level, MainActivity.ScreenWidth / 3, 20, paint);
        canvas.drawText("coin : " + mario.coin, MainActivity.ScreenWidth * 2 / 3, 20, paint);
        canvas.drawText("score : " + mario.score, MainActivity.ScreenWidth - 60, 20, paint);
    }


    public void DrawPanel() {
        if (this.state == GAME_PANNEL) {
            DrawTilte();
            Bitmap bitmap = LoadUtil.marioLogo;
            canvas.drawBitmap(bitmap,
                    MainActivity.ScreenWidth / 2 - bitmap.getWidth(),
                    MainActivity.ScreenHeight / 2 - bitmap.getHeight(),
                    paint);
            canvas.drawText("x" + mario.life, MainActivity.ScreenWidth / 2, MainActivity.ScreenHeight / 2, paint);
        } else if (this.state == GAME_WIN) {
            Bitmap bitmap = LoadUtil.marioWin;
            canvas.drawBitmap(bitmap,
                    MainActivity.ScreenWidth / 2 - 2 * bitmap.getWidth(),
                    MainActivity.ScreenHeight / 2 - bitmap.getHeight(),
                    paint);
            canvas.drawText("you are win", MainActivity.ScreenWidth / 2, MainActivity.ScreenHeight / 2, paint);
            gg = true;
        }

    }

    public void DrawGameIng() {
        if (this.state == GAME_ING) {
            this.mario.draw(canvas, paint);
            DrawTilte();
            this.left.Draw(canvas, paint);
            this.right.Draw(canvas, paint);
            this.A.Draw(canvas, paint);
            this.B.Draw(canvas, paint);

        }

    }


    public void Draw() {
        this.canvas = sh.lockCanvas();

        if (canvas != null) {
            canvas.drawColor(Color.BLACK);

            if (mario.isWin) {
                if (mario.level.level != 3) {
                    mario.goNextLevel();
                    this.state = GAME_PANNEL;
                } else {
                    this.state = GAME_WIN;

                }
            }

            if (mario.isDied) {
                if (mario.life > 0) {
                    mario.goCurrentLevel();
                    this.state = GAME_PANNEL;
                } else {
                    Activity a = (Activity) MarioView.this.getContext();
                    a.finish();
                }
            }

            DrawPanel();
            DrawGameIng();


            this.sh.unlockCanvasAndPost(canvas);
        }
    }

    @Override
    public void run() {
        while (flag) {
            Long start = System.currentTimeMillis();
            this.Draw();
            Long end = System.currentTimeMillis();
            try {
                if (end - start < 50) {
                    Thread.sleep(50 - (end - start));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        this.flag = true;
        this.t = new Thread(this);
        this.t.start();
    }


    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        this.flag = false;
    }
}
