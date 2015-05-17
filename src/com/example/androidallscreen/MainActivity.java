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
 * ȫ����ʾandroid ״̬��������ʾ
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
					mBtn_window.setText("��ʾ״̬��");
					ISGONE = false;
				}else{
					mBtn_window.setText("����״̬��");
					ISGONE = true;
				}
				full(ISGONE,null);
				break;

			default:
				break;
			}
			
		}
	};
	 //�� Activity.setCurrentView()֮ǰ����  
	  public void hideStatusBar(){  
	    //���ر���  
	    requestWindowFeature(Window.FEATURE_NO_TITLE);  
	   //����ȫ������  
	    int flag =WindowManager.LayoutParams.FLAG_FULLSCREEN;  
	   //��ô��ڶ���  
	    Window curWindow = this.getWindow();  
	   //����Flag��ʾ  
	    curWindow.setFlags(flag, flag);  
	  } 
	  
	  /**
	   * ��ʾ������ϵͳ״̬��
	   * @param enable true���ء�false��ʾ
	   */
	  private void full(boolean enable,View view) {
		  View decorView = getWindow().getDecorView();
	        if (enable) {
	        	//����״̬��
	        	int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION  
			              | View.SYSTEM_UI_FLAG_FULLSCREEN;  
			decorView.setSystemUiVisibility(uiOptions);
			
	        } else {
	        	//��ʾ״̬��
	        	int uiOptions =  View.SYSTEM_UI_FLAG_VISIBLE;  
			    decorView.setSystemUiVisibility(uiOptions);
	        }
	    }
	  
	  /**
	   * ��ʾ��������ͨ״̬��
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
		 * ��ʾ������ϵͳ������(���4.0����)
		 * @param enable true���ء�false��ʾ
		 */
	public void firstFull(boolean enable) {
		
		ISGONE = enable;
		View decorView = getWindow().getDecorView();
		if (enable) {
			// ����״̬��ȫ��
			int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
					| View.SYSTEM_UI_FLAG_FULLSCREEN;
			decorView.setSystemUiVisibility(uiOptions);
			
		} else {
			// ��ʾ״̬��
			int uiOptions = View.SYSTEM_UI_FLAG_VISIBLE;
			decorView.setSystemUiVisibility(uiOptions);
		}
	}

}
