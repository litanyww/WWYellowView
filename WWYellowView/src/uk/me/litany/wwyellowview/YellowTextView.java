/**
 * 
 */
package uk.me.litany.wwyellowview;

import android.widget.TextView;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Paint;

/**
 * @author willw
 *
 */
public class YellowTextView extends TextView {

	Paint m_paint;
	
	public YellowTextView(Context context) {
		super(context);
		m_paint = new Paint();
		m_paint.setStrokeWidth(2);
		m_paint.setARGB(0xff, 0xff, 0, 0xff);
	}
	
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		int width = getWidth();
		int height = getHeight();
		
		// and now, draw a nice yellow line across our view.
		canvas.drawLine((float)0, (float)0, (float)width, (float)height, m_paint);
	}
	
	
}
