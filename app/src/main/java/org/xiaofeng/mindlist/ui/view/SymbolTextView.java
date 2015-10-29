package org.xiaofeng.mindlist.ui.view;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;

/**
 * Created by xiaofeng on 10/29/15.
 */
public class SymbolTextView extends TypefaceTextView {
	public SymbolTextView(Context context) {
		super(context);
		init();
	}

	public SymbolTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public SymbolTextView(Context context, AttributeSet attrs, @AttrRes int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	public SymbolTextView(Context context, AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		init();
	}

	private void init() {
		setFont(Fonts.Material_Icons);
	}
}
