package com.ab;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class RequestFragment extends Fragment {

    public RequestFragment() { }

    private RecyclerView requestList;
    private Context mContext;
    private SearchAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.request_fragment, container, false);
        requestList = view.findViewById(R.id.request_list);
        requestList.setLayoutManager(new LinearLayoutManager(mContext));

        getData();

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (mContext == null)
            mContext = context.getApplicationContext();
    }

    private void getData(){
        HttpHandler sh = new HttpHandler();

        ArrayList<String> idList = new ArrayList<>();
        ArrayList<String> uidList  = new ArrayList<>();
        ArrayList<String> titleList  = new ArrayList<>();
        ArrayList<String> bodyList  = new ArrayList<>();

        String url = "http://jsonplaceholder.typicode.com/posts";
        String jsonStr = sh.makeServiceCall(url);

        if (jsonStr != null) {
            try {
                JSONArray array = new JSONArray(jsonStr);
                System.out.println(array);
                for (int i = 0; i < array.length(); i++) {
                    JSONObject jsonObject = (JSONObject) array.get(i);
//                    System.out.println(jsonObject.get("id"));
                    idList.add((String) jsonObject.get("id"));
                    uidList.add((String) jsonObject.get("userId"));
                    idList.add((String) jsonObject.get("title"));
                    idList.add((String) jsonObject.get("body"));
                }

                Log.e("All ----=====---=", " "+idList.toString()+" "+uidList.toString());

                adapter = new SearchAdapter(mContext, uidList, idList, titleList, bodyList);
                requestList.setAdapter(adapter);

            } catch (final JSONException e) {
                e.printStackTrace();
            }
        }
    }
}