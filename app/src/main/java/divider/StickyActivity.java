package divider;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.rcdemo.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Describe the function of the class
 *
 * @author lemon
 * @date 2017/3/24
 * @time 10:41
 * @Email lemonqsj@163.com
 * @description Describe the place where the class needs to pay attention.
 *
 * 1. 通过自定义View的方式实现,通过复写父类recyclerView方法的方式,扩展了了adapter的作用,
 * 2. 通过复写此方法addItemDecoration(new StickyDivider(adapter));可以添加分割线,继承ItemDecoration复写方法添加分割线,回调里面的onDraw和onDrawOver就可以绘制得到;
 */

public class StickyActivity extends AppCompatActivity {

    private StickyView mViewById;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sticky);

        mViewById = (StickyView) findViewById(R.id.re);
        myAdapter stickyAdapter = new myAdapter();
        mViewById.setAdapter(stickyAdapter);

        List<Area> areas = Arrays.asList(new Gson().fromJson(a,Area[].class));
        stickyAdapter.setDatas(areas);

    }


    private class myAdapter extends StickyView.StickyAdapter{

        List<Area> datas = new ArrayList<>();

        public void setDatas(List<Area> data){
            this.datas.clear();
            if (datas!=null){
                this.datas.addAll(data);
            }
            notifyDataSetChanged();
        }
        @Override
        public String getItemViewTitle(int position) {
            return String.valueOf(datas.get(position).shuruma.charAt(0));
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerView.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_linear_list,parent,false)) {
            };
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            TextView viewById = (TextView) holder.itemView.findViewById(R.id.tv_rc);
            viewById.setText(datas.get(position).area_name);
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }
    }





    private String a = "[{\"area_code\":\"330522\",\"area_name\":\"长兴\",\"city_code\":null," +
            "\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":" +
            "\"2\",\"quyubh\":\"910500000000960098\",\"pingtaibh\":\"910500000000960097\",\"ZHUANGTAI\":null,\"shuruma\":\"ZXS\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"330183\",\"area_name\":\"富阳\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"100000000000000001\",\"pingtaibh\":\"10001\",\"ZHUANGTAI\":null,\"shuruma\":\"FYS\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"360201\",\"area_name\":\"景德镇\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"910500000000040015\",\"pingtaibh\":\"10007\",\"ZHUANGTAI\":null,\"shuruma\":\"JDZ\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"331081\",\"area_name\":\"温岭\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"900500000008710874\",\"pingtaibh\":\"10006\",\"ZHUANGTAI\":null,\"shuruma\":\"WL\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"430321\",\"area_name\":\"湘潭\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"900500000006000665\",\"pingtaibh\":\"900500000005995269\",\"ZHUANGTAI\":null,\"shuruma\":\"XTS\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"320582\",\"area_name\":\"张家港\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"910500000000040013\",\"pingtaibh\":\"10004\",\"ZHUANGTAI\":null,\"shuruma\":\"ZJG\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"330522\",\"area_name\":\"长兴\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"910500000000960098\",\"pingtaibh\":\"910500000000960097\",\"ZHUANGTAI\":null,\"shuruma\":\"ZXS\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"330183\",\"area_name\":\"富阳\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"100000000000000001\",\"pingtaibh\":\"10001\",\"ZHUANGTAI\":null,\"shuruma\":\"FYS\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"360201\",\"area_name\":\"景德镇\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"910500000000040015\",\"pingtaibh\":\"10007\",\"ZHUANGTAI\":null,\"shuruma\":\"JDZ\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"331081\",\"area_name\":\"温岭\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"900500000008710874\",\"pingtaibh\":\"10006\",\"ZHUANGTAI\":null,\"shuruma\":\"WL\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"430321\",\"area_name\":\"湘潭\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"900500000006000665\",\"pingtaibh\":\"900500000005995269\",\"ZHUANGTAI\":null,\"shuruma\":\"XTS\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"320582\",\"area_name\":\"张家港\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"910500000000040013\",\"pingtaibh\":\"10004\",\"ZHUANGTAI\":null,\"shuruma\":\"ZJG\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"330522\",\"area_name\":\"长兴\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"910500000000960098\",\"pingtaibh\":\"910500000000960097\",\"ZHUANGTAI\":null,\"shuruma\":\"ZXS\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"330183\",\"area_name\":\"富阳\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"100000000000000001\",\"pingtaibh\":\"10001\",\"ZHUANGTAI\":null,\"shuruma\":\"FYS\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"360201\",\"area_name\":\"景德镇\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"910500000000040015\",\"pingtaibh\":\"10007\",\"ZHUANGTAI\":null,\"shuruma\":\"JDZ\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"331081\",\"area_name\":\"温岭\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"900500000008710874\",\"pingtaibh\":\"10006\",\"ZHUANGTAI\":null,\"shuruma\":\"WL\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"430321\",\"area_name\":\"湘潭\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"900500000006000665\",\"pingtaibh\":\"900500000005995269\",\"ZHUANGTAI\":null,\"shuruma\":\"XTS\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"320582\",\"area_name\":\"张家港\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"910500000000040013\",\"pingtaibh\":\"10004\",\"ZHUANGTAI\":null,\"shuruma\":\"ZJG\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"330522\",\"area_name\":\"长兴\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"910500000000960098\",\"pingtaibh\":\"910500000000960097\",\"ZHUANGTAI\":null,\"shuruma\":\"ZXS\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"330183\",\"area_name\":\"富阳\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"100000000000000001\",\"pingtaibh\":\"10001\",\"ZHUANGTAI\":null,\"shuruma\":\"FYS\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"360201\",\"area_name\":\"景德镇\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"910500000000040015\",\"pingtaibh\":\"10007\",\"ZHUANGTAI\":null,\"shuruma\":\"JDZ\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"331081\",\"area_name\":\"温岭\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"900500000008710874\",\"pingtaibh\":\"10006\",\"ZHUANGTAI\":null,\"shuruma\":\"WL\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"430321\",\"area_name\":\"湘潭\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"900500000006000665\",\"pingtaibh\":\"900500000005995269\",\"ZHUANGTAI\":null,\"shuruma\":\"XTS\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"320582\",\"area_name\":\"张家港\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"910500000000040013\",\"pingtaibh\":\"10004\",\"ZHUANGTAI\":null,\"shuruma\":\"ZJG\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"330522\",\"area_name\":\"长兴\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"910500000000960098\",\"pingtaibh\":\"910500000000960097\",\"ZHUANGTAI\":null,\"shuruma\":\"ZXS\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"330183\",\"area_name\":\"富阳\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"100000000000000001\",\"pingtaibh\":\"10001\",\"ZHUANGTAI\":null,\"shuruma\":\"FYS\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"360201\",\"area_name\":\"景德镇\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"910500000000040015\",\"pingtaibh\":\"10007\",\"ZHUANGTAI\":null,\"shuruma\":\"JDZ\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"331081\",\"area_name\":\"温岭\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"900500000008710874\",\"pingtaibh\":\"10006\",\"ZHUANGTAI\":null,\"shuruma\":\"WL\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"430321\",\"area_name\":\"湘潭\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"900500000006000665\",\"pingtaibh\":\"900500000005995269\",\"ZHUANGTAI\":null,\"shuruma\":\"XTS\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"320582\",\"area_name\":\"张家港\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"910500000000040013\",\"pingtaibh\":\"10004\",\"ZHUANGTAI\":null,\"shuruma\":\"ZJG\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"330522\",\"area_name\":\"长兴\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"910500000000960098\",\"pingtaibh\":\"910500000000960097\",\"ZHUANGTAI\":null,\"shuruma\":\"ZXS\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"330183\",\"area_name\":\"富阳\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"100000000000000001\",\"pingtaibh\":\"10001\",\"ZHUANGTAI\":null,\"shuruma\":\"FYS\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"360201\",\"area_name\":\"景德镇\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"910500000000040015\",\"pingtaibh\":\"10007\",\"ZHUANGTAI\":null,\"shuruma\":\"JDZ\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"331081\",\"area_name\":\"温岭\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"900500000008710874\",\"pingtaibh\":\"10006\",\"ZHUANGTAI\":null,\"shuruma\":\"WL\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"430321\",\"area_name\":\"湘潭\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"900500000006000665\",\"pingtaibh\":\"900500000005995269\",\"ZHUANGTAI\":null,\"shuruma\":\"XTS\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"320582\",\"area_name\":\"张家港\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"910500000000040013\",\"pingtaibh\":\"10004\",\"ZHUANGTAI\":null,\"shuruma\":\"ZJG\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"330522\",\"area_name\":\"长兴\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"910500000000960098\",\"pingtaibh\":\"910500000000960097\",\"ZHUANGTAI\":null,\"shuruma\":\"ZXS\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"330183\",\"area_name\":\"富阳\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"100000000000000001\",\"pingtaibh\":\"10001\",\"ZHUANGTAI\":null,\"shuruma\":\"FYS\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"360201\",\"area_name\":\"景德镇\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"910500000000040015\",\"pingtaibh\":\"10007\",\"ZHUANGTAI\":null,\"shuruma\":\"JDZ\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"331081\",\"area_name\":\"温岭\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"900500000008710874\",\"pingtaibh\":\"10006\",\"ZHUANGTAI\":null,\"shuruma\":\"WL\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"430321\",\"area_name\":\"湘潭\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"900500000006000665\",\"pingtaibh\":\"900500000005995269\",\"ZHUANGTAI\":null,\"shuruma\":\"XTS\",\"zhuangtai\":\"1\",\"IncreasingSort\":true},{\"area_code\":\"320582\",\"area_name\":\"张家港\",\"city_code\":null,\"city\":null,\"province\":\"100000\",\"medical_join_code\":null,\"XINGZHENGJB\":\"2\",\"quyubh\":\"910500000000040013\",\"pingtaibh\":\"10004\",\"ZHUANGTAI\":null,\"shuruma\":\"ZJG\",\"zhuangtai\":\"1\",\"IncreasingSort\":true}]";
}
