package com.yar.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.yar.util.AplactionUtil;
import com.yar.util.LoadUtil;

import java.util.Random;

public class SettingActivity extends Activity {
	private GridView gridView;



	private int[] ids = { 0, 1, 2, 5, 3 };
	ChangeView changeView;
	private int id;
	private boolean isStart;
	private int startTime;
	private int stopTime;
	private Adpter adpter;
	private ImageView imageView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		gridView = (GridView) findViewById(R.id.gv);
		adpter = new Adpter();
		gridView.setAdapter(adpter);

		imageView = (ImageView) findViewById(R.id.img);
		changeView = new ChangeView();

		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				if (isStart) {
					return;
				}
				if (arg2 == 4) {
					new AlertDialog.Builder(SettingActivity.this)
							.setTitle("提示")
							.setMessage("当前积分:"+ AplactionUtil.getValue(4)+",是否兑换?")
							.setPositiveButton("确定", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int whichButton) {
									stopTime = new Random().nextInt(1600 * 5) + 1600;
									new Thread(changeView).start();
									isStart = true;

								}
							})
							.setNegativeButton("取消", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int whichButton) {

								}
							})
							.show();


				}
			}

		});
	}
	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			ChangeBG(ids[id]);
			id++;
			if (id >= 5) {
				id = 0;
			}
		};
	};
	class ChangeView implements Runnable {
		@Override
		public void run() {
			//Log.i("hck", "runrun");
			handler.sendEmptyMessage(0);
			if (startTime >= stopTime) {
				handler.removeCallbacks(changeView);
				isStart = false;
				startTime = 0;
				stopTime = 0;
				startAnim();
				return;
			}
			handler.postDelayed(changeView, 100);
			startTime += 200;
		}
	}
	private void startAnim() {
		int[] oldP = new int[2];
		int[] newP = new int[2];
		gridView.getChildAt(4).getLocationOnScreen(newP);
		gridView.getChildAt(ids[id]).getLocationOnScreen(oldP);
		TranslateAnimation am = new TranslateAnimation(10, newP[0] - oldP[0],
				40, newP[1] - oldP[1]);
		// 动画开始到结束的执行时间(1000 = 1 秒)
		am.setDuration(3000);
		gridView.getChildAt(ids[id]).startAnimation(am);
		final Animation fadeIn = AnimationUtils.loadAnimation(this,
				R.anim.circle);
		imageView.setVisibility(View.VISIBLE);
		imageView.startAnimation(fadeIn);
		for (int i = 0; i < gridView.getChildCount(); i++) {
			if (i == ids[id]) {
				continue;
			} else {
				gridView.getChildAt(i).setVisibility(View.GONE);
			}
		}

		AplactionUtil.setValue2(ids[id], SettingActivity.this);


		new Handler().postDelayed(new Runnable() {
			public void run() {
				new AlertDialog.Builder(SettingActivity.this)
						.setTitle("提示")
						.setMessage("恭喜你中了")
						.setPositiveButton("确定", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {
								finish();

							}
						})
						.show();

			}
		}, 3000);



	}

	private void ChangeBG(int id) {
		for (int i = 0; i < gridView.getChildCount(); i++) {
			if (i == id) {
				((ImageView) gridView.getChildAt(id))
						.setImageBitmap(LoadUtil.study1.get(i));
			} else if (i == 4) {
				continue;
			} else {
				((ImageView) gridView.getChildAt(i))
						.setImageBitmap(LoadUtil.study0.get(i));
			}
		}
	}

	class Adpter extends BaseAdapter {

		@Override
		public int getCount() {
			return LoadUtil.study0.size();
		}

		@Override
		public Object getItem(int position) {
			return LoadUtil.study0.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			convertView = getLayoutInflater().inflate(R.layout.view_item, null);
			ImageView imageView = (ImageView) convertView
					.findViewById(R.id.image);
			imageView.setImageBitmap(LoadUtil.study0.get(position));
			return convertView;
		}

	}
}
