package devta.backbutton;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import devta.backbutton.R;

/**
 * @author Divyanshu Tayal
 */

public class BackButton extends LinearLayout {

    private Drawable backDrawable;
    private ImageView backImageView = null;
    private Context context;

    public BackButton(Context context) {
        super(context);
        initialize(context);
    }

    public BackButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BackButton);
        this.backDrawable = typedArray.getDrawable(R.styleable.BackButton_image);
        typedArray.recycle();
        initialize(context);
    }

    public BackButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BackButton);
        this.backDrawable = typedArray.getDrawable(R.styleable.BackButton_image);
        typedArray.recycle();
        initialize(context);
    }

    private void initialize(Context context){
        this.context = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_back_button, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        backImageView = (ImageView)findViewById(R.id.customBackImageView);

        if(backDrawable==null){
            backDrawable = new ColorDrawable(0xFF000000);
        }

        backImageView.setImageDrawable(backDrawable);

        backImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if(context instanceof TopBackButtonEventListener){
                    ((TopBackButtonEventListener) context).onTopBackButtonClicked();
                }
                else if(context instanceof Activity){
                        Activity activity = (Activity)context;
                        activity.finish();
                }
                else {
                    if(getActivity()!=null){
                        getActivity().finish();
                    }
                }
            }
        });
    }

    public Activity getActivity() {
        Context context = getContext();
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity)context;
            }
            context = ((ContextWrapper)context).getBaseContext();
        }
        return null;
    }

    public interface TopBackButtonEventListener{

        void onTopBackButtonClicked();

    }
}
