package com.example.androidallscreen;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
/**
 * 全屏显示android 状态栏隐藏显示
 * @author miaowei
 *
 */
public class MainActivity extends Activity {

	
	private Button mBtn_window;
	private static  boolean ISGONE = true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mBtn_window = (Button)findViewById(R.id.btn_window);
		mBtn_window.setOnClickListener(onClickListener);
		
		
		/*View decorView = getWindow().getDecorView();  
		 //Hide the status bar.  
		int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;  
		decorView.setSystemUiVisibility(uiOptions);  */
		
		
		
		/*View decorView = getWindow().getDecorView();  
		int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION  
		              | View.SYSTEM_UI_FLAG_FULLSCREEN;  
		decorView.setSystemUiVisibility(uiOptions);*/
		
	}

	
	
	private OnClickListener onClickListener = new OnClickListener() {
//		View decorView = getWindow().getDecorView();
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn_window:
				Log.i("cilp", "ISGONE====="+ISGONE);
				if (ISGONE) {
					mBtn_window.setText("显示状态栏");
					ISGONE = false;
				}else{
					mBtn_window.setText("隐藏状态栏");
					ISGONE = true;
				}
				full(ISGONE,null);
				break;

			default:
				break;
			}
			
		}
	};
	 //在 Activity.setCurrentView()之前调用  
	  public void hideStatusBar(){  
	    //隐藏标题  
	    requestWindowFeature(Window.FEATURE_NO_TITLE);  
	   //定义全屏参数  
	    int flag =WindowManager.LayoutParams.FLAG_FULLSCREEN;  
	   //获得窗口对象  
	    Window curWindow = this.getWindow();  
	   //设置Flag标示  
	    curWindow.setFlags(flag, flag);  
	  } 
	  
	  /**
	   * 显示、隐藏系统状态栏
	   * @param enable true隐藏、false显示
	   */
	  private void full(boolean enable,View view) {
		  View decorView = getWindow().getDecorView();
	        if (enable) {
	        	//隐藏状态栏
	        	int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION  
			              | View.SYSTEM_UI_FLAG_FULLSCREEN;  
			decorView.setSystemUiVisibility(uiOptions);
			
	        } else {
	        	//显示状态栏
	        	int uiOptions =  View.SYSTEM_UI_FLAG_VISIBLE;  
			    decorView.setSystemUiVisibility(uiOptions);
	        }
	    }
	  
	  /**
	   * 显示、隐藏普通状态栏
	   * @param enable
	   */
	  private void full(boolean enable) {
		  
	        if (enable) {
	            WindowManager.LayoutParams lp = getWindow().getAttributes();
	            lp.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
	            getWindow().setAttributes(lp);
	            getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
	        } else {
	            WindowManager.LayoutParams attr = getWindow().getAttributes();
	            attr.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);
	            getWindow().setAttributes(attr);
	            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
	        }
	    }
	  
	  /**
		 * 显示、隐藏系统导航栏(针对4.0以上)
		 * @param enable true隐藏、false显示
		 */
	public void firstFull(boolean enable) {
		
		ISGONE = enable;
		View decorView = getWindow().getDecorView();
		if (enable) {
			// 隐藏状态栏全屏
			int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
					| View.SYSTEM_UI_FLAG_FULLSCREEN;
			decorView.setSystemUiVisibility(uiOptions);
			
		} else {
			// 显示状态栏
			int uiOptions = View.SYSTEM_UI_FLAG_VISIBLE;
			decorView.setSystemUiVisibility(uiOptions);
		}
	}

}
