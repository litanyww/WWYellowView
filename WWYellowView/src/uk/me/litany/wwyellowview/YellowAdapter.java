package uk.me.litany.wwyellowview;
import java.util.ArrayList;
import java.util.List;

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
	List<DataSetObserver> m_observers;
	public YellowAdapter(Activity activity, int count)
	{
		this.m_count = count;
		this.m_context = activity;
		this.m_observers = new ArrayList<DataSetObserver>();
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
		return numberAsText(position + 1);
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

		if (position >= m_count - 1)
		{
			m_count += 10;
			notifyObservers();
		}

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
		for (DataSetObserver ob : m_observers)
		{
			if (ob == observer)
			{
				return;
			}
		}
		m_observers.add(observer);
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#unregisterDataSetObserver(android.database.DataSetObserver)
	 */
	@Override
	public void unregisterDataSetObserver(DataSetObserver observer) {
		m_observers.remove(observer);
	}

	private void notifyObservers()
	{
		for (DataSetObserver observer : m_observers)
		{
			observer.onChanged();
		}
	}


	public String numberAsText(int number) {
		return numberAsText(number, false);
	}

	public String numberAsText(int number, boolean concatenate) {
		String[] low = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
				"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
				"seventeen", "eighteen", "ninteen" };
		if (number == 0)
		{
			return "";
		}

		String and = "";
		if (concatenate)
		{
			and = " and ";
		}
		if (number <= low.length)
		{
			return and + low[number - 1];
		}
		if (number < 30)
		{
			return and + "twenty " + numberAsText(number - 20, false);
		}
		if (number < 40)
		{
			return and + "thirty " + numberAsText(number - 30, false);
		}
		if (number < 50)
		{
			return and + "forty " + numberAsText(number - 40, false);
		}
		if (number < 60)
		{
			return and + "fifty " + numberAsText(number - 50, false);
		}
		if (number < 70)
		{
			return and + "sixty " + numberAsText(number - 60, false);
		}
		if (number < 80)
		{
			return and + "seventy " + numberAsText(number - 70, false);
		}
		if (number < 90)
		{
			return and + "eighty " + numberAsText(number - 80, false);
		}
		if (number < 100)
		{
			return and + "ninty " + numberAsText(number - 90, false);
		}
		if (concatenate)
		{
			and = " ";
		}

		if (number < 1000)
		{
			return and + numberAsText(number / 100) + " hundred" + numberAsText(number % 100, true);
		}
		if (number < 100000)
		{
			return and + numberAsText(number / 1000) + " thousand" + numberAsText(number % 1000, true);
		}
		if (number < 100000000)
		{
			return and + numberAsText(number / 1000000) + " million" + numberAsText(number % 1000000, true);
		}
		return Integer.toString(number);
	}
}
