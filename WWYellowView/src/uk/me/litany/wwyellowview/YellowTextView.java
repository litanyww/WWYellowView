/**
 *
 */
package uk.me.litany.wwyellowview;

import android.widget.TextView;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

/**
 * @author willw
 *
 */
public class YellowTextView extends TextView {

	static Paint m_paint = null;
	String m_greyText;
	float m_previousWidth = 0;

	public YellowTextView(Context context) {
		super(context);
		this.m_greyText = null;
		this.m_previousWidth = 0;
	}

	public void setGreyText(String text, String previousText) {
		m_greyText = text;
		m_previousWidth = 0;
		if (previousText != null)
		{
			Paint p = getPaint();
			m_previousWidth = p.measureText(previousText);
		}
	}

	/** Get a common grey paint object
	 * @return an instance of Paint which paints in grey
	 */
	public static Paint getGreyPaint() {
		if (m_paint == null) {
			m_paint = new Paint();
			m_paint.setTextSize(100);
			m_paint.setARGB(0x40, 0x80, 0x80, 0x80);
			m_paint.setTypeface(Typeface.DEFAULT);
		}
		return m_paint;
	}

	/* (non-Javadoc)
	 * @see android.widget.TextView#onDraw(android.graphics.Canvas)
	 */
	protected void onDraw(Canvas canvas) {
		int width = getWidth();
		int height = getHeight();
		super.onDraw(canvas);
		if (m_greyText != null) {
			Paint p = getGreyPaint();
			float ascent = p.ascent();
			float textWidth = p.measureText(m_greyText);
			int verticalOffset = 0;
			if (m_previousWidth > width)
			{
				verticalOffset = height * 2;
			}
			else if (m_previousWidth > 0)
			{
				verticalOffset = height;
			}
			canvas.drawText(m_greyText, (float)(width - textWidth), - ascent - (float)(verticalOffset), p);
		}
	}


}
