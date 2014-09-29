package com.bocclottery.ui.adapter.mj;

import java.util.List;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bocclottery.R;
import com.bocclottery.ui.custom.list.ListItemImpl;
import com.bocclottery.ui.custom.list.MspAdapter;
import com.bocclottery.utils.ImageLoaderHelper;
import com.bocclottery.utils.ImageLoaderHelper.DisplayOptionType;
import com.bocclottery.vo.lii.LiiCoupon;


public class ListAdapterCompany extends MspAdapter {
	public class ViewHolder extends ViewHolderImpl{
		ImageView icimg;
		TextView cname;
		TextView major;
		TextView purchase;
		
		@Override
		public int getLayoutId() {
			return R.layout.layout_item_hot;
		}

		@Override
		public void init() {
			  icimg = (ImageView)getHolderView().findViewById(R.id.img_item_hot);
			  cname = (TextView)getHolderView().findViewById(R.id.tv_item_hot_name);
			  major = (TextView)getHolderView().findViewById(R.id.tv_item_hot_desc);
			  purchase = (TextView)getHolderView().findViewById(R.id.tv_item_hot_desc2);
			  getHolderView().findViewById(R.id.btn_item_hot_go).setVisibility(View.GONE);
			  getHolderView().findViewById(R.id.btn_item_hot_in).setVisibility(View.GONE);
		}

		@Override
		public void setup(int position) {
			LiiCoupon ssi = getItem(position);
//			ImageLoaderHelper.imageLoader.displayImage(ssi.getShopLogoImage(), icimg, ImageLoaderHelper.getDisplayOpts(DisplayOptionType.DEFAULT));
//            cname.setText(ssi.getShopName());
//            if(!ssi.getMainProducts().isEmpty())major.setText("主营业务/服务: "+ssi.getMainProducts());
//            if(!ssi.getCompPurchaseProduct().isEmpty())purchase.setText("采购信息: "+ssi.getCompPurchaseProduct());
		}
		
	}

	public ListAdapterCompany() {
		super( );
	}
	public ListAdapterCompany(List<ListItemImpl> contentList) {
		super(contentList);
	}
	
	@Override
	public ViewHolderImpl getHolderInstance() {
		return new ViewHolder();
	}

	@Override
	public LiiCoupon getItem(int position) {
		return (LiiCoupon)super.getItem(position);
	}

	

}
