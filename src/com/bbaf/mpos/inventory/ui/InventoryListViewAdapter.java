package com.bbaf.mpos.inventory.ui;

import java.util.ArrayList;
import java.util.zip.Inflater;

import com.bbaf.mpos.R;
import com.bbaf.mpos.FacadeController.Register;
import com.bbaf.mpos.ProductDescription.ProductDescription;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class InventoryListViewAdapter extends BaseAdapter {
	
	private Activity activity;
	private ArrayList<ProductDescription> productList;

	public InventoryListViewAdapter(Activity activity) {
		this.activity = activity;
		this.productList = Register.getInstance().getInventory().getAllProduct();
	}

	@Override
	public int getCount() {
		return productList.size();
	}

	@Override
	public Object getItem(int position) {
		return productList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return new InventoryListRow(activity, productList.get(position));
	}

	public void notifyDataSetChanged() {
		productList = Register.getInstance().getInventory().getAllProduct();
		super.notifyDataSetChanged();
	}
	
	public void notifyDataSetChanged(ArrayList<ProductDescription> productList) {
		this.productList = productList;
		super.notifyDataSetChanged();
	}
	
	
}