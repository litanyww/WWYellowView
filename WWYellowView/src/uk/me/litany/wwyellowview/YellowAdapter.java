package uk.me.litany.wwyellowview;
import android.database.DataSetObserver;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.content.Context;
import android.app.Activity;

/**
 * 
 */

/**
 * @author willw
 *
 */
public class YellowAdapter implements ListAdapter {

	int m_count;
	Context m_context;
	public YellowAdapter(Activity activity, int count)
	{
		this.m_count = count;
		this.m_context = activity;
	}
	
	/* (non-Javadoc)
	 * @see android.widget.ListAdapter#isEnabled(int)
	 */
	@Override
	public boolean isEnabled(int item)
	{
		return true;
	}
	
	/* (non-Javadoc)
	 * @see android.widget.ListAdapter#areAllItemsEnabled()
	 */
	@Override
	public boolean areAllItemsEnabled()
	{
		return false;
	}
	
	/* (non-Javadoc)
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return m_count;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int position) {
		return numberAsText(position);
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int position) {
		return position;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItemViewType(int)
	 */
	@Override
	public int getItemViewType(int position) {
		return 0;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		YellowTextView yellow = null;
		if (convertView != null)
		{
			yellow = (YellowTextView)convertView;
		}
		else
		{
			yellow = new YellowTextView(m_context);
			yellow.setTextSize(22);
		}
		yellow.setText((String)getItem(position));
		return yellow;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getViewTypeCount()
	 */
	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return 1;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#hasStableIds()
	 */
	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return true;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (m_count > 0);
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#registerDataSetObserver(android.database.DataSetObserver)
	 */
	@Override
	public void registerDataSetObserver(DataSetObserver observer) {
		// do nothing because our data never changes
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#unregisterDataSetObserver(android.database.DataSetObserver)
	 */
	@Override
	public void unregisterDataSetObserver(DataSetObserver observer) {
		// do nothing because we never recorded the observer
	}
	
	public String numberAsText(int number) {
		String[] low = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
				"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
				"seventeen", "eighteen", "ninteen" };
		if (number == 0)
		{
			return "";
		}
		else if (number <= low.length)
		{
			return low[number - 1];
		}
		if (number < 30)
		{
			return "twenty " + numberAsText(number - 20);
		}
		if (number < 40)
		{
			return "thirty " + numberAsText(number - 30);
		}
		if (number < 50)
		{
			return "forty " + numberAsText(number - 40);
		}
		if (number < 60)
		{
			return "fifty " + numberAsText(number - 50);
		}
		if (number < 70)
		{
			return "sixty " + numberAsText(number - 60);
		}
		if (number < 80)
		{
			return "seventy " + numberAsText(number - 70);
		}
		if (number < 90)
		{
			return "eighty " + numberAsText(number - 80);
		}
		if (number < 100)
		{
			return "ninty " + numberAsText(number - 90);
		}
		if (number < 100000)
		{
			String hundreds = numberAsText(number / 1000) + " hundred";
			String remainder = numberAsText(number % 1000);
			if (remainder != "")
			{
				return hundreds + " and " + remainder;
			}
			return hundreds;
		}
		if (number < 100000000)
		{
			String millions = numberAsText(number / 1000000) + " million";
			String remainder = numberAsText(number % 1000000);
			if (remainder != "")
			{
				return millions + " and " + remainder;
			}
			return millions;
		}
		return Integer.toString(number);
	}
}
