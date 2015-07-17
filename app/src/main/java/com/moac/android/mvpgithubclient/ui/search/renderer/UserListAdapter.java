package com.moac.android.mvpgithubclient.ui.search.renderer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.moac.android.mvpgithubclient.R;
import com.moac.android.mvpgithubclient.api.model.User;
import com.moac.android.mvpgithubclient.ui.core.view.PicassoImageLoader;

import java.util.Collections;
import java.util.List;

/**
 * @author Peter Tackage
 * @since 17/07/15
 */
public class UserListAdapter extends BaseAdapter {

    private final Context context;
    private final PicassoImageLoader picassoImageLoader;
    private List<User> items;

    public UserListAdapter(Context context, PicassoImageLoader picassoImageLoader) {
        this(context, picassoImageLoader, Collections.<User>emptyList());
    }

    public UserListAdapter(Context context, PicassoImageLoader picassoImageLoader, List<User> items) {
        this.context = context;
        this.picassoImageLoader = picassoImageLoader;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public User getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).id();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        User user = getItem(position);

        // TODO Use ViewHolder
        View view = LayoutInflater.from(context).inflate(R.layout.view_user_list_item, parent, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageView_avatar);
        TextView textView = (TextView) view.findViewById(R.id.textView_username);

        picassoImageLoader.loadCircular(user.avatarUrl(), imageView);
        textView.setText(user.login());

        return view;

    }

    public void setItems(List<User> items) {
        this.items = items;
        notifyDataSetChanged();
    }
}
