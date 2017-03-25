package divider;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import com.example.administrator.rcdemo.R;

/**
 * Describe the function of the class
 *
 * @author lemon
 * @date 2017/3/24
 * @time 10:43
 * @Email lemonqsj@163.com
 * @description Describe the place where the class needs to pay attention.
 */

public class StickyView extends RecyclerView {

    private int lineHeight,titleHeight;
    private int lineColor,titleColor,titleTextColor;

    public StickyView(Context context) {
        this(context,null);
    }

    public StickyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public StickyView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.StickyRecyclerView);

        lineHeight=typedArray.getDimensionPixelOffset(R.styleable.StickyRecyclerView_dividerHeight,1);
        titleHeight=typedArray.getDimensionPixelOffset(R.styleable.StickyRecyclerView_titleHeight,dp2px(context,35));
        lineColor = typedArray.getColor(R.styleable.StickyRecyclerView_dividerColor, Color.LTGRAY);
        titleColor = typedArray.getColor(R.styleable.StickyRecyclerView_titleColor,Color.LTGRAY);
        titleTextColor=typedArray.getColor(R.styleable.StickyRecyclerView_titleTextColor,Color.BLUE);

        typedArray.recycle();

        setLayoutManager(new LinearLayoutManager(context));
    }




    public int dp2px(Context context,float dpValue){
        float density = context.getResources().getDisplayMetrics().density;

        return (int) (density*dpValue+.5f);
    }

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
    }


    public void setAdapter(StickyAdapter adapter) {
        addItemDecoration(new StickyDivider(adapter));
        super.setAdapter(adapter);
    }


    /**
     * 自定义分割线
     */

    private class StickyDivider extends ItemDecoration{


        private StickyAdapter mStickyAdapter;
        private Paint mPaint;

        public StickyDivider(StickyAdapter stickyAdapter) {
           this.mStickyAdapter = stickyAdapter;
            mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setTextSize(titleHeight*.5f);
        }

        /**
         * 计算Item之间的间隔,是普通的Item还是需要绘制title的Item
         * @param outRect
         * @param view
         * @param parent
         * @param state
         *
         *
         * 通过此方法可以得到一个子View在界面中显示的位置
         * ((LayoutParams)view.getLayoutParams()).getViewLayoutPosition())
         */
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, State state) {
            super.getItemOffsets(outRect, view, parent, state);

            if (!mStickyAdapter.needTitle(((LayoutParams)view.getLayoutParams()).getViewLayoutPosition())){
                outRect.top = lineHeight;
            }else {
                outRect.top = titleHeight;
            }
        }

        /**
         * 绘制分栏的title
         * @param c
         * @param parent
         * @param state
         */
        @Override
        public void onDraw(Canvas c, RecyclerView parent, State state) {
            super.onDraw(c, parent, state);

            int left  = parent.getPaddingLeft();
            int right = parent.getMeasuredWidth() - parent.getPaddingRight();
            int count = parent.getChildCount();
            for (int i = 0; i < count; i++) {
                View child = parent.getChildAt(i);
                int position = ((LayoutParams)child.getLayoutParams()).getViewLayoutPosition();
                int bottom  = child.getTop()-((LayoutParams)child.getLayoutParams()).topMargin;

                if (!mStickyAdapter.needTitle(position)){
                    int top = bottom-lineHeight;
                    mPaint.setColor(lineColor);
                    c.drawRect(left,top,right,bottom,mPaint);
                }else {
                    int top = bottom - titleHeight;
                    mPaint.setColor(titleColor);
                    c.drawRect(left,top,right,bottom,mPaint);
                    if (!TextUtils.isEmpty(mStickyAdapter.getItemViewTitle(position))){
                        mPaint.setColor(titleTextColor);
                        c.drawText(mStickyAdapter.getItemViewTitle(position),left+titleHeight*0.25f,bottom-titleHeight*0.25f,mPaint);
                    }

                }

            }

        }

        /**
         * 绘制悬停的标题栏
         * @param c
         * @param parent
         * @param state
         */
        @Override
        public void onDrawOver(Canvas c, RecyclerView parent, State state) {
            super.onDrawOver(c, parent, state);

            int left = parent.getPaddingLeft();
            int right = parent.getMeasuredWidth()-parent.getPaddingRight();
            int top = parent.getPaddingTop();
            int bottom = top+titleHeight;
            mPaint.setColor(titleColor);
            c.drawRect(left,top,right,bottom,mPaint);
            int pos = ((LinearLayoutManager)(parent.getLayoutManager())).findFirstVisibleItemPosition();
//            int position = ((LinearLayoutManager)(parent.getLayoutManager())).findFirstVisibleItemPosition();

            if (!TextUtils.isEmpty(mStickyAdapter.getItemViewTitle(pos))){
                mPaint.setColor(titleTextColor);
                c.drawText(mStickyAdapter.getItemViewTitle(pos),left+titleHeight*.25f,bottom-titleHeight*.25f,mPaint);
            }
        }
    }

    public static abstract class StickyAdapter extends Adapter{
        //获取当前的标题

        public  abstract String getItemViewTitle(int position);

        //确定是否要绘制,若是一样的就不绘制了,若是不一样则需要绘制

        public boolean needTitle(int position){
            return position>-1&&(position==0||!getItemViewTitle(position).equals(getItemViewTitle(position-1)));
        }
    }
}
