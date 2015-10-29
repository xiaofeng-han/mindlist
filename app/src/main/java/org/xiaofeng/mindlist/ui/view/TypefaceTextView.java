package org.xiaofeng.mindlist.ui.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.AttrRes;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.widget.TextView;

import org.xiaofeng.mindlist.R;

/**
 * Created by xiaofeng on 10/29/15.
 */
public class TypefaceTextView extends TextView {
	public static enum Fonts {
		Material_Icons(0, "fonts/micons.ttf");
		public final int id;
		public final String path;
		Fonts(int id, String path) {
			this.id = id;
			this.path = path;
		}

		public static Fonts fromId(int id) {
			for (Fonts fonts : Fonts.values()) {
				if (id == fonts.id) {
					return fonts;
				}
			}
			return null;
		}
	}
	public TypefaceTextView(Context context) {
		super(context);
	}

	public TypefaceTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(attrs, 0, 0);
	}

	public TypefaceTextView(Context context, AttributeSet attrs, @AttrRes int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(attrs, defStyleAttr, 0);
	}

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	public TypefaceTextView(Context context, AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		init(attrs, defStyleAttr, defStyleRes);
	}

	private void init(AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
		TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.TypefaceTextView, defStyleAttr, defStyleRes);
		int fontId = typedArray.getInt(R.styleable.TypefaceTextView_font, -1);
		typedArray.recycle();
		setFont(Fonts.fromId(fontId));
	}

	public void setFont(Fonts fonts) {
		if (fonts == null) {
			return;
		}

		setTypeface(Typeface.createFromAsset(getContext().getAssets(), fonts.path));
	}
}
