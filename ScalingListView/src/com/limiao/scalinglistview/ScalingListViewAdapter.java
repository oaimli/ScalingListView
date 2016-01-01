package com.limiao.scalinglistview;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.BaseAdapter;
import android.widget.TextView;


/**
 * @author limiao
 * @time 2015年12月31日 下午3:20:50
 */
public class ScalingListViewAdapter extends BaseAdapter{

	private ArrayList<String> list;
	private Context mActivity;
	
	public ScalingListViewAdapter(ArrayList<String> list,Context mActivity){
		this.list = list;
		this.mActivity = mActivity;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return this.list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if(convertView == null){
			holder = new ViewHolder();
			convertView = LayoutInflater.from(mActivity).inflate(R.layout.list_item, null);
			holder.textView = (TextView) convertView.findViewById(R.id.tv);
			// 动画集合
			AnimationSet set = new AnimationSet(false);
			// 缩放动画
			ScaleAnimation scale = new ScaleAnimation(0.5f, 1, 0.5f, 1,
					Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
					0.5f);
			scale.setDuration(800);// 动画时间
			scale.setFillAfter(true);// 保持动画状态
			// 渐变动画
			AlphaAnimation alpha = new AlphaAnimation(0.6f, 1);
			alpha.setDuration(1000);// 动画时间
			alpha.setFillAfter(true);// 保持动画状态
			set.addAnimation(scale);
			set.addAnimation(alpha);
			holder.set = set;
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		String s = list.get(position).toString();
		holder.textView.setText(s);
		convertView.startAnimation(holder.set);
		return convertView;
	}

	private static class ViewHolder{
		TextView textView;
		AnimationSet set;
	}
}
