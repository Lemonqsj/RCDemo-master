package divider;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.rcdemo.R;

/**
 * Created by Administrator on 2017/3/24.
 */

public class LinearMangerActivity extends AppCompatActivity {

    private RecyclerView mRc_linear;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear);

        mRc_linear = (RecyclerView) findViewById(R.id.RC_linear);
        mRc_linear.setLayoutManager(new LinearLayoutManager(this));
        mRc_linear.addItemDecoration(new ItemDivider().setDividerColor(Color.MAGENTA).setDividerWith(2));
        mRc_linear.setAdapter(new MyAdapter());


    }

    private class MyAdapter extends RecyclerView.Adapter{
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerView.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_linear_list,parent,false)){};
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            TextView tv_rc = (TextView) holder.itemView.findViewById(R.id.tv_rc);
            tv_rc.setText(String.valueOf(position));
        }

        @Override
        public int getItemCount() {
            return 100;
        }
    }
}
