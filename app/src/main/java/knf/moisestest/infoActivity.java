package knf.moisestest;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Jordy on 19/05/2017.
 */

public class infoActivity extends AppCompatActivity {

    FloatingActionButton button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            supportPostponeEnterTransition();
        setContentView(R.layout.layout_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        button = (FloatingActionButton) findViewById(R.id.fab);
        button.hide();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimary));
        }
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getIntent().getExtras().getString("name", "No Name"));
        setChildTextView(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        ((ImageView) findViewById(R.id.img)).setImageResource(getIntent().getExtras().getInt("img", R.drawable.not_found));
        ((TextView) findViewById(R.id.description)).setText(getIntent().getExtras().getInt("desc", R.string.no_desc));
        showCard();
    }

    @TargetApi(21)
    private void setChildTextView(Toolbar toolbar) {
        int count = toolbar.getChildCount();
        for (int i = 0; i < count; i++) {
            if (toolbar.getChildAt(i) instanceof TextView) {
                toolbar.getChildAt(i).setTransitionName("name");
                supportStartPostponedEnterTransition();
            }
        }
    }

    private void showCard() {
        Animation bottomUp = AnimationUtils.loadAnimation(this, R.anim.slide_from_bottom);
        bottomUp.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        button.show();
                    }
                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        CardView cardView = (CardView) findViewById(R.id.card);
        cardView.startAnimation(bottomUp);
        cardView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                button.setVisibility(View.GONE);
            }
        });
        super.onBackPressed();
    }
}
