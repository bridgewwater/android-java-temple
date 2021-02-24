package com.sinlov.temp.android.utils;

import android.view.View;
import android.view.View.OnClickListener;

public abstract class SingleClickListener implements OnClickListener {

	private boolean isClicked;

	public boolean isClicked() {
		return isClicked;
	}

	public void canClick() {
		this.isClicked = false;
	}

	public void canNotClick() {
		this.isClicked = true;
	}

	/**
	 *
	 * doSingleClick for single click click for use
	 *
	 * <br/>
	 * Created by "sinlov" Sep 24, 2016 3:33:49 PM
	 *
	 * @param v {@link View}
	 * @return true is can not click false is change to click
	 */
	public abstract boolean doSingleClick(View v);

	/**
	 * <p>
	 * Title: onClick
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 *
	 * @param v
	 *            true is can not click false is change to click
	 * @see OnClickListener#onClick(View)
	 */
	@Override
	public void onClick(View v) {
		if (!isClicked) {
			isClicked = doSingleClick(v);
		}
	}

	/**
	 * true is can not click false is change to click
	 *
	 * SingleClickListener <br/>
	 * Created by "sinlov" Sep 24, 2016 3:32:05 PM
	 *
	 * @param isClicked boolean
	 */
	public SingleClickListener(boolean isClicked) {
		super();
		this.isClicked = isClicked;
	}
}
