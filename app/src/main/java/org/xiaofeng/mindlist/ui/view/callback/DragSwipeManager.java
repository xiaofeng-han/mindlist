package org.xiaofeng.mindlist.ui.view.callback;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by xiaofeng on 10/31/15.
 */
public class DragSwipeManager extends ItemTouchHelper.SimpleCallback {
	public enum LayoutTypes {
		LINEAR,
		GRID
	}

	private DataSetChangeCallback dataSetChangeCallback;

	public DragSwipeManager(LayoutTypes layoutTypes) {
		super(getDragDirections(layoutTypes), getSwipeDirections(layoutTypes));
	}

	private static int getDragDirections(LayoutTypes layoutTypes) {
		int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
		switch (layoutTypes) {
			case GRID:
				dragFlags |= ItemTouchHelper.START | ItemTouchHelper.END;
		}
		return dragFlags;
	}

	private static int getSwipeDirections(LayoutTypes layoutTypes) {
		switch (layoutTypes) {
			case LINEAR:
				return ItemTouchHelper.START | ItemTouchHelper.END;
			default:
				return 0;
		}
	}

	@Override
	public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
		if (dataSetChangeCallback != null) {
			return dataSetChangeCallback.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
		}
		return false;
	}

	@Override
	public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

	}

	public DragSwipeManager setDataSetChangeCallback(DataSetChangeCallback dataSetChangeCallback) {
		this.dataSetChangeCallback = dataSetChangeCallback;
		return this;
	}
}
