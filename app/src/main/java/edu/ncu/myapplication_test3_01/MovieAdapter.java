package edu.ncu.myapplication_test3_01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MovieAdapter extends ArrayAdapter<Movie> {

    private int resourceId;

    //将上下文、ListView子项布局的id、数据 传递进来
    public MovieAdapter(Context context, int textViewResourceId, List<Movie> obj) {
        super(context, textViewResourceId, obj);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Movie movie = getItem(position);//获取当前项的movie实例
        //LayoutInflater的inflate()方法接收3个参数：需要实例化布局资源的id、ViewGroup类型视图组对象、false
        //false表示只让父布局中声明的layout属性生效，但不会为这个view添加父布局
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        //获取实例
        ImageView image = (ImageView) view.findViewById(R.id.movieImage);
        TextView name = (TextView) view.findViewById(R.id.movieName);
        TextView description = (TextView) view.findViewById(R.id.movieDescription);
        //设置图片和文字
        image.setImageResource(movie.getCoverId());
        name.setText(movie.getName());
        description.setText(movie.getDescription());

        return view;
    }

}
