package cocomo.com.cocomoprototype;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by tungtm on 1/30/16.
 */
public class SearchActivity extends Activity {
    @Bind(R.id.edt_search)
    EditText edtSearch;
    @Bind(R.id.img_result)
    ImageView imgResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity_layout);
        ButterKnife.bind(this);

        init();
        initDrawableClick();
    }

    private void init() {
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(edtSearch.getText().toString().trim())) {
                    imgResult.setVisibility(View.VISIBLE);
                } else {
                    imgResult.setVisibility(View.GONE);
                }
            }
        });


    }

    private void initDrawableClick() {
        // catch onclick drawable
        edtSearch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (edtSearch.getRight() - edtSearch.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        // your action here
                        edtSearch.setText("");
                        return true;
                    } else if (event.getRawX() >= (edtSearch.getLeft() - edtSearch.getCompoundDrawables()[DRAWABLE_LEFT].getBounds().width())) {
//                        finish();
                    }
                }
                return false;
            }
        });
    }

}
