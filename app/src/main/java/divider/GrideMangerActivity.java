package divider;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.rcdemo.R;

/**
 * Describe the function of the class
 *
 * @author lemon
 * @date 2017/3/24
 * @time 10:15
 * @Email lemonqsj@163.com
 * @description Describe the place where the class needs to pay attention.
 */

public class GrideMangerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gride_list);

        RecyclerView viewById = (RecyclerView) findViewById(R.id.re);

        viewById.setLayoutManager(new GridLayoutManager(this,4,GridLayoutManager.VERTICAL,false));
        viewById.addItemDecoration(new ItemDivider().setDividerColor(Color.MAGENTA).setDividerWith(3));
        viewById.setAdapter(new myAdapter());




    }

    private class myAdapter extends RecyclerView.Adapter{
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerView.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item,parent,false)) {
            };
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            TextView tv = (TextView) holder.itemView.findViewById(R.id.text1);
            tv.setText(String.valueOf(position));
        }

        @Override
        public int getItemCount() {
            return 100;
        }
    }
}
