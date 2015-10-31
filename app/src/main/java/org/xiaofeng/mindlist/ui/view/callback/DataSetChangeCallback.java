package org.xiaofeng.mindlist.ui.view.callback;

/**
 * Created by xiaofeng on 10/31/15.
 */
public interface DataSetChangeCallback {
	boolean onItemMove(int fromPos, int toPos);
	void onItemRemove(int pos);
}
