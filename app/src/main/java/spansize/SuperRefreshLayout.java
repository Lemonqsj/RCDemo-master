package spansize;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Describe the function of the class
 *
 * @author lemon
 * @date 2017/3/24
 * @time 17:51
 * @Email lemonqsj@163.com
 * @description Describe the place where the class needs to pay attention.
 */

public class SuperRefreshLayout extends SwipeRefreshLayout {

//    private static OnRefreshHandler onRefreshHandler;
    private static boolean isRefresh = false;
//    private Adapter adapter;
    private int mTouchSlop;
    private float mPrevX;


    public SuperRefreshLayout(Context context) {
        this(context,null);
    }

    public SuperRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        setColorSchemeColors(0xff3b93eb);
        setBackgroundColor(0xffffffff);
        float density = context.getResources().getDisplayMetrics().density;
        setProgressViewEndTarget(true,(int)(64*density+.5f));

    }

    public static abstract class supportLoadMoreAdapter extends RecyclerView.Adapter{
        static final int STATE_MORE= 0;
    }
}
