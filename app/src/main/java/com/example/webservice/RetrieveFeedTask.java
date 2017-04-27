package com.example.webservice;

/**
 * Created by chen on 2/7/2017.
 */


import android.content.Context;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.chen.barcodescanner.ItemListAdapter;
import com.example.chen.barcodescanner.R;

import java.util.List;

public class RetrieveFeedTask extends AsyncTask<Void, Void, List<Model>> {

    private String query;
    private ListView listView;
    private Context context;

    private ItemListAdapter listAdapter;
//    private cart cart;

    private ImageView imageView;

    public RetrieveFeedTask(Context context, String query, ListView listView) {
        this.query = query;
        this.listView = listView;
        this.context = context;
    }


    @Override
    protected List<Model> doInBackground(Void... params) {
        List<Model> items = null;
        RequestDispatcher rDis = RequestDispatcher.getInstance();
        items = rDis.SendRquests(query);
        return items;
    }

    @Override
    protected void onPostExecute(List<Model> models) {
        super.onPostExecute(models);
        ItemListAdapter adapter1 = new ItemListAdapter(context, R.layout.row, models);

        listView.setAdapter(adapter1);


    }
}
