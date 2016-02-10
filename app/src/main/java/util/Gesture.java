package util;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by Jean-Leman on 2/5/2016.
 */
public class Gesture extends GestureDetector.SimpleOnGestureListener {

    static final String logTag = "Gesture";
    public boolean onSingleTapUp(MotionEvent ev) {
        Log.i(logTag, "SingleTap!");
        float x = ev.getX();
        float y = ev.getY();

        Log.d("Double Tap", "Tapped at: (" + x + "," + y + ")");

        return true;
    }
    public boolean onSingleTapConfirmed(){
        Log.i(logTag, "SingleTap!");
        return true;
    };

    public void onLongPress(MotionEvent ev) {
    }

    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                            float distanceY) {
        return true;
    }

    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                           float velocityY) {
        return true;
    }
}
