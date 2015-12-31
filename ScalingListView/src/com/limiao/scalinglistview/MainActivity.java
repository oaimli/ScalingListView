package com.limiao.scalinglistview;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;

/**
 * 
 * @author limiao
 * @time 2015年12月31日 下午7:47:12
 */
public class MainActivity extends Activity{

	ListView listView;
	ArrayList<String> list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		listView = (ListView) findViewById(R.id.scalingListView);
		list = new ArrayList<>();
		for(int i=0;i<50;i++){
			list.add("ScalingListView"+i);
		}
		ScalingListViewAdapter adapter = new ScalingListViewAdapter(list, this);
		listView.setAdapter(adapter);
		listView.setDivider(null);
	}

}
