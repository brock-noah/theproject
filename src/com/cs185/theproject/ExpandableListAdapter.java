package com.cs185.theproject;

import android.content.Context;
import android.widget.BaseExpandableListAdapter;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;
    public static int orderCount = 0;
    public int getid = 0;

    public ExpandableListAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<String>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }
    
 // our ViewHolder.
    // caches our TextView
    static class ViewHolder {
        TextView text;
        ImageButton plus;
        ImageButton minus;

    }
  

    @Override
    public View getChildView(int groupPosition, final int childPosition,boolean isLastChild, View convertView, ViewGroup parent) {
    	 final int grpPos = groupPosition;
         final int childPos = childPosition;
        
        final String childText = (String) getChild(groupPosition, childPosition);
        
        
         final ViewHolder holder;
      
        if (convertView == null) {
            final LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item, null);
             holder = new ViewHolder();
             holder.text = (TextView) convertView.findViewById(R.id.list_item);
             holder.plus = (ImageButton) convertView.findViewById(R.id.imageButton1);
             holder.minus = (ImageButton) convertView.findViewById(R.id.imageButton2);
             convertView.setTag(holder);
        }
//        else {
//            ((ViewHolder) convertView.getTag()).text.setTag(groupPosition*100+childPosition);
//            holder = (ViewHolder) convertView.getTag();
//            getid = (Integer) holder.text.getTag();
//            System.out.println("This is it "+getid);
//            //check(getid , holder);  
//         }
        
        //((ViewHolder))
//           
        ImageButton plus = (ImageButton) convertView.findViewById(R.id.imageButton1);
        ImageButton minus = (ImageButton) convertView.findViewById(R.id.imageButton2);

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.lblListItem);
        txtListChild.setText(childText);
        plus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("plus from ExL"); 
            	//View a = infalInflater.inflate(R.layout.list_item,null);
                TextView tv = (TextView) v.findViewById(R.id.textView1);
        		orderCount++;
        		System.out.println(orderCount);
        		//tv.setText(Integer.toString(orderCount));
                
                }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	System.out.println("minus from ExL");
            	//View a = infalInflater.inflate(R.layout.list_item,null);
            	 TextView tv = (TextView) v.findViewById(R.id.textView1);
            	 if (orderCount == 0)
            	 {
            		 
            	 }
            	 else  orderCount--;

         		
        		System.out.println(orderCount);
         		//tv.setText(Integer.toString(orderCount));
                 }
        });
    

 
        return convertView;
    }
    
           
           

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }
    
 
    
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
      
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}