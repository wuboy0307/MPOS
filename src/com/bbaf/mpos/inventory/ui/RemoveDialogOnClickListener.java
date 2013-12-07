package com.bbaf.mpos.inventory.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.ListView;

public class RemoveDialogOnClickListener implements OnClickListener {

	private ListView listView;
	private InventoryActivity activity;
	
	public RemoveDialogOnClickListener(ListView listView, InventoryActivity activity) {
		this.listView = listView;
		this.activity = activity;
	}
	
	@Override
	public void onClick(DialogInterface dialog, int which) {
		for (int i = 0; i < listView.getChildCount(); i++) {
			RemovableListRow row = (RemovableListRow)listView.getChildAt(i);

			if (row.isChecked()) {
				row.remove();
			}
		}
		activity.refreshIntenvoryListView();
		activity.refreshSaleListView();
	}

}
