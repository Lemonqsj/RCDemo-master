package divider;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2017/3/24.
 */

public class ItemDivider extends RecyclerView.ItemDecoration {

    private int dividerWith = 1;
    private Paint                      paint;
    private RecyclerView.LayoutManager layoutManager;

    public ItemDivider (){
        initPaint();
        paint.setColor(0xfff0f0f0);
    }

    private void initPaint() {
        if (paint==null){
            paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint.setStyle(Paint.Style.FILL);

        }
    }

    public ItemDivider setDividerWith(int dividerWith) {
        this.dividerWith = dividerWith;
        return this;
    }

    public ItemDivider setDividerColor(int color) {
        initPaint();
        paint.setColor(color);
        return this;
    }


    /**
     * 指定Item之间的距离（也就是分割线之间的距离）
     * @param outRect
     * @param view
     * @param parent
     * @param state
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        if (layoutManager==null){
            layoutManager= parent.getLayoutManager();
        }

        if (layoutManager instanceof LinearLayoutManager){
            int orientation = ((LinearLayoutManager) layoutManager).getOrientation();

            if (orientation == LinearLayout.HORIZONTAL){
                outRect.right = dividerWith;
            }else if (orientation==LinearLayout.VERTICAL){
                outRect.bottom=dividerWith;
            }

            if (layoutManager instanceof GridLayoutManager){
                GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
                // 如果是 GridLayoutManager 则需要绘制另一个方向上的分割线
                if (orientation == LinearLayoutManager.VERTICAL && layoutParams != null && layoutParams.getSpanIndex() > 0) {
                    // 如果列表是垂直方向,则最左边的一列略过
                    outRect.left = dividerWith;
                } else if (orientation == LinearLayoutManager.HORIZONTAL && layoutParams != null && layoutParams.getSpanIndex() > 0) {
                    // 如果列表是水平方向,则最上边的一列略过
                    outRect.top = dividerWith;
                }



            }
        }
    }

    /**
     * Item绘制之前调用，一般分割线在这里绘制
     * @param c
     * @param parent
     * @param state
     */

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);

        int offset = (int) Math.ceil(dividerWith*1f/2);

        for (int i = 0; i < parent.getChildCount(); i++) {
            View childAt = parent.getChildAt(i);

            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            int left1 = childAt.getRight()+layoutParams.rightMargin;
            int right1 = left1+dividerWith;
            int top1 = childAt.getTop() - offset - layoutParams.topMargin;
            int bottom1 = childAt.getBottom() + offset + layoutParams.bottomMargin;
            //绘制分割线(矩形)
            c.drawRect(left1, top1, right1, bottom1, paint);


            int left2 = childAt.getLeft() - offset - layoutParams.leftMargin;
            int right2 = childAt.getRight() + offset + layoutParams.rightMargin;
            int top2 = childAt.getBottom() + layoutParams.bottomMargin;
            int bottom2 = top2 + dividerWith;
            //绘制分割线(矩形)
            c.drawRect(left2, top2, right2, bottom2, paint);

        }
    }

    /**
     * 在Item绘制之后调用(就是绘制在 item 的上层)
     * 也可以在这里绘制分割线,和上面的方法 二选一
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }
}
